package hpcalculator;

public class  HPValues{

    private double[] values;

    public HPValues(){
        values = new double[]{0.0, 0.0, 0.0, 0.0};
    }

    public double[] getValues() {
        return values;
    }

    /**
     * Adding new values to values.
     * @param value The value to be added.
     * @return All the new values
     */
    public double[] push(double value){
        if(values[0] == 0) {
            values[0] = value;
        }else {
            moveRight();
            values[0] = value;
        }
        return getValues();
    }

    /**
     * Moving all the values to the right in the array.
     */
    private void moveRight(){
        for (int i = 3; i > 0; i--){
            values[i] = values[i-1];
        }
    }

    /**
     * Moving all the values to the left in the array.
     */
    private void moveLeft(){
        for(int i = 0; i < 3; i++){
            values[i] = values[i+1];
        }
    }

    /**
     * Getting the first value and removing the first from the array.
     * @return The first value.
     */
    public double pop(){
        double returnTemp = peek();
        moveLeft();
        return returnTemp;
    }

    /**
     * Looking at the first value.
     * @return The first value.
     */
    public double peek(){
        return values[0];
    }

    /**
     * Resetting the array.
     * @return The new values.
     */
    public double[] empty(){
        values = new double[]{0.0, 0.0, 0.0, 0.0};
        return values;
    }
}
