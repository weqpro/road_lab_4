package lotr;

import java.io.PrintStream;
import java.util.Objects;

public class GameManager {
    private final PrintStream out;

    public GameManager(PrintStream out) {
        this.out = Objects.requireNonNull(out);
    }

    public void fight(Character c1, Character c2) {
        out.printf("Start: %s vs %s%n", c1, c2);

        int round = 1;
        int unchangedRounds = 0; // to detect stalemate (e.g., Hobbit vs Hobbit)

        while (c1.isAlive() && c2.isAlive()) {
            int hp1 = c1.getHp(), pw1 = c1.getPower();
            int hp2 = c2.getHp(), pw2 = c2.getPower();

            out.printf("Round %d: %s kicks %s%n", round, c1, c2);
            c1.kick(c2);
            out.printf("After: %s | %s%n", c1, c2);

            if (!c2.isAlive()) {
                out.printf("Winner: %s%n", c1);
                return;
            }

            // stalemate detection (no state change for a full turn)
            boolean unchanged = (hp1 == c1.getHp() && pw1 == c1.getPower()
                    && hp2 == c2.getHp() && pw2 == c2.getPower());
            unchangedRounds = unchanged ? unchangedRounds + 1 : 0;
            if (unchangedRounds >= 10) { // 10 unchanged kicks → call it a draw
                out.println("Stalemate: no state changes. Draw.");
                return;
            }

            // swap attacker/defender
            Character tmp = c1; c1 = c2; c2 = tmp;
            round++;

            // hard safety cap
            if (round > 1_000) {
                out.println("Stalemate: too many rounds. Draw.");
                return;
            }
        }

        out.printf("Winner: %s%n", c1.isAlive() ? c1 : c2);
    }
}
