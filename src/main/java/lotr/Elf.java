package lotr;

public class Elf extends Character {
    public Elf() {
        super(10, 10);
    }

    @Override
    public void kick(Character enemy) {
        if (this.getPower() > enemy.getPower()) {
            enemy.setHp(0);
        } else {
            enemy.setPower(enemy.getPower() - 1);
        }
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
