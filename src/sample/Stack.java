package sample;

public class Stack {
    private int[] numberStack;
    private int topOfStack;

    public Stack(int size) {
        numberStack = new int[size];
    }

    /**
     * Push an element to the top of the stack.
     * @param element The element to be pushed.
     */
    public void push(int element) {

    }

    /**
     * Look at the first element in the stack without removing it.
     * @return The object at the top of the stack.
     */
    public int peek() {
        return 0;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return The object at the top of this stack.
     */
    public int pop() {
        return 0;
    }

    /**
     * @return The stack in string format.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
