import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

//*1) We need a text field for the user to type in their guess; 2) we need two buttons, one to press to Guess and one to press to Play Again; 3) we need three labels, one to prompt the user to enter a guess, one to tell the user whether they are too high or too low, and one to tell the user what the last guess was; 4) we need a Random number object; and 5) we need an int to store the random number in//*

public class GuessingGame implements ActionListener {
JTextField field; 
  JButton guessButton;
  JButton playAgainButton;
  JLabel jlabPrompt, jlabContents1, jlabContents2; 
  int randomNum;


  GuessingGame() {
    Random r = new Random();
    randomNum = r.nextInt(101)+1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);
    
    field = new JTextField(10); 
    field.setActionCommand("myTF"); 

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    
    // Add action listeners. 
    field.addActionListener(this); 
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    
    // Create the labels. 
    jlabPrompt = new JLabel("Enter your guess: "); 
    jlabContents1 = new JLabel(""); 
    jlabContents2 = new JLabel("");

    // Add the components to the content pane. 
    frame.add(jlabPrompt); 
    frame.add(field); 
    frame.add(guessButton); 
    frame.add(jlabContents1);
    frame.add(jlabContents2);
    frame.add(playAgainButton);

    // Display the frame. 
    frame.setVisible(true); 
  }

  //Handle action events.
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int userGuessNum = Integer.parseInt(field.getText());
      
      if (userGuessNum < randomNum) {
        jlabContents1.setText("Too low!");
      }
      
      else if (userGuessNum > randomNum) {
        jlabContents1.setText("Too high!");
      }

      else {
        jlabContents1.setText("You got it!");
      }

      jlabContents2.setText("Last guess was: " + field.getText());

    }

    else if (ae.getActionCommand().equals("Play Again")) {
      Random r = new Random();
      randomNum = r.nextInt(101)+1;
      field.setText("");
      jlabContents1.setText ("");
      jlabContents2.setText ("");

    }

    else {
      jlabContents1.setText("You pressed Enter. Please press the Guess Button.");
    }
      
    }

}

