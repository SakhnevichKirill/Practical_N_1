import Base.Furniture;

public class Sofa extends Furniture {
    private boolean isBroken;

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    protected Sofa(int price, String color, int length) {
        super(price, color, length);
    }

    @Override
    public void toRepair() {
        if (isBroken){
            System.out.println("Этот диван нужно починить");
        } else {
            System.out.println("Этот диван в хорошем состоянии");
        }
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "price=" + price +
                ", color='" + color + '\'' +
                ", length=" + length +
                '}';
    }
}
