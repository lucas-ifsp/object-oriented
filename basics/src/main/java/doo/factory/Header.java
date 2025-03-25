package doo.factory;

public record Header(String... columns) implements Reportable{
    @Override
    public String[] toReport() {
        return columns;
    }
}
