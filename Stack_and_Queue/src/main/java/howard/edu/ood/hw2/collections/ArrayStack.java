package main.java.howard.edu.ood.hw2.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *The class is a implementation of stack data structure in Array.
 *
 * @author  Prashant Bhandari
 */
public class ArrayStack implements StackOperations {

    private int[] stack;
    private int currentSize;
    private int stackAllocatedSize = 5;

    public ArrayStack() {
        stack = new int[stackAllocatedSize];
        currentSize = 0;
    }

    /**
     * This method return the current size of the stack array
     * @return int, size of array
     */
    public int getCurrentSize(){
        return currentSize;
    }

    /**
     * This method return the stack array.
     * @return int[]
     */
    public int[] getStack() {
        return stack;
    }
    /**
     * This method creats a new array double the size of the stack array.
     *@return int[]
     */
    private int[] reSizeArray() {
        this.stackAllocatedSize *= 2;
        return Arrays.copyOfRange(stack, 0, this.stackAllocatedSize);
    }

    /**
     * This method pushes the given parameter integer in the
     * stack array from the top. If the stack array is full,
     * a new array of double the size is declared and everything from the
     * old array is copied and the operation will continue
     * on the new one.
     *@param item
     *@return nothing.
     *
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
     * This method removes an integer value from the
     * the top of the stack array.
     * @exception NoSuchElementException when array is empty
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
     * This method returns but doesn't remove an integer value from the
     * the top of the stack array.
     *
     * @exception NoSuchElementException when array is empty
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
     * This method checks to if the stack is empty.
     * @return true if the stack array is empty.
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * This method creates a string from the stack.
     * @return string
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