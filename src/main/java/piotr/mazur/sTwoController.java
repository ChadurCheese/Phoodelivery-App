package piotr.mazur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class sTwoController implements Initializable{

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Text errorMsg;
    
    @FXML
    private void submit(ActionEvent e) throws Exception {
        
        // errorMsg.setText("");
        String user = username.getText();
        String pass = password.getText();

        // saves username and password to file
        try {
            File users = new File(App.getText("users.txt").toURI());
            PrintWriter pw = new PrintWriter(new FileWriter(users, true));
            pw.print("\n" + user + ":" + pass);
            pw.close();
            errorMsg.setFill(javafx.scene.paint.Color.GREEN);
            errorMsg.setText("Account Created");
            fadeOut(errorMsg, "loginPage");
    
            
        } catch (IOException b) {
            errorMsg.setText("Error: " + b.getMessage());
            fadeOut(errorMsg, "");
        }
    }
   
    @FXML
    private void back(ActionEvent e) throws Exception {
        App.setRoot("loginPage");
    }
    
    public static void fadeOut(Text text, String fxml) throws Exception{
        FadeTransition fade = new FadeTransition();
        fade.setDuration(javafx.util.Duration.millis(3000));
        fade.setNode(text);
        fade.setFromValue(1);
        fade.setToValue(0);
        if (!fxml.equals("")) {
            fade.setOnFinished((ActionEvent event) -> {
                try {
                    App.setRoot(fxml);
                } catch (Exception e) {
                    e.printStackTrace();
                };
            });
        }
        fade.play();
    }

    public static void fadeOut(Text text, int duration) throws Exception{
        FadeTransition fade = new FadeTransition();
        fade.setDuration(javafx.util.Duration.millis(duration));
        fade.setNode(text);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }


}
