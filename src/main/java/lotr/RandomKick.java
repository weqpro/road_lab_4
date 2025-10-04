package lotr;

import java.util.random.RandomGenerator;

public class RandomKick implements KickStrategy {
    private final RandomGenerator rng;

    public RandomKick(RandomGenerator rng) {
        this.rng = rng;
    }

    @Override
    public void kick(Character me, Character enemy) {
        enemy.setHp(enemy.getHp() - rng.nextInt(1, me.getPower() + 1));
    }
}
