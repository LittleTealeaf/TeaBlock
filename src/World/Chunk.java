package World;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Chunk {

    private File file;
    private int x, y;

    public Chunk(File file, int x, int y) {
        this.file = file;
        this.x = x;
        this.y = y;

    }


}