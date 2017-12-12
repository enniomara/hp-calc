package hpCalculator;

public class HPCalculator {

    private Stack calculatorStack;

    public HPCalculator() {
        calculatorStack = new Stack(4);
    }

    /**
     * Process for number number. Pushing the number number to the array and also poping a value if need.
     *
     * @param number     Number as a double.
     * @param replaceTop Whether the top element of the stack should be replaced by the number passed in.
     * @return The stack's content in array form.
     */
    public double[] insertNumber(double number, boolean replaceTop) {
        calculatorStack.push(number, replaceTop);
        return calculatorStack.getStackInOrder();
    }

    /**
     * Precess for operation input.
     *
     * @param operation The stack's content in array form.
     * @return Returns new array of values.
     */
    public double[] processOperation(Operations operation) {
        double temporaryNumber;
        switch (operation) {
            case PLUS:
                calculatorStack.push(calculatorStack.pop() + calculatorStack.pop());
                break;
            case MINUS:
                temporaryNumber = calculatorStack.pop();
                calculatorStack.push(calculatorStack.pop() - temporaryNumber);
                break;
            case TIMES:
                calculatorStack.push(calculatorStack.pop() * calculatorStack.pop());
                break;
            case DIVIDES:
                temporaryNumber = calculatorStack.pop();
                if (temporaryNumber == 0) throw new IllegalArgumentException("Can't divide by 0");
                calculatorStack.push(calculatorStack.pop() / temporaryNumber);
                break;
            case CLEARSTACK:
                calculatorStack.empty();
                break;
            case CHS:
                calculatorStack.push(-calculatorStack.pop());
                break;
            case CLEAR:
                calculatorStack.push(0.0, true);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return calculatorStack.getStackInOrder();
    }

}
