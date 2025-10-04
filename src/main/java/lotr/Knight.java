package lotr;

public class Knight extends RandomCharacter{
    public Knight() { super(2, 12, 2, 12); }


    @Override
    public boolean isAlive() {
        return false;
    }
}
