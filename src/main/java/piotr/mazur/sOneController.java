package piotr.mazur;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class sOneController {

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField usernameText;

    @FXML
    private Text errorMsg, successMsg;

    // runs when login button is clicked
    @FXML
    private void continew(ActionEvent e) throws Exception {

        errorMsg.setText("");
        String username = usernameText.getText();
        String password = passwordText.getText();

        Scanner sc;

        // Scanners initialized for file and user input
        sc = new Scanner(new File(App.getText("users.txt").toURI()));
        HashMap<String, String> userInfo = new HashMap<String, String>();

        // Loop reads the file and stores each username and password in a HashMap
        while (sc.hasNextLine()) {
            try {
                String[] line = sc.nextLine().split(":");
                userInfo.put(line[0], line[1]);
            } catch (ArrayIndexOutOfBoundsException a) {
                String[] line = sc.nextLine().split(":");
                userInfo.put(line[0], line[1]);
            }
        }

        // Checks if username and password are correct
        if (userInfo.containsKey(username) && userInfo.get(username).equals(password)) {
            successMsg.setText("Login successful!");
            sTwoController.fadeOut(successMsg, "mainMenu");

        }
        // If username and password are incorrect, user is prompted to try again or
        // create an account
        else {
            errorMsg.setText("Incorrect username or password. Please try again or create an account.");
            sTwoController.fadeOut(errorMsg, 2000);
        }
    }

    // takes user to signup page
    @FXML
    private void signUp(ActionEvent e) throws Exception {
        App.setRoot("signUp");
    }
}
