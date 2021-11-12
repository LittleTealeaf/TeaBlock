package World;

import java.io.*;

public class WorldReader extends BufferedReader {

    private static final int NEWLINE = '\n', SPACE = ' ', SUBTRACT = '-', ZERO = '0';

    private int last;

    public WorldReader(File file) throws FileNotFoundException {
        super(new FileReader(file));
    }

    public WorldReader(String string) {
        super(new StringReader(string));
    }

    public int read() throws IOException {
        return last = super.read();
    }

    public char readChar() throws IOException {
        return (char) read();
    }

    public void nextLine() throws IOException {
        nextChar(last = NEWLINE);
    }

    public void nextToken() throws IOException {
        nextChar(last = SPACE);
    }

    private void nextChar(int i) throws IOException {
        while(super.read() != i);
    }

    public int readInt() throws IOException {
        int i = 0;
        boolean negative = false;
        while(read() != SPACE) {
            if(last == SUBTRACT) {
                negative = true;
            } else {
                i *= 10;
                i += last - ZERO;
            }
        }
        return negative ? -i : i;
    }

    /**
     * Returns the next 2 integers as an array
     * @return
     */
    public int[] getChunk() {
        try {
            return new int[] {
                    readInt(), readInt()
            };
        } catch(IOException exception) {
            return null;
        }
    }

    public void reset() throws IOException {
        super.reset();
        last = -1;
    }

    public boolean gotoChunk(boolean reset) throws IOException {
        if(reset) {
            reset();
        }


        return false;
    }
}
