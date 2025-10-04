package lotr;

public class King extends RandomCharacter{
    public King() { super(5, 15, 5, 15); }

    @Override
    public boolean isAlive() {
        return false;
    }
}
