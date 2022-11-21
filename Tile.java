// You don't have to use an array list, but it may be useful.
import java.util.ArrayList; 

public class Tile {
    private static final String HIDDEN_SYMBOL = "~";
    private static final String PLAYER_ON_EXIT_TILE_SYMBOL = "O";
    private static final String PLAYER_TILE_SYMBOL = "P";
    private static final String EXIT_TILE_SYMBOL = "X";
    private static final String OBSTACLE_TILE_SYMBOL = "#";
    private static final String UNKNOWN_ITEM_SYMBOL = "?";
    private static final String EMPTY_TILE_SYMBOL = " ";
    // DON'T TOUCH ANY OF THESE SYMBOL DECLARATIONS
    // You should use them in your Tile's toString method.

    private int x;
    private int y;
    private boolean isVisible;
    private ArrayList<String> list = new ArrayList<String>();

    public Tile(int x, int y) {
        // Implement your constructor here!
        this.x = x;
        this.y = y;
        this.isVisible = true;
        this.list = list;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public boolean getVisibility() {
        return isVisible;
    }

    public void setVisibility(boolean visibility) {
        this.isVisible = visibility;
    }

    public void addItemToTile(String argument) {
        if (list.contains(argument)) {
            System.out.print("argument already in array");
        }
        else {
            list.add(argument);
        }
    }

    public void removeItemFromTile(String argument) {
        list.remove(argument);
    }

    public boolean isItemOnTile(String argument) {
        if (list.contains(argument)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        if (isVisible == false) {
            return HIDDEN_SYMBOL;
        }
        else {
            if (isItemOnTile("Player") == true && isItemOnTile("Exit") == true) {
                return PLAYER_ON_EXIT_TILE_SYMBOL;
            }
            else if (isItemOnTile("Player") == true && isItemOnTile("Exit") == false) {
                return PLAYER_TILE_SYMBOL;
            }
            else if (isItemOnTile("Player") == false && isItemOnTile("Exit") == true) {
                return EXIT_TILE_SYMBOL;
            }
            else if (isItemOnTile("Obstacle") == true) {
                return OBSTACLE_TILE_SYMBOL;
            }
            else if (list.size() > 0) {
                return UNKNOWN_ITEM_SYMBOL;
            }
            else {
                return EMPTY_TILE_SYMBOL;
            }
        }
    }

}