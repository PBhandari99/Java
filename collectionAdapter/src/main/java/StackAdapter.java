package main.java;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class StackAdapter implements QueueOperations {

    private IntegerStack stack;

    public StackAdapter(IntegerStack stack) {
        this.stack = stack;
    }
    public void enqueue(int i) {
        stack.push(i);
    }
    public int dequeue() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        ArrayList<Integer> tempArray = new ArrayList<>();
        while (!stack.isEmpty()) {
            tempArray.add(stack.pop());
        }
        int removed = tempArray.get(tempArray.size()-1);
        tempArray.remove(tempArray.size()-1);
        for (int i=tempArray.size()-1; i>=0; i--) {
            stack.push(tempArray.get(i));
        }
        return removed;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        ArrayList<Integer> tempArray = new ArrayList<>();
        while (!stack.isEmpty()) {
            tempArray.add(stack.pop());
        }
        return tempArray.get(tempArray.size()-1);
    }

    public String toString() {
        String prefix = "front [";
        String postfix = "] back";
        String in_string = "";

        ArrayList<Integer> tempArray = new ArrayList<>();
        while (!stack.isEmpty()) {
            tempArray.add(stack.pop());
        }

        while (!stack.isEmpty()){
            tempArray.add(stack.pop());
        }

        int i = tempArray.size() - 1;
        while (tempArray.size() != 0){
            int var = tempArray.remove(i);
            String num_to_str = Integer.toString(var);
            in_string = in_string + " " + num_to_str;
            stack.push(var);
            i--;
        }
        in_string = prefix + in_string + postfix;
        return in_string;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
