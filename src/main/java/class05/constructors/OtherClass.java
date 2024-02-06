package class05.constructors;

public class OtherClass extends Subclass{
    public OtherClass() {
        //The use of super is necessary because SubClass has no default constructor
        super("Yeah!");
        System.out.println("Built an instance of OtherClass.");
    }
}

