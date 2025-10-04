package lotr;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class CharacterFactory {

    // Cache of zero-arg constructors for all concrete Character subclasses
    private final List<Constructor<? extends Character>> constructors = new ArrayList<>();

    public CharacterFactory() {
        Reflections reflections = new Reflections("lotr", Scanners.SubTypes.filterResultsBy(s -> true));

        Set<Class<? extends Character>> subtypes = reflections.getSubTypesOf(Character.class);
        if (subtypes.isEmpty()) {
            throw new IllegalStateException("No subclasses of Character found via reflections");
        }

        for (Class<? extends Character> cls : subtypes) {
            if (Modifier.isAbstract(cls.getModifiers()) || !Modifier.isPublic(cls.getModifiers())) {
                continue;
            }
            try {
                Constructor<? extends Character> ctor = cls.getDeclaredConstructor();
                if (!Modifier.isPublic(ctor.getModifiers())) {
                    ctor.setAccessible(true);
                }
                constructors.add(ctor);
            } catch (NoSuchMethodException ignored) {
                // ignore classes without a no-arg constructor
            }
        }

        if (constructors.isEmpty()) {
            throw new IllegalStateException(
                    "Found Character subclasses, but none had a public/no-arg ctor");
        }
    }

    public Character createCharacter() {
        int i = ThreadLocalRandom.current().nextInt(constructors.size());
        Constructor<? extends Character> ctor = constructors.get(i);
        try {
            return ctor.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to instantiate " + ctor.getDeclaringClass().getName(), e);
        }
    }
}
