import Base.Furniture;

public class Chair extends Furniture {
    private boolean isBroken;

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    protected Chair(int price, String color, int length) {
        super(price, color, length);
    }

    @Override
    public void toRepair() {
        if (isBroken) {
            System.out.println("Этот стул нужно починить");
        } else {
            System.out.println("Этот стул в хорошем состоянии");
        }
    }

    @Override
    public String toString() {
        return "Chair{" +
                "price=" + price +
                ", color='" + color + '\'' +
                ", length=" + length +
                '}';
    }
}