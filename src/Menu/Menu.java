package Menu;

import Screen.Screen;

import java.util.List;

public class Menu extends Screen {

    private List<MenuOption> menuOptions;

    public Menu() {
        super();

    }

    protected void setMenuItemsAsGrid(MenuOption[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    count++;
                    //find upper neighbor
                    for (int k = i - 1; k >= 0; k--) {
                        if (j < grid[k].length && grid[k][j] != null) {
                            grid[i][j].setNeighborItem(grid[k][j], Direction.UP);
                            break;
                        }
                    }
                    //Find lower neighbor
                    for (int k = i + 1; k < grid.length; k++) {
                        if (j < grid[k].length && grid[k][j] != null) {
                            grid[i][j].setNeighborItem(grid[k][j], Direction.DOWN);
                            break;
                        }
                    }
                    //Find left neighbor
                    for (int k = j - 1; k >= 0; k--) {
                        if (grid[i][k] != null) {
                            grid[i][j].setNeighborItem(grid[i][k], Direction.LEFT);
                            break;
                        }
                    }
                    //Find right neighbor
                    for (int k = j + 1; k < grid[i].length; k++) {
                        if (grid[i][k] != null) {
                            grid[i][j].setNeighborItem(grid[i][k], Direction.RIGHT);
                            break;
                        }
                    }
                }
            }
        }
    }
}
