package class05.modifiers.packageB;

import class05.modifiers.packageA.SuperClass;

public class OtherPackageClass {
    public OtherPackageClass() {
        SuperClass instance = new SuperClass();
        instance.publicVar = 10; //OK, global access
        //instance.protectedVar = 11; //ERROR, neither subclass nor inside the same package
        //instance.noModifierVar = 12;  //ERROR, not inside the same package
        //instance.privateVar = 13; //ERROR, accessible only inside SuperClass
    }
}
