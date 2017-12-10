package hpCalculator;

public class HPCalculator {

    private Stack calculatorStack;

    public HPCalculator() {
        calculatorStack = new Stack(4);
    }

    /**
     * Process for number input. Pushing the number input to the array and also poping a value if need.
     *
     * @param input      Input as a double.
     * @param replaceTop If the top should be replaced.
     * @return The array of number in double.
     */
    public double[] processNumber(double input, boolean replaceTop) {
        calculatorStack.push(input, replaceTop);
        return calculatorStack.getStackInOrder();
    }

    /**
     * Precess for operation input.
     *
     * @param operation The operation input.
     * @return Returns new array of values.
     */
    public double[] processOperation(Operations operation) {
        double y;
        switch (operation) {
            case PLUS:
                calculatorStack.push(calculatorStack.pop() + calculatorStack.pop());
                break;
            case MINUS:
                y = calculatorStack.pop();
                calculatorStack.push(calculatorStack.pop() - y);
                break;
            case TIMES:
                calculatorStack.push(calculatorStack.pop() * calculatorStack.pop());
                break;
            case DIVIDES:
                y = calculatorStack.pop();
                calculatorStack.push(calculatorStack.pop() / y);
                break;
            case CLEARSTACK:
                //calculatorStack.empty();
                break;
            case CHS:
                calculatorStack.push(-calculatorStack.pop());
                break;
            case CLEAR:
                calculatorStack.push(0.0, true);
                break;
            default:
                throw new Error("Unknown operation: " + operation);
        }
        return calculatorStack.getStackInOrder();
    }

}
