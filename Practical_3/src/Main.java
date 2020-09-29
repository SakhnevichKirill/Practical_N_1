import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);


        System.out.println("Выберите вид посуды: 1 - кухонная; 2 - столовая");
        int f = s.nextInt();
        if(f == 1) {


            CookingWare a = new CookingWare();

            System.out.println("Введите материалы из которых выполнена посуда: ");
            String material = s.nextLine();

            System.out.println("Введите тип кухонной посуды(это могут быть: кастрюли, сковородки и т.д.): ");
            String type = s.nextLine();

            System.out.println("Введите общее число посудных изделий для кухни: ");
            int count = s.nextInt();

            System.out.println("Введите особенности посуды: ");
            String features = s.next();

            System.out.println(a.getInfo());




        }
        else {
            TableWare b = new TableWare();

            System.out.println("Введите материалы из которых выполнена посуда: ");
            String material = s.nextLine();

            System.out.println("Введите тип столовой посуды(это могут быть: вилки, бакалы, стаканы и т.д.): ");
            String type = s.nextLine();

            System.out.println("Введите общее число посудных изделий для столовой: ");
            int count = s.nextInt();

            System.out.println("Введите особенности посуды: ");
            String features = s.next();

            System.out.println(b.getInfo());

        }

    }

}
