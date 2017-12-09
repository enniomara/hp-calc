package hpCalculator;

public class Stack {
    private double[] numberStack;
    /**
     * Pointer that points to the element that is considered the top of the stack.
     */
    private int topOfStack = -1;

    public Stack(int size) {
        numberStack = new double[size];
    }

    /**
     * Push an element to the top of the stack.
     *
     * @param element The element to be pushed.
     */
    public void push(double element) {
        increaseTopOfStack();
        numberStack[topOfStack] = element;
    }

    /**
     * Push with the ability to replace the top of the stack with the inputted element.
     *
     * @param element The element that will be pushed/replace top of the stack.
     */
    public void push(double element, boolean replaceTop) {
        // If it should not be replaced, do an ordinary push
        if (!replaceTop) {
            push(element);
            return;
        }

        // On an uninitialized stack the topOfStack is set to -1, since the stack is empty.
        if (topOfStack >= 0) {
            numberStack[topOfStack] = element;
        } else {
            // Do an ordinary push. The stack is empty.
            push(element);
        }
    }

    /**
     * Look at the first element in the stack without removing it.
     *
     * @return The object at the top of the stack.
     */
    public double peek() {
        if (topOfStack < 0) {
            throw new NullPointerException();
        }
        return numberStack[topOfStack];
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function. The removed
     * item is replaced with the value of the item at the bottom of the stack.
     *
     * @return The object at the top of this stack.
     */
    public double pop() {
        double numberToReturn = peek();
        /* Here we set the bottom of the stack to the item before. Due to the way the stack is implemented, the bottom
            of it is always one step to the right of topOfStack. The modulo operation is to take care of the case when
            we exceed the array when doing topOfStack + 1. */
        numberStack[topOfStack] = numberStack[Math.floorMod(topOfStack + 1, numberStack.length)];

        decreaseTopOfStack();
        return numberToReturn;
    }

    /**
     * Increase the value of topOfStack with one.
     */
    private void increaseTopOfStack() {
        // Since the topOfStack is dynamic, we need to make addition to it circular.
        topOfStack = Math.floorMod(topOfStack + 1, numberStack.length);
    }

    /**
     * Decrease the value of topOfStack with one.
     */
    private void decreaseTopOfStack() {
        // Since the topOfStack is dynamic, we need to make subtraction to it circular.
        topOfStack = Math.floorMod(topOfStack - 1, numberStack.length);
    }

    /**
     * @return The stack in string format ([1, 3, 4]. The top of the stack is at place 0, and the rest of the elements come after.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        double[] orderedStack = getStackInOrder();

        output.append("[");
        for (double i : orderedStack) {
            output.append(i).append(",");
        }
        output.deleteCharAt(output.length() - 1);   // Remove the last comma (,) from the string as we have no more elements.
        output.append("]");

        return output.toString();
    }

    /**
     * Retrieve the stack array in order. The top of the stack will be at element 0 in the array.
     *
     * @return The formatted stack.
     */
    public double[] getStackInOrder() {
        double[] formattedList = new double[numberStack.length];
        int oldArrayPointer = topOfStack;

        for (int i = 0; i < formattedList.length; i++) {
            formattedList[i] = numberStack[oldArrayPointer];
            /* The first element that was inserted in the stack is at place 0. So to print the stack in order, we have
                to start at topOfStack, and then go backwards. */
            oldArrayPointer = Math.floorMod(oldArrayPointer - 1, numberStack.length);
        }

        return formattedList;
    }
}
