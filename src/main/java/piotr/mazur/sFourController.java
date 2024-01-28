package piotr.mazur;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class sFourController implements Initializable {

    // arraylist for food items
    static ArrayList<Food> newCart = sThreeController.cart;
    static ArrayList<Food> order = new ArrayList<Food>();

    // hashmap for cart
    static HashMap<Food, Integer> cartMap = new HashMap<Food, Integer>();

    static int cartSize = 0;

    @FXML
    private TextArea taComment;

    @FXML
    private Text error1, error2, editCart;

    @FXML
    private TextField fname1, fname2, quantity;

    // takes user back to main menu
    @FXML
    private void back(ActionEvent e) throws Exception {
        order.clear();
        App.setRoot("mainMenu");
    }

    // takes user to checkout page
    @FXML
    private void checkout(ActionEvent e) throws Exception {
        App.setRoot("checkout");
    }

    // removes item from cart
    @FXML
    private void remove(ActionEvent e) throws Exception {
        String item = fname1.getText();
        boolean exists = false;
        for (Food food : cartMap.keySet()) {
            if (food.getName().toLowerCase().equals(item.toLowerCase())) {
                exists = true;
                sThreeController.cart.remove(food);
                cartMap.remove(food);
                error1.setFill(Color.GREEN);
                error1.setText("Item Removed");
                sTwoController.fadeOut(error1, "cart");
                break;
            }
        }
        if (!exists) {
            error1.setFill(Color.RED);
            error1.setText("This Item does not exist...");
            sTwoController.fadeOut(error1, 2000);
        }

    }

    // edits quantity of item in cart
    @FXML
    private void edit(ActionEvent e) throws Exception {
        String number = quantity.getText();
        String item = fname2.getText();
        boolean exists = false;

        for (Food food : cartMap.keySet()) {
            // checks if item exists in cart
            if (food.getName().toLowerCase().equals(item.toLowerCase())) {
                exists = true;
                try {
                    // checks if quantity is 0 and if so removes it
                    if (Integer.parseInt(number) == 0) {
                        cartMap.remove(food);
                        sThreeController.cart.remove(food);
                        error2.setFill(Color.GREEN);
                        error2.setText("Item Removed");
                        sTwoController.fadeOut(error2, "cart");
                        break;
                    }
                    // Edits the quantity in cart hashmap and arraylist
                    else {
                        error2.setFill(Color.GREEN);
                        error2.setText("Quantity Updated");
                        sTwoController.fadeOut(error2, "cart");
                        cartMap.remove(food);
                        cartMap.put(food, Integer.parseInt(number));
                        break;

                    }
                    // Checks if quantity was inputted correctly
                } catch (NumberFormatException n) {
                    error2.setFill(Color.RED);
                    error2.setText("Invalid Quantity");
                    sTwoController.fadeOut(error2, 2000);
                }
            }
        }
        // Outputs if item does not exist
        if (!exists) {
            error2.setFill(Color.RED);
            error2.setText("This Item does not exist...");
            sTwoController.fadeOut(error2, 2000);
        }
    }

    // runs when scene initialized
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        taComment.setOpacity(1);
        // checks if user ordered anything new, if so it adds it to the cart HashMap
        if (newCart.size() != cartSize) {
            for (Food food : order) {
                if (cartMap.containsKey(food)) {
                    cartMap.put(food, cartMap.get(food) + 1);
                } else {
                    cartMap.put(food, 1);
                }
            }
            // Cartsize is updated to the new size of the cart
            order.clear();
            cartSize = newCart.size();
        }

        // if the cart is empty, cart is empty is printed
        if (cartMap.isEmpty()) {
            taComment.setText("Cart is Empty");
        } else {
            // total cost is calculated
            double totalCost = 0;
            for (Food food : cartMap.keySet()) {
                totalCost += food.getPrice() * cartMap.get(food);
            }
            totalCost = Math.round(totalCost * 100.0) / 100.0;

            String column = String.format("%-15s %-10s %-10s\n", "Item", "Price", "#");
            taComment.appendText(column);

            // menu is printed
            for (Food food : cartMap.keySet()) {
                String menu = String.format("%-15s %-10s x%-10s\n", food.getName(), food.getPrice(), cartMap.get(food));
                taComment.appendText(menu);

            }
            taComment.appendText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            taComment.appendText("Total: $" + totalCost);
        }

    }

}
