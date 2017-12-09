package hpCalculator;

public class HPCalculator {

    private HPValues calculatorStack;

    public HPCalculator(){
        calculatorStack = new HPValues();
    }

    /**
     * Process for number input. Pushing the number input to the array and also poping a value if need.
     * @param input Input as an double.
     * @param isPushed If it's pushed.
     * @return The array of number in double.
     */
    public double[] processNumber(double input, boolean isPushed){
        return processNumber(input, isPushed, false);
    }

    /**
     * Process for number input. Pushing the number input to the array and also poping a value if need.
     * @param input Input as a double.
     * @param isPushed If it's isPushed.
     * @param enter If we click the enter button.
     * @return The array of number in double.
     */
    public double[] processNumber(double input, boolean isPushed, boolean enter){
        if(isPushed && !enter){
            calculatorStack.pop();
        }
        return calculatorStack.push(input);
    }

    /**
     * Precess for operation input.
     * @param input The operation input.
     * @return Returns new array of values.
     */
    public double[] processOperation(String input){
        switch (input){
            case "+":
                return calculatorStack.push(Operations.PLUS.calculate(calculatorStack.pop(), calculatorStack.pop()));
            case "-":
                return calculatorStack.push(Operations.MINUS.calculate(calculatorStack.pop(), calculatorStack.pop()));
            case "*":
                return calculatorStack.push(Operations.TIMES.calculate(calculatorStack.pop(), calculatorStack.pop()));
            case "/":
                return calculatorStack.push(Operations.DIVIDES.calculate(calculatorStack.pop(), calculatorStack.pop()));
            case "CSTK":
                return calculatorStack.empty();
            case "CHS":
                return calculatorStack.push(-calculatorStack.pop());
            default:
                throw new Error("Operation does not exist.");
        }
    }

}
