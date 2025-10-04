package lotr;

public abstract class Character {
    private int hp, power;

    protected Character(int hp, int power) {
        this.power = power;
        this.hp = hp;
    }

    public abstract void kick(Character enemy);
    public abstract boolean isAlive();
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(power, 0);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + String.format("{hp=%d, power=%d}", this.hp, this.power);
    }
}
