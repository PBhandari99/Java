package main;

import howard.edu.ood.hw2.collections.ArrayStack;
import howard.edu.ood.hw2.collections.ArrayQueue;

/**
 * Created by Prashant Bhandari on 2/22/17.
 */

public class Driver {

    /**
     * checks to see if the two stack passed
     * as parameter are equal.
     * @param stack1 @required
     * @param stack2 @required
     * @return boolean
     *
     */
    public static boolean areEqual(ArrayStack stack1, ArrayStack stack2) {
        if (stack1.getCurrentSize() != stack2.getCurrentSize()) {
            return false;
        }
        for (int i=0; i<stack1.getCurrentSize(); i++) {
            if (stack1.getStack()[i] != stack2.getStack()[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * return a duplicate ArrayStack type
     * of the instance passed in the parameter.
     * @param stack @required
     * @return ArrayStack object
     */
    public static ArrayStack duplicateStack(ArrayStack stack) {
        ArrayStack dupStack = new ArrayStack();
        int sizeOfStack = stack.getCurrentSize();
        int[] stackData = new int[sizeOfStack];
        for (int i=0; i<sizeOfStack; i++) {
            stackData[i] = stack.pop();
        }
        for(int i=0; i<sizeOfStack; i++) {
            dupStack.push(stackData[sizeOfStack-1-i]);
        }
        return dupStack;
    }


    public static void main(String[] args) {
    }
}