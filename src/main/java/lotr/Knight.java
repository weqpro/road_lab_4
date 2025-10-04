package lotr;

import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class Knight extends Character{
    private RandomGenerator rng;

    public Knight(RandomGenerator rng) {
        super(rng.nextInt( 2, 12+1), rng.nextInt(2, 12+1));
        this.rng = rng;
    }

    public Knight() { this(ThreadLocalRandom.current()); }

    @Override
    public void kick(Character enemy) {
        enemy.setHp(enemy.getHp() - rng.nextInt(1, this.getPower() + 1));
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
