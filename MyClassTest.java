import java.beans.Transient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert.assertEquals;


    
@Testable
public class MyClassTest {
    String[][] expectedBoard = {{"o","o","o","o","o"},{".","o","o","o","o"},{"o",".","o","o","o"},{"o","o",".","o","o"},{"o","o","o",".","o"}};
    String expected= expectedBoard[0][0];

    @Test
    public void readingtest(String filename) //testing file : fiveByFive.txt
    {
        //setup
        String expectedSize= "5";
        FileReader reader = new FileReader(filename);
        BufferedReader fileReader = new BufferedReader(reader);
        
        //invoke 
        PegGameFileReader h = new PegGameFileReader();
        System.out.println(h.fileRead(filename));
        String boardSize = fileReader.readLine();

        //analyse
        assertEquals(expectedSize,boardSize); //checks if boardsize is equal

        assertEquals(expectedBoard, h); //checks if boards are the same 
        
    }

    @Test  
    public void locationtest(){ //tests location class

        int realRow= Location.getRow(); //retrives row
        int realColum= Location.getCol();// retrives colum

        String real = expectedBoard[realRow][realColum];

        assertEquals(expected,real); //compares both locations
    }

    

}