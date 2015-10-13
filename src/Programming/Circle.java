package Programming;

public class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public Double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + radius + ")";
    }

}
