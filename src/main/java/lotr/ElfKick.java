package lotr;

public class ElfKick implements KickStrategy {
    @Override
    public void kick(Character me, Character enemy) {
        if (me.getPower() > enemy.getPower()) {
            enemy.setHp(0);
        } else {
            enemy.setPower(enemy.getPower() - 1);
        }
    }
}
