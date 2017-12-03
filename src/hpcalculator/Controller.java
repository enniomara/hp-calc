package hpcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {

    private HPCalculator hpCalculator = new HPCalculator();
    private boolean pushedValue;

    @FXML
    private TextField textField_1;

    @FXML
    private TextField textField_2;

    @FXML
    private TextField textField_3;

    @FXML
    private TextField textField_4;

    /**
     * Handler for number and comma buttons.
     * @param event The event.
     */
    @FXML
    private void numberButtonHandler(ActionEvent event){
        String input = "";
        if(event.getSource() instanceof Button) input = ((Button) event.getSource()).getText();
        if(!pushedValue && !textField_1.getText().startsWith("0")) {
            textField_1.appendText(input);
        }else {
            textField_1.setText(input);
        }
        pushedValue = false;
    }

    /**
     * Handler for operations.
     * @param event The event.
     */
    @FXML
    private void operationButtonHandler(ActionEvent event){
        String input = "";
        if(event.getSource() instanceof Button) input = ((Button) event.getSource()).getText();
        Double[] values;
        try {
            if (input.equals("ENTER")) {
                values = hpCalculator.processInput(textField_1.getText());
                updateBoard(values, true);
            } else if (input.equals("CLX")) {
                values = hpCalculator.processInput("0.0");
                updateBoard(values, false);
            } else {
                values = hpCalculator.processInput(input);
                updateBoard(values, false);
            }
            pushedValue = true;
        } catch (Error e){
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    /**
     * Update text fields.
     * @param values The new values.
     */
    private void updateBoard(Double[] values, boolean enter){
        if(enter){
            textField_1.setText(String.valueOf(values[0]));
            textField_2.setText(String.valueOf(values[0]));
            textField_3.setText(String.valueOf(values[1]));
            textField_4.setText(String.valueOf(values[2]));
        } else {
            textField_1.setText(String.valueOf(values[0]));
            textField_2.setText(String.valueOf(values[1]));
            textField_3.setText(String.valueOf(values[2]));
            textField_4.setText(String.valueOf(values[3]));
        }
    }
}
