import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private int playerX;
    private int playerY;

    private Grid grid;

    public Player(Grid grid) {
        this.grid = grid;

        if (grid.getPlayerTile() == null) {
            grid.getTileAtPosition(0, grid.getGridHeight() - 1).addItemToTile("Player");
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }
        else {
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }

        
    }

    public int getXPosition() {
       return playerX;
    }

    public int getYPosition() {
       return playerY;
    }

    public boolean foundExit() {
        if (grid.getPlayerTile().isItemOnTile("Exit")) {
            return true;
        }
        else {
            return false;
        }
    }

    public int[] getValidMoves() {

        ArrayList<Integer> validMoves = new ArrayList<Integer>();
        validMoves.add(0);
        validMoves.add(1);
        validMoves.add(2);
        validMoves.add(3);
        validMoves.add(4);

        int xAbove = getXPosition();
        int yAbove = getYPosition() - 1;

        int xRight = getXPosition() + 1;
        int yRight = getYPosition();

        int xLeft = getXPosition() - 1;
        int yLeft = getYPosition();

        int xDown = getXPosition();
        int yDown = getYPosition() + 1;

        if (getXPosition() == 0) {
            validMoves.remove(4);
        }
        else if (getXPosition() == grid.getGridWidth() - 1) {
            validMoves.remove(2);
        }
        else {
            ;
        }

        if (getYPosition() == 0) {
            validMoves.remove(1);
        }
        else if (getYPosition() == grid.getGridHeight() - 1) {
            validMoves.remove(3);
        }
        else {
            ;
        }

        if (grid.getTileAtPosition(xAbove, yAbove) != null) {
            if (grid.getTileAtPosition(xAbove, yAbove).isItemOnTile("Obstacle") == true) {
                validMoves.remove(Integer.valueOf(1));
            }
        }

        if (grid.getTileAtPosition(xRight, yRight) != null) {
            if (grid.getTileAtPosition(xRight, yRight).isItemOnTile("Obstacle") == true) {
                validMoves.remove(Integer.valueOf(2));
            }
        }

        if (grid.getTileAtPosition(xDown, yDown) != null) {
            if (grid.getTileAtPosition(xDown, yDown).isItemOnTile("Obstacle") == true) {
                validMoves.remove(Integer.valueOf(3));
            }
        }

        if (grid.getTileAtPosition(xLeft, yLeft) != null) {
            if (grid.getTileAtPosition(xLeft, yLeft).isItemOnTile("Obstacle") == true) {
                validMoves.remove(Integer.valueOf(4));
            }
        }

        int[] moves = new int[validMoves.size()];

        for (int p = 0; p < validMoves.size(); p++) {
            moves[p] = validMoves.get(p);
        }
        
        return moves;
    }

    public void takeAction(int action){

        int xAbove = getXPosition();
        int yAbove = getYPosition() - 1;

        int xRight = getXPosition() + 1;
        int yRight = getYPosition();

        int xLeft = getXPosition() - 1;
        int yLeft = getYPosition();

        int xDown = getXPosition();
        int yDown = getYPosition() + 1;

        if (action == 0) {
            ;
        }
        else if (action == 1) {
            grid.getPlayerTile().removeItemFromTile("Player");
            grid.getTileAtPosition(xAbove, yAbove).addItemToTile("Player");
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }
        else if (action == 2) {
            grid.getPlayerTile().removeItemFromTile("Player");
            grid.getTileAtPosition(xRight, yRight).addItemToTile("Player");
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }
        else if (action == 3) {
            grid.getPlayerTile().removeItemFromTile("Player");
            grid.getTileAtPosition(xDown, yDown).addItemToTile("Player");
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }
        else if (action == 4) {
            grid.getPlayerTile().removeItemFromTile("Player");
            grid.getTileAtPosition(xLeft, yLeft).addItemToTile("Player");
            this.playerX = grid.getPlayerTile().getXPosition();
            this.playerY = grid.getPlayerTile().getYPosition();
        }
        else {
            ;
        }
    }

    public void updateVisibility(int viewDistance) {

        for (int x = 0; x < grid.getGridWidth(); x++) {

            for (int y = 0; y < grid.getGridHeight(); y++) {
                if (playerX == x && playerY == y) {
                    ;
                }
                else {
                    grid.getTileAtPosition(x, y).setVisibility(false);
                }
            }
        }

        //Visiblity for above;
        int incrementAbove = 0;

        while (incrementAbove != viewDistance) {
            incrementAbove ++;

            int xAbove = getXPosition();
            int yAbove = getYPosition() - incrementAbove;

            if (grid.getTileAtPosition(xAbove, yAbove) == null) {
                ;
            }
            else {
                if (grid.getTileAtPosition(xAbove, yAbove).isItemOnTile("Obstacle") == true) {
                    grid.getTileAtPosition(xAbove, yAbove).setVisibility(true);
                    break;
                }
                else {
                    grid.getTileAtPosition(xAbove, yAbove).setVisibility(true);
                }
            }
        }

        //Visibility for right
        int incrementRight = 0;

        while (incrementRight != viewDistance) {
            incrementRight ++;

            int xRight = getXPosition() + incrementRight;
            int yRight = getYPosition();

            if (grid.getTileAtPosition(xRight, yRight) == null) {
                ;
            }
            else {
                if (grid.getTileAtPosition(xRight, yRight).isItemOnTile("Obstacle") == true) {
                    grid.getTileAtPosition(xRight, yRight).setVisibility(true);
                    break;
                }
                else {
                    grid.getTileAtPosition(xRight, yRight).setVisibility(true);
                }
            }
        }

        //Visibility for left
        int incrementLeft = 0;

        while (incrementLeft != viewDistance) {
            incrementLeft ++;

            int xLeft = getXPosition() - incrementLeft;
            int yLeft = getYPosition();

            if (grid.getTileAtPosition(xLeft, yLeft) == null) {
                ;
            }
            else {
                if (grid.getTileAtPosition(xLeft, yLeft).isItemOnTile("Obstacle") == true) {
                    grid.getTileAtPosition(xLeft, yLeft).setVisibility(true);
                    break;
                }
                else {
                    grid.getTileAtPosition(xLeft, yLeft).setVisibility(true);
                }
            }
        }

        //Visibility for down
        int incrementDown = 0;

        while (incrementDown != viewDistance) {
            incrementDown ++;

            int xDown = getXPosition();
            int yDown = getYPosition() + incrementDown;

            if (grid.getTileAtPosition(xDown, yDown) == null) {
                ;
            }
            else {
                if (grid.getTileAtPosition(xDown, yDown).isItemOnTile("Obstacle") == true) {
                    grid.getTileAtPosition(xDown, yDown).setVisibility(true);
                    break;
                }
                else {
                    grid.getTileAtPosition(xDown, yDown).setVisibility(true);
                }
            }
        }

        

    }
}
