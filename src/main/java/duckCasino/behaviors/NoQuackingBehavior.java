package duckCasino.behaviors;

public class NoQuackingBehavior implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("I cant quck!");
    }
}
