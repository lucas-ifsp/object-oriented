package class05.exercicio;

public final class Circle extends Figure {

    private double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRadius: " + radius;
    }
}
