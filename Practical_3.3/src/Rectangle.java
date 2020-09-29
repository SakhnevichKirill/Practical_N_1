public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public double getPerimeter() {
        return (2*width)+(2*length);
    }
    public Rectangle() {

    }
    public Rectangle(double width,double length) {
        setWidth(width);
        setLength(length);

    }
    public Rectangle(double width,double length,String color,boolean filled) {
        setColor(color);
        setFilled(filled);
        Rectangle res = new Rectangle(width,length);
        System.out.println("Цвет Прямоугольника: " + getColor() + "\n"
                + res.toString());
    }

    @Override
    public String toString() {
        return  " Ширина Прямоугольника: " + width + "\n" + " Длина Прямоугольника: " + length + "\n"
                + " Площадь Прямоугольника " + getArea() + "\n"
                + " Периметр Прямоугольника " + getPerimeter();
    }
}
