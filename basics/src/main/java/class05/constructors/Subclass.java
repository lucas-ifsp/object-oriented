package class05.constructors;

public class Subclass extends SuperClass{
    public Subclass(String text){ // implicitly calls SuperClass constructor
        System.out.println(STR."\{text} Built an istance of subclass.");
    }
}
