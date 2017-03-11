package main.java.howard.edu.ood.hw2.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class ArrayStackTest {

    @Test
    public void testIsEmptyWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        assertEquals(true, testStack1.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        assertEquals(false, testStack1.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.peek();
    }

    @Test
    public void testPeekWithSingleElement() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        assertEquals(1, testStack1.peek());
    }

    @Test
    public void testPeekWithMoreThanOneElements() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        testStack1.push(3);
        testStack1.push(4);
        assertEquals(4, testStack1.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopWhenEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.pop();
    }

    @Test
    public void testPopNotEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        testStack1.push(3);
        assertEquals(3, testStack1.pop());
    }

    @Test
    public void testToStringWhenStackIsEmpty() {
        ArrayStack testStack1 = new ArrayStack();
        String expectedString = "top [ ] bottom       (empty stack)";
        assertEquals(expectedString, testStack1.toString());
    }

    @Test
    public void testToStringOnlyOneElement() {
        ArrayStack testStack = new ArrayStack();
        testStack.push(1);
        String expectedString = "top [ 1 ] bottom       (stack with one element)";
        assertEquals(expectedString, testStack.toString());
    }

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

    @Test
    public void testGetCurrentSize() {
        ArrayStack testStack = new ArrayStack();
        assertEquals(0, testStack.getCurrentSize());
        testStack.push(2);
        testStack.push(3);
        assertEquals(2, testStack.getCurrentSize());
    }
}