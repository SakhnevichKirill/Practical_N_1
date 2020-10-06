
public class Circle extends Shape {
    protected double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius*radius*3.14;
    }

    @Override
    public double getPerimeter() {
        return 2*3.14*radius;
    }

    @Override
    public String toString() {
        return "Радиус круга: " + radius + "\n"
                + " Площадь круга " + getArea() + "\n"
                + " Длина круга " + getPerimeter();
    }

    public Circle() {

    }
    public Circle(double radius) {
        setRadius(radius);
    }
    public Circle(double radius,String color,boolean filled) {
        setColor(color);
        setFilled(filled);
        Circle cr = new Circle(radius);
        System.out.println("Цвет круга: " + getColor() + "\n"
                + cr.toString());
    }
}
