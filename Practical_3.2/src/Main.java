import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FurnitureShop furnitureShop = new FurnitureShop();
        furnitureShop.setCatalog();

        int choice;
        int number;

        boolean f = true;

        while (f) {

            System.out.println("В нашем ассортименте есть: \n   1) Диваны \n   2) Стулья \n   3) Столы \n   4) Перейти в корзину \n   5) Выйти измагазина \n Выберите номер интересующего вас варианта и нажмите enter: ");

            choice = in.nextInt();


            switch (choice){
                case 1:
                    furnitureShop.getSofasCatalog();
                    System.out.println("Выберите номер дивана для покупки: ");
                    number = in.nextInt();
                    furnitureShop.addSofaToBasket(number);
                    furnitureShop.deleteSofa(number);
                    break;
                case 2:
                    furnitureShop.getChairsCatalog();
                    System.out.println("Выберите номер стула для покупки: ");
                    number = in.nextInt();
                    furnitureShop.addChairToBasket(number);
                    furnitureShop.deleteChair(number);
                    break;
                case 3:
                    furnitureShop.getTablesCatalog();
                    System.out.println("Выберите номер стола для покупки: ");
                    number = in.nextInt();
                    furnitureShop.addTableToBasket(number);
                    furnitureShop.deleteTable(number);
                    break;
                case 4:
                    furnitureShop.getBasket();

                    System.out.println("Желаете приобрести выбранные товары? 1) Да 2) Нет");

                    number = in.nextInt();
                    if (number == 1) {
                        furnitureShop.deleteBasket();
                    }
                    else if (number == 2) {
                        furnitureShop.restoreCatalog();
                    }
                    break;
                case 5:
                    System.out.println("Всегда Вам рады, обращайтесь еще!");
                    f = false;
                    break;

            }
        }
    }
}
