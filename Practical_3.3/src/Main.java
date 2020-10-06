import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Хотите создать: 1 - Круг, 2 - Прямоуглольник, 3 - Квадрат");

        int i = in.nextInt();
        switch (i) {
            case (1): {
                in.nextLine();
                System.out.println("Введите цвет Круга: ");
                String color = in.nextLine();
                System.out.println("Введите радиус: ");
                double radius = in.nextDouble();
                Circle cir = new Circle(radius, color, true);
                break;
            }

            case (2): {
                in.nextLine();
                System.out.println("Введите цвет Прямоугольника: ");
                String color = in.nextLine();
                System.out.println("Введите длину: ");
                double length = in.nextDouble();
                System.out.println("Введите ширину: ");
                double width = in.nextDouble();
                Rectangle rectangle = new Rectangle(width,length);

                System.out.println(rectangle);
                System.out.println(rectangle.getPerimeter());
                break;
            }
            case (3): {
                in.nextLine();
                System.out.println("Введите цвет Квадрата: ");
                String color = in.nextLine();
                System.out.println("Введите длину стороны: ");
                double side = in.nextDouble();
                Square square = new Square(10);
                System.out.println(square);
                System.out.println(square.getWidth());
                break;
            }

        }
    }
}