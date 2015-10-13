package Programming;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.height = height;
        this.width = width;
    }

    @Override
    public Double perimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public Double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + width + "," + height + ")";
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
