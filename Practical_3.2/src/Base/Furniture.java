package Base;

public abstract class Furniture {
    protected int price;
    protected String color;
    protected int length;

    public int getPrice() {
        return price;
    }

    public int rand(int a, int b) {
        return  (int) ( Math.random() * (b - a + 1) + a );
    }

    protected Furniture(int price, String color, int length) {
        price = rand( (price/2), price);
        length = rand( (length - length/3), length);

        this.price = price;
        this.color = color;
        this.length = length;
    }

    public abstract void toRepair();

}
