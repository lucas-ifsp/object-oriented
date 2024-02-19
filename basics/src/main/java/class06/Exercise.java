package class06;

public class Exercise {

    abstract class Animal{
        private String name;
        public abstract void makeSound();
    }

    class Lion extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Rrrrrwaarrr!");
        }
        public void run(){
            System.out.println("Lion is running!");
        }
    }

    class Wolf extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Auuuuuu!");
        }
        public void run(){
            System.out.println("Wolf is running!");
        }
    }

    class Owl extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Pruuu Pruuu!");
        }
    }

}
