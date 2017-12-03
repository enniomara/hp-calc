package hpcalculator;

public class HPCalculator {

    private HPValues values;

    public HPCalculator(){
        values = new HPValues();
    }

    /**
     * Process for the input.
     * @param input The input as an string.
     * @return The new array.
     */
    public Double[] processInput(String input){
        Double value = tryParseDouble(input);
        if(value == null){
            processOperation(input);
            return values.getValues();
        }else {
            return values.push(value);
        }
    }

    /**
     * Trying to parse the string to a double, if not the we know it´s a operation or something els.
     * @param input The input we are trying to parse to double.
     * @return An double or null if it´s an operation or something els.
     */
    private Double tryParseDouble(String input){
        try {
            return Double.parseDouble(input);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Precess for operation input.
     * @param input The operation input.
     */
    private void processOperation(String input){
        switch (input){
            case "+":
                values.push(Operations.PLUS.calculate(values.pop(), values.pop()));
                break;
            case "-":
                values.push(Operations.MINUS.calculate(values.pop(), values.pop()));
                break;
            case "*":
                values.push(Operations.TIMES.calculate(values.pop(), values.pop()));
                break;
            case "/":
                values.push(Operations.DIVIDES.calculate(values.pop(), values.pop()));
                break;
            case "CSTK":
                values.empty();
                break;
            case "CHS":
                values.push(-values.pop());
                break;
            case "CLX":
                break;
            default:
                throw new Error("Finns ej");
        }
    }

}
