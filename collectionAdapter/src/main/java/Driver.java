package main.java;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class Driver {
    public static void main(String[] args) {
        IntegerStack stack1 = new IntegerStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.println(stack1.toString());
        System.out.println("***********************");
        System.out.println("This is Queue");
        IntegerQueue queue1 = new IntegerQueue();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.dequeue();
        System.out.println(queue1.toString());
    }
}
