import java.util.Scanner;
import java.util.Arrays;

public class Game {
    
    private Scanner sc = new Scanner(System.in);
    
    private int viewDistance;

    private Grid grid;
    private Player player;

    public Game() {
         System.out.print("Enter the grid width: ");
         int width = sc.nextInt();

         System.out.print("Enter the grid height: ");
         int height = sc.nextInt();

        //  System.out.print("Enter the number of obstacles: ");
        //  int obstacles = sc.nextInt();

         System.out.print("Enter the players view distance: ");
         this.viewDistance = sc.nextInt();
         
         grid = new Grid(width, height); //should also take obstacles as a paremeter but I haven't implemented yet
         player = new Player(grid);
    }

    public void render() {
        player.updateVisibility(viewDistance);
        grid.printGrid();
    }

    public int input() {

        int move = -1;

        while (true) {

            System.out.println("Valid Actions:");

            for (int i: player.getValidMoves()) {
                if (i == 0) {
                    System.out.println(i + ": Do Nothing");
                }
                else if (i == 1) {
                    System.out.println(i + ": Move Up");
                }
                else if (i == 2) {
                    System.out.println(i + ": Move Right");
                }
                else if (i == 3) {
                    System.out.println(i + ": Move Down");
                }
                else if (i == 4) {
                    System.out.println(i + ": Move Left");
                }
                else {
                    ;
                }
            }

            System.out.print("Enter an action: ");
            int action = sc.nextInt();

            int counter = 0;
            for (int i: player.getValidMoves()) {
                if (action == i) {
                    counter ++;
                }
            }

            if (counter > 0) {
                move = action;
                break;
            }
            else {
                System.out.println("Invalid Action! Please select a valid action from the list.");
            }
        }

        return move;

    }

    public void takeAction(int a) {
        player.takeAction(a);

    }

    public void run() {
        
        grid.addExit();
        
        while (true) {

            render();
            int action = input();
            takeAction(action);

            if (player.foundExit() == true) {
                render();
                System.out.println("Congratulations, you have found the Exit!");
                break;
            }
            else {
                ;
            }
        }

    }

    public static void main(String[] args) {

        
        Game game = new Game();

        game.run();
    }
}