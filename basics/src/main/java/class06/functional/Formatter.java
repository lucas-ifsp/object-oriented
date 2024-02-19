package class06.functional;

public interface Formatter <T extends Reportable>{
    String format(T[] elements);
}
