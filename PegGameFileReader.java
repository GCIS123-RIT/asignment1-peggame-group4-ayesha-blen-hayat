import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PegGameFileReader {
    
    public SquareBoardGame fileRead(String fileToRead) throws IOException {      
        
        try (
            FileReader fr = new FileReader(fileToRead);
            BufferedReader br = new BufferedReader(fr); 
            ) 
            {
            
            int boardsize = Integer.parseInt(br.readLine().trim()); 

            char[][] board = new char[boardsize][boardsize];

        
            for (int i = 0; i < boardsize; i++) 
            {
                String line = br.readLine().trim();

                for (int j = 0; j < boardsize; j++) { 
                    if (line.charAt(j) == 'o') 
                    {  
                        board[i][j] = 'o';

                    } else if(line.charAt(j) == '-') 
                    { 
                        board[i][j] = '-';
                    }
                }
            }
            
        return new SquareBoardGame(boardsize, board);} 
    }

}

