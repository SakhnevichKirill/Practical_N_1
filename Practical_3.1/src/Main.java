import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);


        System.out.println("Выберите породу собаки: 1 - Бордер колли; 2 - Немецкая овчарка");
        int f = s.nextInt();
        if(f == 1) {


            BorderCollie a = new BorderCollie();

            System.out.println("Введите имя собаки: ");
            String name = s.next();
            a.setName(name);

            System.out.println("Введите вес собкаи: ");
            String weight = s.next();
            a.setWeight(weight);

            System.out.println("Введите кол-во собак данной породы: ");
            int count = s.nextInt();
            a.setCount(count);

            System.out.println("Введите особенности собаки: ");
            String features = s.next();
            a.setFeatures(features);

            System.out.println(a.getInfo());





        }
        else {
            GermanShepherd b = new GermanShepherd();

            System.out.println("Введите имя собаки: ");
            String name = s.next();
            b.setName(name);

            System.out.println("Введите вес собкаи: ");
            String weight = s.next();
            b.setWeight(weight);

            System.out.println("Введите кол-во собак данной породы: ");
            int count = s.nextInt();
            b.setCount(count);

            System.out.println("Введите особенности собаки: ");
            String features = s.next();
            b.setFeatures(features);

            System.out.println(b.getInfo());


        }

    }

}