import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Created by Hayden on 12/3/2016.
 */
public class JeopardyGame {
    public static int score = 0;    //Value to hold score
    public static int numAnswered = 0;  //Value to hold questions answered

    public static void main(String[] args) throws IOException {
        Tile gameboard[][] = new Tile[4][4];    //Instantiate gameboard array
        File file = new File("JeopardyQuestion.txt");   //Find input file
        Scanner inputFile = new Scanner(file);  //File Scanner
        GridWindow myWindow = new GridWindow(); //Make GUI Gameboard gridwindow

        //Loop to populate tiles
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {

                String question = inputFile.nextLine();     //Obtain Question
                int value = inputFile.nextInt();            //Obtain Question Value
                inputFile.nextLine();
                String answer = inputFile.nextLine();       //Obtain Answer
                String choice1 = inputFile.nextLine();      //Obtain choice1
                String choice2 = inputFile.nextLine();      //Obtain choice2
                String choice3 = inputFile.nextLine();      //obtain choice3
                String choice4 = inputFile.nextLine();      //obtain choice4
                //Make Tiles
                Tile myTile = new Tile(question, value, answer, choice1, choice2, choice3, choice4);
                myWindow.add(myTile.myButton);
                gameboard[i][j] = myTile;
            }
        }
        myWindow.setVisible(true);

        inputFile.close();

    }


}

