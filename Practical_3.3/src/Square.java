public class Square extends Rectangle {
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }
    @Override
    public double getArea() {
        return side*side;
    }
    @Override
    public double getPerimeter() {
        return 4*side;
    }




    public Square() {

    }
    public  Square(double side) {
        setSide(side);
    }
    public Square(double side,String color,boolean filled) {
        setColor(color);
        setFilled(filled);
        Square sq = new Square(side);
        sq.setLength(side);
        sq.setWidth(side);
        System.out.println("Цвет Квадрата: " + getColor() + "\n"
                + sq.toString());

    }
    public String toString() {
        return  " Длина Квадрата: " + side + "\n"
                + " Площадь Квадрата " + getArea() + "\n"
                + " Периметр Квадрата " + getPerimeter();
    }
}
