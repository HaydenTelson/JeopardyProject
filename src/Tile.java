import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hayden on 12/3/2016.
 */
public class Tile {
    String question;    //String to hold question
    int value;          //String to hold Value
    String answer, choice1, choice2, choice3, choice4;  //String to hold answer and choices
    JButton myButton;   //Add button to click for tile
    QuestionWindow myQuestionWindow;    //create second window for answering
    boolean hasbeenAnswered = false;    //question status

    //Tile constructor
    public Tile(String question, int value, String answer, String choice1,
                String choice2, String choice3, String choice4) {
        this.question = question;
        this.value = value;
        this.answer = answer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        myButton = new JButton(Integer.toString(value));
        myButton.addActionListener(new TileButtonListener());
        this.myQuestionWindow = new QuestionWindow();

    }

    //get and set hasbeenanswered status
    public boolean getHasbeenAnswered() {
        return hasbeenAnswered;
    }

    public void setHasbeenAnswered(boolean hasbeenAnswered) {
        this.hasbeenAnswered = hasbeenAnswered;
    }

    //Create button listener for tile
    private class TileButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Tile.this.myQuestionWindow.setVisible(true);    //Set Second window to visable

        }

    }

    //Create question window for answering
    public class QuestionWindow extends JFrame {
        private JPanel panel;               //Created Panel
        private JLabel questionLabel;       //Created label for question
        //make Buttons for choices
        private JRadioButton choice1Button;
        private JRadioButton choice2Button;
        private JRadioButton choice3Button;
        private JRadioButton choice4Button;
        //Group choice buttons
        private ButtonGroup radioButtonGroup;
        //Set second window dimensions
        private final int WINDOW_WIDTH = 500;
        private final int WINDOW_HEIGHT = 500;

        //QuestionWindow Constructor
        public QuestionWindow() {
            setTitle("Question Window");
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            buildPanel();
            add(panel);
        }

        //Building Second panel capabilities
        private void buildPanel() {
            //Populate buttons and labels with Tile info
            questionLabel = new JLabel(Tile.this.question);
            choice1Button = new JRadioButton(Tile.this.choice1);
            choice2Button = new JRadioButton(Tile.this.choice2);
            choice3Button = new JRadioButton(Tile.this.choice3);
            choice4Button = new JRadioButton(Tile.this.choice4);

            //Add buttons to group
            radioButtonGroup = new ButtonGroup();
            radioButtonGroup.add(choice1Button);
            radioButtonGroup.add(choice2Button);
            radioButtonGroup.add(choice3Button);
            radioButtonGroup.add(choice4Button);

            //Give buttons actions
            choice1Button.addActionListener(new RadioButtonListener());
            choice2Button.addActionListener(new RadioButtonListener());
            choice3Button.addActionListener(new RadioButtonListener());
            choice4Button.addActionListener(new RadioButtonListener());

            //add buttons to panel
            panel = new JPanel();
            panel.add(questionLabel);
            panel.add(choice1Button);
            panel.add(choice2Button);
            panel.add(choice3Button);
            panel.add(choice4Button);
        }

        //Give second buttons actions
        private class RadioButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent s) {
                JRadioButton enteredAnswer = (JRadioButton) s.getSource();
                //settings for answering correctly/incorrectly
                if (enteredAnswer.getText().equals(Tile.this.answer)) {
                    // increase current score by whatever the tile's point value is
                    JeopardyGame.score += Tile.this.value;
                    JOptionPane.showMessageDialog(null, "CORRECT! SCORE: " + JeopardyGame.score);
                } else {
                    // decrease current score by whatever the tile's point value is
                    JeopardyGame.score -= Tile.this.value;
                    JOptionPane.showMessageDialog(null, "INCORRECT!\nCorrect answer was: "
                            + Tile.this.answer + "\nSCORE: " + JeopardyGame.score);
                }

                // close the question window
                QuestionWindow.this.setVisible(false);
                QuestionWindow.this.dispose();
                myButton.setVisible(false);

                // Disable the tile's button (dont let the button be clickable)
                JeopardyGame.numAnswered++;
                // incrememt count of # of tiles answered
                if (JeopardyGame.numAnswered == 16) {
                    JOptionPane.showMessageDialog(null, "Final Score: " + JeopardyGame.score);
                    System.exit(0);
                }

            }
        }

    }


}

