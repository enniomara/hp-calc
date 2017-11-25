package sample;

public class Stack {
    private int[] numberStack;
    /**
     * Pointer that points to the element that is considered the top of the stack.
     */
    private int topOfStack = -1;

    public Stack(int size) {
        numberStack = new int[size];
    }

    /**
     * Push an element to the top of the stack.
     *
     * @param element The element to be pushed.
     */
    public void push(int element) {
        topOfStack++;
        numberStack[topOfStack] = element;
    }

    /**
     * Push with the ability to replace the top of the stack with the inputted element.
     *
     * @param element The element that will be pushed/replace top of the stack.
     */
    public void push(int element, boolean replaceTop) {
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
    public int peek() {
        if (topOfStack < 0) {
            throw new NullPointerException();
        }
        return numberStack[topOfStack];
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function. The removed
     * item is replaced with 0.
     *
     * @return The object at the top of this stack.
     */
    public int pop() {
        return pop(0);
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function. The removed
     * item is replaced with entered parameter.
     *
     * @param itemToReplaceWith The item to replace the removed item.
     * @return The object at the top of the stack.
     */
    public int pop(int itemToReplaceWith) {
        int numberToReturn = numberStack[topOfStack];
        numberStack[topOfStack] = itemToReplaceWith;
        topOfStack--;
        return numberToReturn;
    }

    /**
     * @return The stack in string format.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i : numberStack) {
            output.append("\n").append(i).append(",");
        }
        output.append(" ");

        return output.toString();
    }
}
