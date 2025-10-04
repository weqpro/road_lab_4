package lotr;

public class HobbitKick implements KickStrategy {
    @Override
    public void kick(Character me, Character enemy) {
        if (me instanceof Hobbit h) {
            h.ToCry();
        } else {
            throw new IllegalArgumentException("HobbitKick can only be used by Hobbit");
        }
    }
}
