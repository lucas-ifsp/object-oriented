package class08.resources;

public class MyResource implements AutoCloseable{
    public void doSomething(){
        System.out.println("My Resource is doing something...");
    }
    @Override
    public void close() {
        System.out.println("Closing MyResource...");
    }
}
