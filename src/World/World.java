package World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class World {

    /*
    Notes:

    World split up into 16x16 chunks
    Each one is either created or systematically rendered
     */


    private long seed;

    private transient List<Chunk> loadedChunks;

    public World() {
        this(new Random().nextLong());
    }

    public World(long seed) {
        this.seed = seed;
        loadedChunks = new ArrayList<>();
    }
}
