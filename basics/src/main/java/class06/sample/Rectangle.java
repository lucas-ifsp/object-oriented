package class06.sample;

public final class Rectangle extends Figure {
    private final double length;
    private final double width;

    public Rectangle(double x, double y, double length, double width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public String toString() {
        return String.format("Rectangle of length %.2f and width %.2f in %s with area of %.2f",
                length, width, super.toString(), area());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;
        return Double.compare(length, rectangle.length) == 0 &&
               Double.compare(width, rectangle.width) == 0 &&
               Double.compare(getX(), ((Rectangle) o).getX()) == 0 &&
               Double.compare(getY(), ((Rectangle) o).getY()) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(length);
        result = 31 * result + Double.hashCode(width);
        return result;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
