package lotr;

public class Hobbit extends Character{

    public Hobbit() {
        super(3, 0);
    }

    private void ToCry(){}

    @Override
    public void kick(Character enemy) {
        ToCry();
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
