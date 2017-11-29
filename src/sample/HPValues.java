package sample;

import java.util.Arrays;

public class  HPValues{

    private Double[] values;

    public HPValues(){
        values = new Double[]{0.0, 0.0, 0.0, 0.0};
    }

    public Double[] getValues() {
        return values;
    }

    public Double[] push(Double value){
        if(values[0] == 0) {
            values[0] = value;
        }else {
            moveRight();
            values[0] = value;
        }
        return getValues();
    }

    private void moveRight(){
        for (int i = 3; i > 0; i--){
            values[i] = values[i-1];
        }
    }

    private void moveLeft(){
        for(int i = 0; i < 3; i++){
            values[i] = values[i+1];
        }
    }

    public Double pop(){
        Double returnTemp = peek();
        moveLeft();
        return returnTemp;
    }

    public Double peek(){
        return values[0];
    }

    public Double[] empty(){
        values = new Double[]{0.0, 0.0, 0.0, 0.0};
        return values;
    }
}

/*public class HPValues extends Vector<Double>{

    public Double push(Double value){
        if(size() >= 4){
            removeElementAt(0);
        }
        addElement(value);
        return value;
    }

    public Double pop(){
        Double returnValue = peek();
        int length = size();
        if(length < 4) {
            removeElementAt(length - 1);
        }else {

        }
        return returnValue;
    }

    public Double peek(){
        int length = size();
        return elementAt(length-1);
    }

    private void reOrder(){

    }
}*/
