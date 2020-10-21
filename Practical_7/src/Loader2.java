import java.util.Scanner;

public class Loader2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ФИО через пробел.");
        String text = sc.nextLine();
        String surname = null;
        String name = null;
        String patronymic = null;

        int f;
        int r;
        boolean flag = false;
        int i = 0;

        while (!flag && i < 3){

            text.trim();
            f = text.indexOf(' ');
            if (f > -1 && f <= text.length()){
                surname = text.substring(0, f);
                i++;
                r = text.indexOf(' ', f+1);
                if (r > -1 && f <= text.length()){
                    name = text.substring(f+1, r);
                    f = text.indexOf(' ', f+1);
                    i++;
                    r = text.indexOf(' ', f+1);
                    if (r == -1 && f <= text.length()) {
                        patronymic = text.substring(f+1, text.length());
                        flag = true;
                        System.out.println("Фамилия: "+ surname + "\nИмя: " + name + "\nОтчество: " + patronymic);
                    }
                }
                else if (r == -1 && f <= text.length()){
                    name = text.substring(f+1, text.length());
                    i++;
                    flag = true;
                    System.out.println("Фамилия: "+ surname + "\nИмя: " + name);
                }
                else {
                    System.out.println("Введенная строка не является ФИО");
                    text = sc.next();
                    i = 0;
                }
            }
            else {
                System.out.println("Введенная строка не является ФИО");
                text = sc.next();
                i = 0;
            }
        }

    }

}
