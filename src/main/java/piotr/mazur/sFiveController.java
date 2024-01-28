package piotr.mazur;

import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class sFiveController implements Initializable {

    @FXML
    private TextArea taComment;

    @FXML
    private Button checkout;

    @FXML
    private Text errorMsg;

    @FXML
    private TextField creditCard;

    // returns to cart menu
    @FXML
    private void back(ActionEvent e) throws Exception {
        App.setRoot("cart");
    }

    // exits program
    @FXML
    private void exit(ActionEvent e) throws Exception {
        System.exit(0);
    }

    // checks if credit card number is valid
    @FXML
    private void purchase(ActionEvent e) throws Exception {
        String card = creditCard.getText();
        if (card.length() != 16) {
            errorMsg.setFill(Color.BLACK);
            errorMsg.setText("Invalid Credit Card Number");
            sTwoController.fadeOut(errorMsg, 2000);

        } else {
            errorMsg.setFill(Color.GREEN);
            errorMsg.setText("Purchase Successful, Thank You!/n Returning to Main Menu...");
            sTwoController.fadeOut(errorMsg, "mainMenu");
            sFourController.cartMap.clear();
            sThreeController.cart.clear();
        }
    }

    // runs when scene is initiated
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        taComment.setOpacity(1);
        taComment.setText("\n");

        // if the cart is empty, cart is empty is printed & text is disabled
        if (sFourController.cartMap.isEmpty()) {
            taComment.setText("Cart is Empty");
            creditCard.setDisable(true);
            checkout.setDisable(true);
        } else {
            creditCard.setDisable(false);
            checkout.setDisable(false);

            // total cost is calculated
            double totalCost = 0;
            for (Food food : sFourController.cartMap.keySet()) {
                totalCost += food.getPrice() * sFourController.cartMap.get(food);
            }
            totalCost = Math.round(totalCost * 100.0) / 100.0;
            double hst = totalCost * 1.13;
            double totalHST = Math.round(hst * 100.0) / 100.0;

            // column is printed
            String column = String.format("%-15s %-10s %-10s\n", "Item", "Price", "#");
            taComment.appendText(column);

            // menu is printed
            for (Food food : sFourController.cartMap.keySet()) {
                String menu = String.format("%-15s %-10s x%-10s\n", food.getName(), food.getPrice(),
                        sFourController.cartMap.get(food));
                taComment.appendText(menu);

            }
            taComment.appendText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            taComment.appendText("Total: $" + totalCost);
            taComment.appendText("\nTotalHST: $" + totalHST);
        }
    }
}
