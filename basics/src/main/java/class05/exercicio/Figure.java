package class05.exercicio;

public sealed abstract class Figure permits Circle{
    private final int x;
    private final int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double area();

    @Override
    public String toString() {
        return String.format("%s (x=%d, y=%d) Area: %.2f", getClass().getSimpleName(), x, y, area());
    }
}
