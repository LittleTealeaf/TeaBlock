package Menu;

import Util.DrawableOld;
import Screen.Screen;
import java.awt.event.MouseEvent;

@Deprecated
public class MenuOld extends Screen {

    private MenuOptionOld[] menuOptionOlds;

    public MenuOld() {
        super();
    }

    protected void setMenuItems(MenuOptionOld[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    count++;
                    //find upper neighbor
                    for (int k = i - 1; k >= 0; k--) {
                        if (j < grid[k].length && grid[k][j] != null) {
                            grid[i][j].setNeighborItem(grid[k][j], DirectionOld.UP);
                            break;
                        }
                    }
                    //Find lower neighbor
                    for (int k = i + 1; k < grid.length; k++) {
                        if (j < grid[k].length && grid[k][j] != null) {
                            grid[i][j].setNeighborItem(grid[k][j], DirectionOld.DOWN);
                            break;
                        }
                    }
                    //Find left neighbor
                    for (int k = j - 1; k >= 0; k--) {
                        if (grid[i][k] != null) {
                            grid[i][j].setNeighborItem(grid[i][k], DirectionOld.LEFT);
                            break;
                        }
                    }
                    //Find right neighbor
                    for (int k = j + 1; k < grid[i].length; k++) {
                        if (grid[i][k] != null) {
                            grid[i][j].setNeighborItem(grid[i][k], DirectionOld.RIGHT);
                            break;
                        }
                    }
                }
            }
        }
        menuOptionOlds = new MenuOptionOld[count];
        int ind = 0;
        for (MenuOptionOld[] options : grid) {
            for(MenuOptionOld option : options) {
                if(option != null) {
                    menuOptionOlds[ind++] = option;
                }
            }
        }
        drawables.add(g -> {
            for(DrawableOld drawableOld : menuOptionOlds) {
                drawableOld.paintComponent(g);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        for(MenuOptionOld menuOptionOld : menuOptionOlds) {
            if(menuOptionOld.getBounds().contains(e.getPoint())) {
                menuOptionOld.click();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        mouseMoved(e);
    }

    public void setSelected(MenuOptionOld option) {
        for(MenuOptionOld menuOptionOld : menuOptionOlds) {
            menuOptionOld.setSelected(menuOptionOld == option);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        try {
            for(MenuOptionOld menuOptionOld : menuOptionOlds) {
                if(menuOptionOld.getBounds().contains(e.getPoint())) {
                    setSelected(menuOptionOld);
                }
            }
        } catch(Exception exception) {
            System.out.println("Skipping mouse movement, not yet rendered");
        }
    }
}
