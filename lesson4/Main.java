package lesson4;

import java.util.*;

public class Main {

    public static LinkedList<String> inputLinkedList() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> myList = new LinkedList<>(Arrays.asList((in.nextLine()).split(" ")));
        return myList;
    }
    public static LinkedList<Integer> stringLinkedListToInteger(LinkedList<String> inputList) {
        ListIterator<String> listIterator = inputList.listIterator();
        LinkedList<Integer> myList = new LinkedList<>();
        while (listIterator.hasNext()) {
            myList.add(Integer.parseInt(listIterator.next()));
        }
        return myList;
    }
    public static Integer getSumOfLinkedList(LinkedList<Integer> inputList) {
        ListIterator<Integer> listIterator = inputList.listIterator();
        Integer sum = 0;
        while (listIterator.hasNext()) {
            sum += listIterator.next();
        }
        return sum;
    }
    public static LinkedList<String> reverseLinkedList(LinkedList<String> inputList) {
        LinkedList<String> outputList = new LinkedList<>();
        ListIterator<String> listIterator = inputList.listIterator(inputList.size() - 1);
        outputList.add(inputList.getLast());
        while (listIterator.hasPrevious()) {
            outputList.add(listIterator.previous());
        }
        return outputList;
    }
    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите элементы через пробел: ");
        LinkedList<String> myList = inputLinkedList();
        System.out.print("\n");

        System.out.print("Тот же список, но наоборот: ");
        for (String item: reverseLinkedList(myList)) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите элементы очереди через пробел: ");
        MyQueue myQueue = new MyQueue();
        myQueue.content = inputLinkedList();
        System.out.print("Получившаяся очередь: ");
        myQueue.printYourself();
        System.out.print("Введите новый элемент, который будет добавлен через enqueue(): ");
        String newItem = in.nextLine();
        myQueue.enqueue(newItem);
        System.out.print("Получившаяся очередь: ");
        myQueue.printYourself();
        System.out.print("Полученный элемент, через dequeue(): ");
        System.out.print(myQueue.dequeue());
        System.out.print("\n");
        System.out.print("Получившаяся очередь: ");
        myQueue.printYourself();
        System.out.print("Полученный элемент, через first(): ");
        System.out.print(myQueue.first());
        System.out.print("\n");
        System.out.print("Получившаяся очередь: ");
        myQueue.printYourself();
        System.out.print("\n");
    }

    public static void main(String[] args) {
        //task1();
        //task2();

        System.out.print("Введите числа через пробел: ");
        LinkedList<Integer> numbs = stringLinkedListToInteger(inputLinkedList());
        System.out.print("Их сумма: ");
        System.out.print(getSumOfLinkedList(numbs));
    }
}