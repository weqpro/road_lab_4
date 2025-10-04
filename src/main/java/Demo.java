import lotr.CharacterFactory;
import lotr.GameManager;
import lotr.Character;

public class Demo {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();


        Character c1 = factory.createCharacter();
        Character c2 = factory.createCharacter();

        System.out.println("Rolled: " + c1 + " vs " + c2);

        GameManager gm = new GameManager(System.out);
        gm.fight(c1, c2);

    }
}
