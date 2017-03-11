package main.java.howard.edu.ood.hw2.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class ArrayStackTest {

    /**
     * This test passes if the stack is empty.
     */
    @Test
    public void testIsEmptyWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        assertEquals(true, testStack1.isEmpty());
    }

    /**
     * This test passes when the stack is not empty with just one element.
     */
    @Test
    public void testIsEmptyWhenNotEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        assertEquals(false, testStack1.isEmpty());
    }

    /**
     * This test passes when an exception is thrown looking for elements in empty array
     * @exception NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testPeekWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.peek();
    }

    /**
     * This test passes if the only element in the array is returned.
     */
    @Test
    public void testPeekWithSingleElement() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        assertEquals(1, testStack1.peek());
    }

    /**
     * This test passes if among the elements in the array the top most is returned.
     */
    @Test
    public void testPeekWithMoreThanOneElements() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        testStack1.push(3);
        testStack1.push(4);
        assertEquals(4, testStack1.peek());
    }

    /**
     * This test passes with the throw of exception when trying to delete element from
     * an empty stack Array.
     * @exception NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testPopWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.pop();
    }

    /**
     * This test passes when the element at the top of the stack array is deleted and returned.
     */
    @Test
    public void testPopNotEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        testStack1.push(3);
        assertEquals(3, testStack1.pop());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "top [ ] buttom       (empty stack)"
     * which is in the case of an empty stack
     */
    @Test
    public void testToStringWhenStackIsEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        String expectedString = "top [ ] bottom       (empty stack)";
        assertEquals(expectedString, testStack1.toString());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "top [ 1 ] buttom       (stack with one element)"
     * which is in the case of stack with singular element.
     */
    @Test
    public void testToStringOnlyOneElement() {
        ArrayStack testStack = new ArrayStack();
        testStack.push(1);
        String expectedString = "top [ 1 ] bottom       (stack with one element)";
        assertEquals(expectedString, testStack.toString());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "top [ 5 4 3 2 1 ] buttom       (stack with 6 elements)"
     * which is in the case of stack with 5 elements.
     */
    @Test
    public void testToStringWithMoreThanOneElement() {
        ArrayStack testStack = new ArrayStack();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);
        String expectedString = "top [ 5 4 3 2 1 ] bottom       (stack with 5 elements)";
        assertEquals(expectedString, testStack.toString());
    }

    /**
     * This test method passes if the correct number of elements in the stack array is returned.
     */
    @Test
    public void testGetCurrentSize() {
        ArrayStack testStack = new ArrayStack();
        assertEquals(0, testStack.getCurrentSize());
        testStack.push(2);
        testStack.push(3);
        assertEquals(2, testStack.getCurrentSize());
    }
}