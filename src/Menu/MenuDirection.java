package Menu;

public enum MenuDirection {
    UP(0),RIGHT(1),DOWN(2),LEFT(3);

    private final int index;

    MenuDirection(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getInverse() {
        return (index + 2) % 4;
    }
}
