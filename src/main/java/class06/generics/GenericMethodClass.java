package class06.generics;

public class GenericMethodClass {

    // generic types definition | return type | method signature
    public static <T,R> R prependHelloAndReturnSecond(T first, R second){
        System.out.println("Hello " + first.toString());
        System.out.println("Hello " + second.toString());
        return second;
    }

    void main(){
        final String resultA = prependHelloAndReturnSecond(10, "Object-oriented");
        final Integer integer = prependHelloAndReturnSecond("Object-oriented", 10);
    }
}
