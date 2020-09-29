import java.util.Scanner;

public abstract class Shape {
    protected String color;
    protected boolean filled;
    public Shape() {

    }
    public Shape(String color,boolean filled) {
        setColor(color);
        setFilled(filled);
        System.out.println(toString());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea() ;
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Фигура: " + filled + "\n" + " Цвет: " + color;
    }
}
