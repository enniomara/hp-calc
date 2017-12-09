package hpcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Controller {

    private HPCalculator hpCalculator = new HPCalculator();
    private boolean pushedValue, operation;

    @FXML
    private TextField stackAtFirstPlace;

    @FXML
    private TextField stackAtSecondPlace;

    @FXML
    private TextField stackAtThirdPlace;

    @FXML
    private TextField stackAtFourthPlace;

    /**
     * Handler for number and comma buttons.
     * @param event The event.
     */
    @FXML
    private void numberButtonHandler(ActionEvent event){
        double input = Double.parseDouble(((Button) event.getSource()).getText());
        if(!pushedValue && !stackAtFirstPlace.getText().startsWith("0")) {
            stackAtFirstPlace.setText(String.valueOf(Double.parseDouble(stackAtFirstPlace.getText()) * 10 + input));
            updateBoard(hpCalculator.processNumber(Double.parseDouble(stackAtFirstPlace.getText()), !pushedValue));
        }else {
            updateBoard(hpCalculator.processNumber(input, !operation));
        }
        pushedValue = false;
    }

    /**
     * Handler for operations.
     * @param event The event.
     */
    @FXML
    private void operationButtonHandler(ActionEvent event){
        String input = ((Button) event.getSource()).getText();
        double[] values;
        try {
            if (input.equals("ENTER")) {
                values = hpCalculator.processNumber(Double.parseDouble(stackAtFirstPlace.getText()), false, true);
            } else if (input.equals("CLX")) {
                values = hpCalculator.processNumber(0.0, false);
            } else {
                values = hpCalculator.processOperation(input);
                operation = true;
            }
            updateBoard(values);
            pushedValue = true;
        } catch (Error e){
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    /**
     * Update text fields.
     * @param values The new values.
     */
    private void updateBoard(double[] values){
        stackAtFirstPlace.setText(String.valueOf(values[0]));
        stackAtSecondPlace.setText(String.valueOf(values[1]));
        stackAtThirdPlace.setText(String.valueOf(values[2]));
        stackAtFourthPlace.setText(String.valueOf(values[3]));
        System.out.println(Arrays.toString(values));
    }
}
