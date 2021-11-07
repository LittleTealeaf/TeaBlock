package Menu;

import Util.Drawable;
import Screen.Screen;
import java.awt.event.MouseEvent;

public class Menu extends Screen {

    private MenuOption[] menuOptions;

    public Menu() {
        super();
    }

    protected void setMenuItems(MenuOption[][] grid) {
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
        menuOptions = new MenuOption[count];
        int ind = 0;
        for (MenuOption[] options : grid) {
            for(MenuOption option : options) {
                if(option != null) {
                    menuOptions[ind++] = option;
                }
            }
        }
        drawables.add(g -> {
            for(Drawable drawable : menuOptions) {
                drawable.paintComponent(g);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        for(MenuOption menuOption : menuOptions) {
            if(menuOption.getBounds().contains(e.getPoint())) {
                menuOption.click();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        mouseMoved(e);
    }

    public void setSelected(MenuOption option) {
        for(MenuOption menuOption : menuOptions) {
            menuOption.setSelected(menuOption == option);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        try {
            for(MenuOption menuOption : menuOptions) {
                if(menuOption.getBounds().contains(e.getPoint())) {
                    setSelected(menuOption);
                }
            }
        } catch(Exception exception) {
            System.out.println("Skipping mouse movement, not yet rendered");
        }
    }
}
