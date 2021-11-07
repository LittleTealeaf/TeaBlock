package World;

import java.awt.*;
import java.util.Random;


public class World {

    /*

    Notes:

    World split up into 16x16 chunks
    Each one is either created or systematically rendered


     */


    private long seed;


    public World() {
        this(new Random().nextLong());
    }

    public World(long seed) {
        this.seed = seed;
    }
}
