import javax.swing.*;
import java.awt.*;

/**
 * Created by Hayden on 12/11/2016.
 */
public class GridWindow extends JFrame {
    private final int WINDOW_WIDTH = 800;   //Gameboard window width
    private final int WINDOW_HEIGHT = 800;  //Gameboard window height

    //create Gridwindow layout
    public GridWindow() {
        setTitle("Jeopardy Review Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));
        JLabel chapter4 = new JLabel("Chapter 4");  //label for chapter 4
        JLabel chapter5 = new JLabel("Chapter 5");  //label for chapter 5
        JLabel chapter6 = new JLabel("Chapter 6");  //label for chapter 6
        JLabel chapter7 = new JLabel("Chapter 7");  //label for chapter 7

        //Add labels to panel
        add(chapter4);
        add(chapter5);
        add(chapter6);
        add(chapter7);

    }
}