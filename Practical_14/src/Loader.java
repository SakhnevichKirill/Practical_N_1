import java.util.ArrayList;
import java.util.Random;

public class Loader {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int j = 0;j < 1000; j++) {
            Account acc = new Account(new Random().nextInt(100000), j);
            bank.addAccount(acc);
        }

        long sumBefore = 0;
        for (int i = 0; i < 1000; i++) {
            sumBefore+=bank.getBalance(i);
        }

        for (int i = 0; i < 8; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 500; j++) {
                    Account from = bank.accounts.get(new Random().nextInt(999));
                    Account to = bank.accounts.get(new Random().nextInt(999));
                    try {
                        //System.out.println("Acc " + from.getAccNumber() + " trying transfer money to " + to.getAccNumber());
                        bank.transfer(from.getAccNumber(), to.getAccNumber(), new Random().nextInt(65000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
            threads.get(i).start();
        }


        for (Thread thread: threads) {
            try {
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long sumAfter = 0;
        for (int i = 0; i < 1000; i++) {
            sumAfter += bank.getBalance(i);
        }

        if (sumBefore == sumAfter) System.out.println("Суммы сошлись.");
        else System.out.println("Суммы не сошлись!");
    }
}
