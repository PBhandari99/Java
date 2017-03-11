package main.java.howard.edu.ood.hw2.collections;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;


/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class ArrayQueueTest {

    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmptyQueue() throws Exception {
        ArrayQueue testQueue = new ArrayQueue();
        testQueue.dequeue();
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        assertEquals(true, testQueue1.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(1);
        assertEquals(false, testQueue1.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public  void testPeekWhenQueueIsEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.peek();
    }

    @Test
    public  void testPeekWhenNotEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(2);
        testQueue1.enqueue(3);
        assertEquals(2, testQueue1.peek());
    }

    @Test
    public void testToStringWhenQueueIsEmpty() {
        ArrayQueue testQueue1 = new ArrayQueue();
        String expectedString = "front [ ] back       (empty queue)";
        assertEquals(expectedString, testQueue1.toString());
    }

    @Test
    public void testToStringWhenOnlyOneElementInQueue() {
        ArrayQueue testQueue1 = new ArrayQueue();
        testQueue1.enqueue(1);
        String expectedString = "front [ 1 ] back       (queue with one element)";
        assertEquals(expectedString, testQueue1.toString());
    }

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