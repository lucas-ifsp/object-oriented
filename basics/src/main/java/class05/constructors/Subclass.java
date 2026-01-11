package class05.constructors;

public class Subclass extends SuperClass{
    public Subclass(String text){ // implicitly calls SuperClass constructor
        System.out.println(text + "Built an instance of subclass.");
    }
}
