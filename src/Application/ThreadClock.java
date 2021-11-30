package Application;

@Deprecated
public abstract class ThreadClock extends Thread {

    private long wait;
    private boolean running = false;
    private long nextFrame;

    /**
     * Positive numbers indicate # of runs per second
     * Negative numbers indicate time before frames in ms
     * @param speed if {@code speed > 0}: # ticks per second, otherwise # ms per tick
     */
    public ThreadClock(int speed) {
        super();
        wait = speed > 0 ? 1000 / speed : speed;
    }

    public void start() {
        if(!running) {
            running = true;
            nextFrame = System.currentTimeMillis();
            super.start();
        }
    }

    public void end() {
        running = false;
    }

    public void run() {
        while(running) {
            long time = System.currentTimeMillis();
            if(time >= nextFrame) {
                nextFrame = time + wait;
                function();
            }
        }
    }

    /**
     * Positive numbers indicate # cycles per second. Negative numbers indicate raw ms between runs
     * @param speed if {@code speed > 0}: # ticks per second, otherwise # ms per tick
     */
    public void setRunsPerSecond(int speed) {
        wait = speed > 0 ? 1000 / speed : speed;
    }

    public abstract void function();
}
