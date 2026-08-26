package class06.sample;

public final class Circle extends Figure {
    private final double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle of radius %.2f in %s with area of %.2f",
                radius, super.toString(), area());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0 &&
               Double.compare(getX(), ((Circle) o).getX()) == 0 &&
               Double.compare(getY(), ((Circle) o).getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }
}
