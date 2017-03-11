package main.java.howard.edu.ood.hw2.collections;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;


/**
 * @author Prashant Bhandri
 * This class is the test implementation for the ArrayQueue class implementation.
 */
public class ArrayQueueTest {

    /**
     * This test method fails if the exception is not thrown when the queue is empty
     * @throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmptyQueue() throws Exception {
        ArrayQueue testQueue = new ArrayQueue();
        testQueue.dequeue();
    }

    /**
     * This test method passes if the queue is empty.
     */
    @Test
    public void testIsEmptyWhenEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        assertEquals(true, testQueue1.isEmpty());
    }

    /**
     * This test method passes when the queue is not empty
     */
    @Test
    public void testIsEmptyWhenNotEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(1);
        assertEquals(false, testQueue1.isEmpty());
    }

    /**
     * This test method passes if a exception is thrown when reading data from empty arrayQueue
     * @exception NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public  void testPeekWhenQueueIsEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.peek();
    }

    /**
     * This test passes if the front of the queue is returned.
     * if the queue is [1,2,4,5,3] then the return value should be 1.
     */
    @Test
    public  void testPeekWhenNotEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(2);
        testQueue1.enqueue(3);
        assertEquals(2, testQueue1.peek());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "front [ ] back       (empty queue)"
     * which is in the case of an empty queue
     */
    @Test
    public void testToStringWhenQueueIsEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        String expectedString = "front [ ] back       (empty queue)";
        assertEquals(expectedString, testQueue1.toString());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "front [ 1 ] back       (queue with one element)"
     * which is in the case of queue with singular element.
     */
    @Test
    public void testToStringWhenOnlyOneElementInQueue() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(1);
        String expectedString = "front [ 1 ] back       (queue with one element)";
        assertEquals(expectedString, testQueue1.toString());
    }

    /**
     * This test method passes if the string of certain format is returned
     * the return string should be "front [ 3 4 5 6 7 8 ] back       (queue with 6 elements)"
     * which is in the case of queue with 6 elements.
     */
    @Test
    public void testToStringWhenMoreThanOneElementInQueue() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(1);
        testQueue1.enqueue(2);
        testQueue1.enqueue(3);
        testQueue1.enqueue(4);
        testQueue1.dequeue();
        testQueue1.enqueue(5);
        testQueue1.enqueue(6);
        testQueue1.enqueue(7);
        testQueue1.dequeue();
        testQueue1.enqueue(8);
        String expectedString = "front [ 3 4 5 6 7 8 ] back       (queue with 6 elements)";
        assertEquals(expectedString, testQueue1.toString());
    }

}