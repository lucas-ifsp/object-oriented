package class04.statics;

public class TriangleUtils {
    // Static method to calculate the hypotenuse
    public static double calculateHypotenuse(double sideA, double sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
}
