package sample;

public enum Operations {
    PLUS, MINUS, TIMES, DIVIDES, CLEAR, CHS, CLEARSTACK;
    double calculate(double x, double y){
        switch (this) {
            case PLUS:
                return y + x;
            case MINUS:
                return y - x;
            case TIMES:
                return y * x;
            case DIVIDES:
                return y / x;
            default:
                throw new AssertionError("Unknown operation: " + this);
        }
    }
}
