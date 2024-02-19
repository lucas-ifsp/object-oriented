package class05.modifiers.packageA;

public class Subclass extends SuperClass{
    public Subclass() {
        publicVar = 10; //OK, global access
        protectedVar = 11; //OK, it is a subclass and is inside the same package
        noModifierVar = 12;  //OK, it is inside the same package
        //privateVar = 13; //ERRO, only accessible inside SuperClass
    }
}
