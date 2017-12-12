package hpCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.EmptyStackException;

public class Controller {
    private HPCalculator hpCalculator = new HPCalculator();

    /**
     * To determine if we should replace top or not. Changes to 'true' when enter is pressed and 'false' when numbers
     * is pressed.
     */
    private boolean isEnterPressed;
    /**
     * To determine if we should enter more digits and replace top. Changes to 'true' when operation is pressed and
     * 'false' when numbers is pressed.
     */
    private boolean isOperationPressed;

    @FXML
    private TextField stackAtFirstPlace;

    @FXML
    private TextField stackAtSecondPlace;

    @FXML
    private TextField stackAtThirdPlace;

    @FXML
    private TextField stackAtFourthPlace;

    /**
     * Handler for number buttons.
     *
     * @param event The event.
     */
    @FXML
    private void numberButtonHandler(ActionEvent event) {
        double input = Double.parseDouble(((Button) event.getSource()).getText());
        // If first value is 0 or we just have pressed enter and starts entering a new number, we want to replace the
        // first number of the stack.
        if (stackAtFirstPlace.getText().equals("0.0") || isEnterPressed) {
            updateBoard(hpCalculator.insertNumber(input, true));
        }
        // Check if operation has not been used. We do this after because if we do an operation and the hit enter we
        // we want to replace with the new number.
        else if (!isOperationPressed) {
            stackAtFirstPlace.setText(String.valueOf(Double.parseDouble(stackAtFirstPlace.getText()) * 10 + input));
            updateBoard(hpCalculator.insertNumber(Double.parseDouble(stackAtFirstPlace.getText()), true));
        }
        // Else we just push.
        else {
            updateBoard(hpCalculator.insertNumber(input, false));
        }
        isOperationPressed = false;
        isEnterPressed = false;
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
                    values = hpCalculator.insertNumber(Double.parseDouble(stackAtFirstPlace.getText()), false);
                    isEnterPressed = true;
                    break;
                case "+":
                    values = hpCalculator.processOperation(Operations.PLUS);
                    isOperationPressed = true;
                    break;
                case "-":
                    values = hpCalculator.processOperation(Operations.MINUS);
                    isOperationPressed = true;
                    break;
                case "*":
                    values = hpCalculator.processOperation(Operations.TIMES);
                    isOperationPressed = true;
                    break;
                case "/":
                    values = hpCalculator.processOperation(Operations.DIVIDES);
                    isOperationPressed = true;
                    break;
                case "CSTK":
                    values = hpCalculator.processOperation(Operations.CLEARSTACK);
                    isOperationPressed = true;
                    break;
                case "CHS":
                    values = hpCalculator.processOperation(Operations.CHS);
                    isOperationPressed = true;
                    break;
                case "CLX":
                    values = hpCalculator.processOperation(Operations.CLEAR);
                    break;
                default:
                    throw new IllegalArgumentException("Operation does not exist.");
            }
            updateBoard(values);
        } catch (EmptyStackException e) {
            new Alert(Alert.AlertType.ERROR, "Could not perform operation because the stack is empty.", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    /**
     * Update text fields that show the stack's contents.
     *
     * @param values The new values.
     */
    private void updateBoard(double[] values) {
        stackAtFirstPlace.setText(String.valueOf(values[0]));
        stackAtSecondPlace.setText(String.valueOf(values[1]));
        stackAtThirdPlace.setText(String.valueOf(values[2]));
        stackAtFourthPlace.setText(String.valueOf(values[3]));
    }
}
