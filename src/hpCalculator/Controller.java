package hpCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Controller {

    private HPCalculator hpCalculator = new HPCalculator();
    private boolean enter, operation;

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
     *
     * @param event The event.
     */
    @FXML
    private void numberButtonHandler(ActionEvent event) {
        double input = Double.parseDouble(((Button) event.getSource()).getText());
        if (stackAtFirstPlace.getText().equals("0.0") || enter) {
            updateBoard(hpCalculator.processNumber(input, true));
        } else if (!operation) {
            stackAtFirstPlace.setText(String.valueOf(Double.parseDouble(stackAtFirstPlace.getText()) * 10 + input));
            updateBoard(hpCalculator.processNumber(Double.parseDouble(stackAtFirstPlace.getText()), true));
        } else {
            updateBoard(hpCalculator.processNumber(input, false));
        }
        operation = false;
        enter = false;
    }

    /**
     * Handler for operations.
     *
     * @param event The event.
     */
    @FXML
    private void operationButtonHandler(ActionEvent event) {
        String input = ((Button) event.getSource()).getText();
        double[] values;
        try {
            switch (input) {
                case "ENTER":
                    values = hpCalculator.processNumber(Double.parseDouble(stackAtFirstPlace.getText()), false);
                    enter = true;
                    break;
                case "+":
                    values = hpCalculator.processOperation(Operations.PLUS);
                    operation = true;
                    break;
                case "-":
                    values = hpCalculator.processOperation(Operations.MINUS);
                    operation = true;
                    break;
                case "*":
                    values = hpCalculator.processOperation(Operations.TIMES);
                    operation = true;
                    break;
                case "/":
                    values = hpCalculator.processOperation(Operations.DIVIDES);
                    operation = true;
                    break;
                case "CSTK":
                    values = hpCalculator.processOperation(Operations.CLEARSTACK);
                    operation = true;
                    break;
                case "CHS":
                    values = hpCalculator.processOperation(Operations.CHS);
                    operation = true;
                    break;
                case "CLX":
                    values = hpCalculator.processOperation(Operations.CLEAR);
                    break;
                default:
                    throw new Error("Operation does not exist.");
            }
            updateBoard(values);
        } catch (Error e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
        }

    }

    /**
     * Update text fields.
     *
     * @param values The new values.
     */
    private void updateBoard(double[] values) {
        stackAtFirstPlace.setText(String.valueOf(values[0]));
        stackAtSecondPlace.setText(String.valueOf(values[1]));
        stackAtThirdPlace.setText(String.valueOf(values[2]));
        stackAtFourthPlace.setText(String.valueOf(values[3]));
        System.out.println(Arrays.toString(values));
    }
}
