package lotr;

public abstract class Character {
    private int hp, power;
    protected KickStrategy kickStrategy;

    protected Character(int hp, int power, KickStrategy kickStrategy) {
        this.power = power;
        this.hp = hp;
        this.kickStrategy = kickStrategy;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
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

    public void kick(Character enemy) {
        this.kickStrategy.kick(this, enemy);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + String.format("{hp=%d, power=%d}", this.hp, this.power);
    }
}
