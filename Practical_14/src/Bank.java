import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private static AtomicLong sum = new AtomicLong();
    HashMap<Integer, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public int transfer(int accFrom, int accTo, int money) throws InterruptedException{
        if (accounts.get(accFrom).getStatus() || accounts.get(accTo).getStatus()){
            System.out.println("Одна из карт уже заблокирована.");
            return 1;
        }
        sum.lazySet(checkSum(accounts));
        if (money > 50000){
            try {
                if (isFraud(money)){
                    accounts.get(accFrom).blockAccNumber();
                    accounts.get(accTo).blockAccNumber();
                    return 1;
                }
                else {
                    if (accounts.get(accFrom).getMoney() - money >= 0){
                        accounts.get(accFrom).subtract(money);
                        accounts.get(accTo).addMoney(money);
                    }
                    else {
                        System.out.println("Недоастаточно средств.");
                        return 2;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            accounts.get(accFrom).subtract(money);
            accounts.get(accTo).addMoney(money);
        }
        if (sum.equals(checkSum(accounts))){
            System.out.println("Сумма не сошлась!");
            return 3;
        }
        return 0;
    }

    private synchronized int checkSum (Map<Integer, Account> map){
        int sum = 0;
        for (Integer key : map.keySet()) {
            sum += map.get(key).money;
        }
        return sum;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

//
//    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
//            throws InterruptedException
//    {
//        Thread.sleep(1000);
//        return random.nextBoolean();
//    }

    public  synchronized boolean isFraud(int money)  throws InterruptedException{
        Thread.sleep(1);
        if (money%50 == 0){
            return true;
        }
        else return false;
    }

    public int getBalance(int acc){
        return accounts.get(acc).getMoney();
    }

}
