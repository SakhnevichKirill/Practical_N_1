import Base.Furniture;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {
    private List<Chair> chairs;
    private List<Table> tables;
    private List<Sofa> sofas;
    private ArrayList<Chair> chairsBasket;
    private ArrayList<Table> tablesBasket;
    private ArrayList<Sofa> sofasBasket;

    public FurnitureShop() {
        chairs = new ArrayList<Chair>();
        tables = new ArrayList<Table>();
        sofas = new ArrayList<Sofa>();
        chairsBasket = new ArrayList<Chair>();
        tablesBasket = new ArrayList<Table>();
        sofasBasket = new ArrayList<Sofa>();
    }

    public void setCatalog() {

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0)
                chairs.add(new Chair(5500,"straw", 80));
            else {
                chairs.add(new Chair(4200,"brown", 120));
            }
        }

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0)
                tables.add(new Table(15000,"straw", 220));
            else {
                tables.add(new Table(18500,"brown", 190));
            }
        }

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0)
                sofas.add(new Sofa(30000, "white", 200));
            else {
                sofas.add(new Sofa(25000,"black", 180));
            }
        }

    }

    public void getChairsCatalog() {
        for (int i = 0; i < chairs.size(); i++) {
            System.out.println("№" + (i +1) + "  " + chairs.get(i));
        }
    }
    public void getTablesCatalog() {
        for (int i = 0; i < tables.size(); i++) {
            System.out.println("№" + (i +1) + "  " + tables.get(i));
        }
    }

    public void getSofasCatalog(){
        for (int i = 0; i < sofas.size(); i++) {
            System.out.println("№" + (i +1) + "  " + sofas.get(i));
        }
    }

    public void deleteChair(int pos) {
        chairs.remove(pos - 1);
    }

    public void deleteTable(int pos) {
        tables.remove(pos - 1);
    }

    public void deleteSofa(int pos){
        sofas.remove(pos - 1);
    }

    public void addChairToBasket(int i) {
        chairsBasket.add(chairs.get(i - 1));
    }

    public void addTableToBasket(int i) {
        tablesBasket.add(tables.get(i - 1));
    }

    public void addSofaToBasket(int i){
        sofasBasket.add(sofas.get(i - 1));
    }

    public void getBasket() {
        int sum = 0;
        if (chairsBasket.size() == 0 && tablesBasket.size() == 0 && sofasBasket.size() == 0) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("Кровати:");
        for (int i = 0; i < sofasBasket.size(); i++) {
            System.out.println("№" + (i + 1) + "  " + sofasBasket.get(i));
            sum += sofasBasket.get(i).getPrice();
        }
        if (sofasBasket.size() == 0) System.out.println("-\n");

        System.out.println("Cтулья:");
        for (int i = 0; i < chairsBasket.size(); i++) {
            System.out.println("№" + (i + 1) + "  " + chairsBasket.get(i));
            sum += chairsBasket.get(i).getPrice();
        }
        if (chairsBasket.size() == 0) System.out.println("-\n");

        System.out.println("Столы:");
        for (int i = 0; i < tablesBasket.size(); i++) {
            System.out.println("№" + (i + 1) + "  " + tablesBasket.get(i));
            sum += tablesBasket.get(i).getPrice();
        }
        if (tablesBasket.size() == 0) System.out.println("-\n");

        System.out.println("\n СТОИМОСТЬ + " + sum);
    }


    public void deleteBasket() {
        chairsBasket.clear();
        tablesBasket.clear();
        sofasBasket.clear();
    }


    public void restoreCatalog() {
        chairs.addAll(chairsBasket);
        tables.addAll(tablesBasket);
        sofas.addAll(sofasBasket);
    }
}
