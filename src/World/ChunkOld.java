package World;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Deprecated
public class ChunkOld {

    private final File file;
    private final int x;
    private final int y;

    public ChunkOld(File file, int x, int y) {
        this.file = file;
        this.x = x;
        this.y = y;

    }


}