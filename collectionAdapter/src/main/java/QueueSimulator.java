package main.java;

import java.util.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */

public class QueueSimulator {
    public static void main(String args[]) {
        IntegerQueue iQ = new IntegerQueue();

        IntegerStack iS = new IntegerStack();
        QueueOperations stackAdapter = new StackAdapter(iS);

        List<QueueOperations> queueList = new ArrayList<>();
        queueList.add(iQ);
        queueList.add(stackAdapter);

        for (QueueOperations q : queueList) {
            q.enqueue(10);
            q.enqueue(20);
            q.dequeue();
            System.out.println(q.toString());
        }
    }
}

