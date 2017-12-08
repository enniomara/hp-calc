package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    private Stack calculatorStack;
    private boolean enterPressed = false;

    public Controller() {
        calculatorStack = new Stack(4);
    }

    public void number(ActionEvent event) {
        Button button = (Button) event.getSource();

        /* If enter is pressed, the top element is duplicated. WHen pressing
            number, we should replace the number, not append to it. */
        String topOfStackElement = "";
        if (!enterPressed) {
            try {
                topOfStackElement = Integer.toString(calculatorStack.peek());
                enterPressed = false;
            } catch (NullPointerException e) {
                topOfStackElement = "";
            }
        }
        calculatorStack.push(Integer.parseInt(topOfStackElement + button.getText()), true);

        //System.out.println(button.getText());
    }

    public void action(ActionEvent event) {
        switch (((Button) event.getSource()).getText()) {
            case "+":

                execute(Operations.PLUS);
                break;
            case "-":
                execute(Operations.MINUS);
                break;
            case "*":
                execute(Operations.TIMES);
                break;
            case "/":
                execute(Operations.DIVIDES);
                break;
        }
    }

    public void enter(ActionEvent event) {
        // Duplicate the first number according to spec
        calculatorStack.push(calculatorStack.peek());
        enterPressed = true;
        printStack();
    }

    public double execute(Operations action) {
        if (action == Operations.PLUS) {
            int result = calculatorStack.pop() + calculatorStack.pop();
            calculatorStack.push(result);
        } else if (action == Operations.MINUS) {
            int firstElement = calculatorStack.pop();
            int secondElement = calculatorStack.pop();
            int result = secondElement - firstElement;
            calculatorStack.push(result);
        } else if (action == Operations.TIMES) {
            int result = calculatorStack.pop() * calculatorStack.pop();
            calculatorStack.push(result);
        } else if (action == Operations.DIVIDES) {
            int firstElement = calculatorStack.pop();
            int secondElement = calculatorStack.pop();
            int result = secondElement / firstElement;
            calculatorStack.push(result);
        }
        printStack();
        return 0;
    }

    public void printStack() {
        System.out.println(calculatorStack.toString());
    }
}
