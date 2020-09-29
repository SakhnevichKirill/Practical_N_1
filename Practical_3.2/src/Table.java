import Base.Furniture;

public class Table extends Furniture {
    private boolean isBroken;

    protected Table(int price, String color, int length) {
        super(price, color, length);
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public void toRepair() {
        if (isBroken){
            System.out.println("Этот стол нужно починить");
        } else {
            System.out.println("Этот стол в хорошем состоянии");
        }
    }

    @Override
    public String toString() {
        return "Table{" +
                "price=" + price +
                ", color='" + color + '\'' +
                ", length=" + length +
                '}';
    }
}
