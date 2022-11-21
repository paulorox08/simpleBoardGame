// You don't have to use an array list but it might be useful
import java.util.ArrayList; 

public class Grid {
    private static final String GRID_CORNER_SYMBOL = "+";
    private static final String GRID_HORIZONTAL_SYMBOL = "-";
    private static final String GRID_VERTICAL_SYMBOL = "|"; 
    // DON'T TOUCH ANY OF THESE SYMBOL DECLARATIONS
    // You should use them in your Grid's printGrid method.

    private int width;
    private int height;
    
    private ArrayList<Tile> collection = new ArrayList<Tile>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        for (int x = 0; x < width; x ++) {

            for (int y = 0; y < height; y++) {

                Tile tile = new Tile(x, y);
                collection.add(tile);
            }
        }
    }

    public int getGridWidth() {
        return width;
    }

    public int getGridHeight() {
        return height;
    }

    public Tile getTileAtPosition(int x, int y) {
        for (Tile i: collection) {
            if (i.getXPosition() == x && i.getYPosition() == y) {
                return i;
            }
        }
        return null;
    }

    public void addExit() {
        int limiter = getGridWidth() - 1;

        getTileAtPosition(limiter, 0).addItemToTile("Exit");
    }

    public Tile getPlayerTile() {
        for (Tile i: collection) {
            if (i.isItemOnTile("Player") == true) {
                return i;
            }
        }
        return null;
    }

    public void printGrid() {
        
        int rows = getGridHeight() * 2;
        int columns = getGridWidth() * 2;

        for (int a = 0; a < rows + 1; a ++) {

            if (a % 2 == 0) {

                for (int b = 0; b < columns + 1; b++) {

                    if (b % 2 == 0 && b != columns) {
                        System.out.print(GRID_CORNER_SYMBOL);
                    }
                    else if (b % 2 != 0 && b != columns) {
                        System.out.print(GRID_HORIZONTAL_SYMBOL);
                    }
                    else {
                        System.out.println(GRID_CORNER_SYMBOL);
                    }
                }
            }
            else {
                
                for (int b = 0; b < columns + 1; b++) {

                    if (b % 2 == 0 && b != columns) {
                        System.out.print(GRID_VERTICAL_SYMBOL);
                    }
                    else if (b % 2 != 0 && b != columns) {
                        int xPos = b - 1;
                        int actualXPos = xPos / 2;

                        int yPos = a - 1;
                        int actualYPos = yPos / 2;

                        System.out.print(getTileAtPosition(actualXPos, actualYPos));
                    }
                    else {
                        System.out.println(GRID_VERTICAL_SYMBOL);
                    }
                }
                
            }
        }
    }

}