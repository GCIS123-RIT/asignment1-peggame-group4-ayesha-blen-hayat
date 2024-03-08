import java.io.IOException;
import java.util.Scanner;

public class Project1Main {
    public static void main(String[] args) throws IOException {

        playGame();
        
    }
    public static void playGame() throws IOException{
        System.out.print("Please enter the name of your file:");
        Scanner scanner = new Scanner(System.in);
        String filename=scanner.nextLine();
        PegGameFileReader readFile = new PegGameFileReader();
        

        PegGameCLI CLI = new PegGameCLI();

        System.out.println("Here is the board start playing:)"); 
        System.out.println(readFile.fileRead(filename));
        CLI.PegGameField(readFile.fileRead(filename));
        

        scanner.close(); 
    }
    
}
