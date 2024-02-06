package class06.generics;

public interface Formatter <T extends Reportable>{
    String format(T[] elements);
}
