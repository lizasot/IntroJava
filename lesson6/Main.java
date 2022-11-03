package lesson6;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer count = 12;
        for (int i = 0; i < count; i++) {
            new Laptop(new Random());
        }
        System.out.println("Все ноутбуки:");
        System.out.println(Laptop.outputTotalLaptop());
        System.out.println("Введите число соответствующего критерия:");
        System.out.println(Laptop.outputStats());
        Integer stat = Integer.valueOf(in.nextLine());
        System.out.println("Введите " + Laptop.getValidRange(stat) + ":");
        String range = in.nextLine();
        System.out.println("Подходящие ноутбуки:");
        System.out.println(Laptop.outputTotalLaptopByStat(stat, range));
    }
}