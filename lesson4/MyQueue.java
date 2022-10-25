package lesson4;

import java.util.LinkedList;

public class MyQueue {
    public LinkedList<String> content;

    public void enqueue(String item) {
        content.add(item);
    }

    public String dequeue() {
        return content.poll();
    }

    public String first() {
        return content.getFirst();
    }

    public void printYourself() {
        for (String item : content) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.print("\n");
    }
}
