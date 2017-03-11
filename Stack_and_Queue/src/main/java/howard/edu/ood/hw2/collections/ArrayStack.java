package main.java.howard.edu.ood.hw2.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Prashant Bhandari on 2/22/17.
 * The class is a implementation of stack data structure in Array
 */
public class ArrayStack implements StackOperations {

    private int[] stack;
    private int currentSize;
    private int stackAllocatedSize = 5;

    public ArrayStack() {
        stack = new int[stackAllocatedSize];
        currentSize = 0;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public int[] getStack() {
        return stack;
    }
    /**
     * returns a new array double the size of the stack array.
     *
     */
    private int[] reSizeArray() {
        this.stackAllocatedSize *= 2;
        return Arrays.copyOfRange(stack, 0, this.stackAllocatedSize);
    }

    /**
     * returns void and take an integer parameter.
     * It pushes the given parameter integer in the
     * stack array from the top.
     * If the stack array is full,
     * a new array of double the size is
     * Declared and everything from the
     * old array is copied and the operation will continue
     * on the new one.
     */
    @Override
    public void push(int item) {
        if (this.stackAllocatedSize == this.currentSize+1) {
            this.stack = reSizeArray();
            this.stack[currentSize] = item;
            this.currentSize++;
        }
        else {
            this.stack[currentSize] = item;
            this.currentSize++;
        }
    }

    /**
     * returns and removes an integer value from the
     * the top of the stack array and if
     * the array is empty NoSuchElementException()
     * is thrown.
     */
    @Override
    public int pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else {
            currentSize--;
            return stack[currentSize];
        }
    }

    /**
     * returns but doesn't remove an integer value from the
     * the top of the stack array and if
     * the array is empty NoSuchElementException()
     * is thrown.
     */
    @Override
    public int peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else {
            return stack[currentSize - 1];
        }
    }

    /**
     * return true if the stack array is empty.
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * return string of certain format based on the
     * the data in the stack array.
     *
     * sample return string:
     * top [ ] bottom       (empty stack)
     * top [ 1 ] bottom     (stack with one element)
     * top [ 5 2 8 ] bottom (stack with 3 elements)
     */
    public String toString() {
        if(isEmpty()){
            return "top [ ] bottom       (empty stack)";
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i=currentSize-1; i>=0; i--) {
                sb.append(" ");
                sb.append(stack[i]);
            }
            sb.append(" ");
            if (currentSize == 1){
                return "top [" + sb.toString() + "] bottom       (stack with one element)";
            }
            return "top [" + sb.toString() + "] bottom       (stack with " + String.valueOf(currentSize) + " elements)";
        }
    }

}