package main.java.howard.edu.ood.hw2.collections;

import driver.Driver;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class DriverTest {

    @Test
    public void testAreEqualWhenEqual() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        ArrayStack testStack2 = new ArrayStack();
        testStack2.push(1);
        testStack2.push(2);
        assertEquals(true, Driver.areEqual(testStack1, testStack2));
    }

    @Test
    public void testAreEqualWhenNotEqualWithArrayOfDifferentLength() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        ArrayStack testStack2 = new ArrayStack();
        testStack2.push(1);
        assertEquals(false, Driver.areEqual(testStack1, testStack2));
    }

    @Test
    public void testAreEqualWhenNotEqualWithArrayOfSameLength() {
        ArrayStack testStack1 = new ArrayStack();
        testStack1.push(1);
        testStack1.push(2);
        ArrayStack testStack2 = new ArrayStack();
        testStack2.push(1);
        testStack2.push(3);
        assertEquals(false, Driver.areEqual(testStack1, testStack2));
    }
}
