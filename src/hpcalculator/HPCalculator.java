package hpcalculator;

public class HPCalculator {

    private HPValues values;
    private int times;

    public HPCalculator(){
        values = new HPValues();
    }

    //ToDo: Change processInput to processNumber and make it so all numbers gets sent here and all operations to operation from outside.
    public double[] processNumber(double input, boolean enter){
        if((times > 0 && !(values.peek() == input))) values.pop();
        if(enter) values.push(input);
        times++;
        return values.push(input);
    }

    /**
     * Precess for operation input.
     * @param input The operation input.
     */
    public double[] processOperation(String input){
        times = 0;
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
