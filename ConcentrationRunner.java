/** 
 * Play the game of Concnetration
 * 
 * The runner creates a game board and shows the board. It gets a 2-tile selection from the user,
 * checks if the cards at the 2 tile locations match, and then re-displays the board.
 */
import java.util.Scanner;
public class ConcentrationRunner{
    // create the game 
    private static Concentration game = new Concentration();

    public static void main(String[] args){
        // input object for the BlueJ console
        Scanner in = new Scanner(System.in);
        // instructions
        System.out.println("Welcome to the game of Concentration.");
        System.out.println("Select the tile locations you want to see,");
        System.out.println("or enter any non-integer character to quit.");
        System.out.println("(You will need to know 2-dim arrays to play!\nThe first number is the row while the second is the column.)");
        System.out.println("\nPress Enter to continue...");
        in.nextLine();
        // play until all tiles are matched
        while(!game.allTilesMatch()){
            displayBoard();
            // player selects first tile, if not an integer, quit game
            int i1 = -1;
            int j1 = -1;
            System.out.print("First choice (i j): ");
            String str = in.nextLine();
            int n = str.indexOf(" ");
            if (str != null){
                String y = str.substring(0, n);
                i1 = Integer.parseInt(y); 
                System.out.println("your row choice is " + i1);
                wait(1);
            }
            else{
                quitGame();
            }
            if (str != null){
                String x = str.substring(n+1, str.length());
                j1 = Integer.parseInt(x);
                System.out.println("your column choice is " + j1 + "\n");
                wait(1);
            }
            else{
                quitGame();
            }
            in.reset(); // ignore any extra input
            // display board with first tile face up
            displayBoard();
            game.showFaceUp(i1, j1);
            // player selects second tile, if not an integer, quit game
            int i2 = -1;
            int j2 = -1;
            System.out.print("Second choice (i j): ");
            String str2 = in.nextLine();
            int n2 = str2.indexOf(" ");
            if (str != null){
                String y2 = str2.substring(0, n);
                i2 = Integer.parseInt(y2); 
                System.out.println("your row choice is " + i2);
                wait(1);
            }
            else{
                quitGame();
            }
            if (str != null){
                String x2 = str2.substring(n+1, str.length());
                j2 = Integer.parseInt(x2);
                System.out.println("your column choice is " + j2);
                wait(1);
            }
            else{
                quitGame();
            }
            in.reset(); // ignore any extra input
            // display board with additional second tile face up
            displayBoard();
            game.showFaceUp(i2, j2);
            // determine if a match was found
            String matched = game.checkForMatch(i1, j1, i2, j2);
            System.out.println(matched);
            // wait 2 seconds to start the next turn
            wait(2); 
        }
        displayBoard();
        System.out.println("Game Over!");
    }
    /**
     * Clear the console and show the game board
     * Tiles can either indicate the card is  face up or face down
     */
    public static void displayBoard(){
        System.out.print(game);
    }
    /**
     * Wait n second before clearing the console
     */
    private static void wait(int n){
        try  {
            Thread.sleep(n * 1000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
    /** 
     * User quits game
     */
    private static void quitGame(){
        System.out.println(game);
        System.out.println("Quit game!");
        System.exit(0);
    }
}