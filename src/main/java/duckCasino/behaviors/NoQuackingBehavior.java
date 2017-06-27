package duckCasino.behaviors;

public final class NoQuackingBehavior implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("I cant quck!");
    }
}
