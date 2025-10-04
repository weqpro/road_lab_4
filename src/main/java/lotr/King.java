package lotr;

import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class King extends Character{
    private final RandomGenerator rng;

    public King(RandomGenerator rng) {
        super(rng.nextInt( 5, 15+1), rng.nextInt(5, 15+1));
        this.rng = rng;
    }

    public King() { this(ThreadLocalRandom.current()); }

    @Override
    public void kick(Character enemy) {
        enemy.setHp(enemy.getHp() - rng.nextInt(1, this.getPower() + 1));
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
