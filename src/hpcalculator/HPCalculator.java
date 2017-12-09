package hpcalculator;

public class HPCalculator {

    private HPValues values;
    private boolean hasPressedOperation;

    public HPCalculator(){
        values = new HPValues();
    }

    /**
     * Process for number input.
     * @param input Input as an double.
     * @param isPushed If it's pushed.
     * @return The array of number in double.
     */
    public double[] processNumber(double input, boolean isPushed){
        return processNumber(input, isPushed, false);
    }

    /**
     * Process for number input.
     * @param input Input as a double.
     * @param isPushed If it's isPushed.
     * @param enter If we click the enter button.
     * @return The array of number in double.
     */
    public double[] processNumber(double input, boolean isPushed, boolean enter){
        if(isPushed && !enter){
            values.pop();
        }
        return values.push(input);
    }

    /**
     * Precess for operation input.
     * @param input The operation input.
     */
    public double[] processOperation(String input){
        hasPressedOperation = true;
        switch (input){
            case "+":
                return values.push(Operations.PLUS.calculate(values.pop(), values.pop()));
            case "-":
                return values.push(Operations.MINUS.calculate(values.pop(), values.pop()));
            case "*":
                return values.push(Operations.TIMES.calculate(values.pop(), values.pop()));
            case "/":
                return values.push(Operations.DIVIDES.calculate(values.pop(), values.pop()));
            case "CSTK":
                return values.empty();
            case "CHS":
                return values.push(-values.pop());
            default:
                throw new Error("Operation not existing");
        }
    }

}
