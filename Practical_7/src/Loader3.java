import java.util.Scanner;


public class Loader3 {
    public static void main(String[] args) {
        // 89091234567
        // +7-909-123-45-67

        String number;

        StringBuffer numberF = new StringBuffer();

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите новер телефона: ");

        number = sc.nextLine();

        boolean f = false;

        while (!f){
            number = number.replaceAll("[^0-9]", "");
            if (number.length() == 11 || number.length() == 10) {
                if (number.charAt(0) == '7' && number.length() == 11) {
                    numberF.append(number);
                    numberF.insert(0, "+");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.print(numberF);
                } else if (number.charAt(0) == '8' && number.length() == 11) {
                    numberF.append(number);
                    numberF.delete(0,1);
                    numberF.insert(0, "+7");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.print(numberF);
                }
                else if (number.charAt(0) != '7' && number.length() == 10) {
                    numberF.append(number);
                    numberF.insert(0, "+7");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.print(numberF);
                }
                else {
                    System.out.println("Неверный ввод.");
                    System.out.println("Попробуйте еще раз:");
                    number = sc.next();
                    numberF.append(number);
                    numberF.delete(0, numberF.length());
                }
            } else {
                System.out.println("Неверный ввод.");
                System.out.println("Попробуйте еще раз:");
                number = sc.next();
                numberF.delete(0, numberF.length());
            }
        }

    }
}
