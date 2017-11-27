package sample;

public class HPCalculator {

    private HPValues values;

    public HPCalculator(){
        values = new HPValues();
    }

    public Double[] processInput(String input){
        Double value = tryParseDouble(input);
        if(value == null){
            processOperation(input);
            return values.getValues();
        }else {
            return values.push(value);
        }
    }

    private Double tryParseDouble(String input){
        try {
            return Double.parseDouble(input);
        } catch (Exception e){
            return null;
        }
    }

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
            default:
                throw new Error("Finns ej");
        }
    }

}
