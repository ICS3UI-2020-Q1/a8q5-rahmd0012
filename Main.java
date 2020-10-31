import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;

  JButton firstButton;
  JButton secondButton;  
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // initialize the labels
    firstLabel = new JLabel("Guess the number between 0 and 100:");
    secondLabel = new JLabel(); 

    // set the size and location of the labels
    firstLabel.setBounds(10, 10, 400, 30);
    secondLabel.setBounds(10, 200, 400, 30);

    // initialize the text fields
    firstInput = new JTextField();

    // set the location and size of text fields
    firstInput.setBounds(10, 70, 100, 30);

    // initialize the buttons
    firstButton = new JButton("Submit");
    secondButton = new JButton("New Number");

    // set the location and size of the buttons
    firstButton.setBounds(10, 110, 200, 30);
    secondButton.setBounds(220, 110, 200, 30);

    // add an action listener to the buttons
    firstButton.addActionListener(this);
    secondButton.addActionListener(this);

    // add an action command to the buttons
    firstButton.setActionCommand("Submit");
    secondButton.setActionCommand("New Number");

    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    mainPanel.add(firstInput);

    mainPanel.add(firstButton);
    mainPanel.add(secondButton);

    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // create the random generator
    Random rand = new Random();

    // create a random number
    int randNum = rand.nextInt(100) + 1;
    
    // declare the guess variable
    int guess; 

    // do something depending on what button is pressed
    if(command.equals("Submit")){
      // get the text from the text box
      String firstText = firstInput.getText();

      // change the string into an integer
      int firstNum = Integer.parseInt(firstText);
      if(firstNum > randNum){
        // tell them it's too high
        secondLabel.setText("Your guess of " + firstNum + " is to high!");
      }else if(firstNum < randNum){
        // tell them it's too low
        secondLabel.setText("Your guess of " + firstNum + " is to low!");
      }else if(firstNum == randNum){
        // tell them they won 
        secondLabel.setText("Congratulations! You Win!");
      }
    }else if(command.equals("New Number")){
      // reset the text field number to show nothing
      firstInput.setText("");
      // reset the second label to show nothing
      secondLabel.setText("");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
