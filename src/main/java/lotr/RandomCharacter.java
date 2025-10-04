package lotr;

import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public abstract class RandomCharacter extends Character{
    public RandomCharacter(RandomGenerator rng, int hp_from, int hp_to, int power_from, int power_to) {
        super(
            rng.nextInt(hp_from, hp_to + 1),
            rng.nextInt(power_from, power_to + 1),
            new RandomKick(rng)
        );
    }

    public RandomCharacter(int hp_from, int hp_to, int power_from, int power_to) {
        this(ThreadLocalRandom.current(), hp_from, hp_to, power_from, power_to);
    }
}
