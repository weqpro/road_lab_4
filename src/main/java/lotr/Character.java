package lotr;

public abstract class Character {
    private int hp;
    private final int power;

    protected Character(int hp, int power) {
        this.power = power;
        this.hp = hp;
    }

    public abstract void kick(Character character);
    public abstract boolean isAlive();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }
}
