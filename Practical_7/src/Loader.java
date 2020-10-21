import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();

        String text = "Вася заработал 5000 рублей, " + "Петя - 7563 рубля, Маша - 3000 рублей";

        int f = text.indexOf(' ');
        int r;
        String name = text.substring(0, f);
        int V = 0;
        int M = 0;
        int i = 0;
        int flag = 0;

        while (i < f || flag < 2){
            if (name.equals("Вася")) {
                r = text.indexOf(' ', f+1);
                name = text.substring(f + 1, r);
                f = text.indexOf(' ', f+1);
                while (!tryCatch(name)) {
                    r = text.indexOf(' ', f+1);
                    name = text.substring(f + 1, r);
                    f = text.indexOf(' ', f+1);
                }
                V = Integer.parseInt(name);
                flag += 1;
            } else if (name.equals("Маша")) {
                r = text.indexOf(' ', f+1);
                name = text.substring(f + 1, r);
                f = text.indexOf(' ', f+1);
                while (!tryCatch(name)) {
                    r = text.indexOf(' ', f+1);
                    name = text.substring(f + 1, r);
                    f = text.indexOf(' ', f+1);
                }
                M = Integer.parseInt(name);
                flag += 1;
            }
            if (i < f || flag < 2){
                r = text.indexOf(' ', f+1);
                name = text.substring(f + 1, r);
                f = text.indexOf(' ', f+1);
            }

            i += f;
        }
        int sum = M + V;
        System.out.println("Суммарная зарплата: "+ sum);

    }

    public static boolean tryCatch(String name) {
        try {
            Integer.parseInt(name);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




