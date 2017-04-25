package main.java;
import java.util.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class IntegerStack implements StackOperations{

    private ArrayList<Integer> stackList;

    public IntegerStack() {
        stackList = new ArrayList<>();
    }

    // Push an item onto the stack
    public void push(int item) {
        stackList.add(item);
        System.out.println("pushed "+ item);
    }

    // Pop an item off the stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int popItem = stackList.get(stackList.size()-1);
        stackList.remove(stackList.size()-1);
        return popItem;
    }

    // Return the top item from the stack
    public int peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return stackList.get(stackList.size()-1);
    }

    // Return true if empty, otherwise false
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "top [ ] bottom       (empty stack)";
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i=stackList.size()-1; i>=0; i--) {
                sb.append(" ");
                sb.append(stackList.get(i));
            }
            sb.append(" ");
            if (stackList.size() == 1){
                return "top [" + sb.toString() + "] bottom       (stack with one element)";
            }
            return "top [" + sb.toString() + "] bottom       (stack with " + String.valueOf(stackList.size()) + " elements)";
        }
    }
}


