package World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Deprecated
public class WorldOld {

    /*
    Notes:

    World split up into 16x16 chunks
    Each one is either created or systematically rendered
     */


    private long seed;

    private transient List<ChunkOld> loadedChunks;

    public WorldOld() {
        this(new Random().nextLong());
    }

    public WorldOld(long seed) {
        this.seed = seed;
        loadedChunks = new ArrayList<>();
    }
}
