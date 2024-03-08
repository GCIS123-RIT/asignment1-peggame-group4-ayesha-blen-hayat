
import java.util.Scanner;

public class PegGameCLI {
    private static final String QUIT= "quit";
    private static final String MOVE= "move";
    
    public void PegGameField(SquareBoardGame game){
        Scanner scanner = new Scanner(System.in);
        boolean gamePlay = true; 
        // game is running until the user types 'quit'
        System.out.println("Welcome to the Game!");
        System.out.println("To move specify your starting row and column and your destination row and column respectively(r1 c1 r2 c2)");
        System.out.println("If you want to stop playing type quit.");

        while(gamePlay){
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.equals(QUIT)) {
                System.out.println("Exiting the game. Thanks for playing!");
                break;
            }
    
            if (input.startsWith(MOVE)) {
                String[] splitInput = input.split("\\s+");
    
                if (splitInput.length != 5) {
                    System.out.println("Invalid input: Please enter a valid move.");
                    continue;
                }
    
                try {
                    int r1 = Integer.parseInt(splitInput[1]);
                    int c1 = Integer.parseInt(splitInput[2]);
                    int r2 = Integer.parseInt(splitInput[3]);
                    int c2 = Integer.parseInt(splitInput[4]);
    
                    Move move = new Move(new Location(r1, c1), new Location(r2, c2));
    
                    try {
                        game.makeMove(move);
                        System.out.println("Move successful!");
                        System.out.println(game.toString());
    
                        if (game.getGameState() == GameState.STALEMATE || game.getGameState() == GameState.WON) {
                            System.out.println("Game Over: " + game.getGameState());
                            gamePlay = false;
                        }
                    } catch (PegGameException e) {
                        System.out.println("Invalid move: " + e.getMessage());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid move: Please enter integers for the rows and columns.");
                }
            } else {
                System.out.println("Invalid input: Please choose a valid move.");
            }
        }
    
        scanner.close();
            
            
    }

}


    
