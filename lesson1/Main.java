package lesson1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void printWelcome(int hour, String name) {
        if (hour >= 5 && hour <= 11) {
            System.out.format("Доброе утро, %s!\n", name);
        } else if (hour >= 12 && hour <= 17) {
            System.out.format("Добрый день, %s!\n", name);
        } else if (hour >= 18 && hour <= 22) {
            System.out.format("Добрый вечер, %s!\n", name);
        } else if (hour == 23 || (hour >= 0 && hour <= 4)) {
            System.out.format("Доброй ночи, %s!\n", name);
        }
    }

    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String username = in.nextLine();
        printWelcome((new GregorianCalendar()).get(Calendar.HOUR_OF_DAY), username);
    }

    public static int getMaxCountRepeat(boolean[] arrayUnits, boolean unit){
        int maxCountRepeat = 0;
        int countRepeat = 0;
        for (int i = 0; i < arrayUnits.length; i++) {
            if (arrayUnits[i] == unit) {
                countRepeat++;
            } else {
                if (countRepeat > maxCountRepeat) {
                    maxCountRepeat = countRepeat;
                }
                countRepeat = 0;
            }
        }
        if (maxCountRepeat == 0) {
            maxCountRepeat = countRepeat;
        }
        return maxCountRepeat;
    }

    public static void fillArrayBoolByStr(boolean[] arrayItems, String[] items) throws Exception {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals("0")) {
                arrayItems[i] = false;
            } else if (items[i].equals("1")) {
                arrayItems[i] = true;
            }
            else {
                throw new Exception("Неправильный ввод массива!");
            }
        }
    }

    public static void task2() {
        Scanner in = new Scanner(System.in);
        boolean doInput = true;
        String[] items;
        boolean[] arrayItems = new boolean[0];

        while (doInput) {
            doInput = false;
            System.out.print("Введите 0 и 1 через пробел: ");
            items = (in.nextLine()).split(" ");
            arrayItems = new boolean[items.length];
            try {
                fillArrayBoolByStr(arrayItems, items);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                doInput = true;
            }
        }

        int maxCountRepeat = getMaxCountRepeat(arrayItems, true);
        System.out.print("Максимальное количество подряд идущих 1: ");
        System.out.println(maxCountRepeat);
    }

    public static void fillArrayIntByStr(int[] arrayItems, String[] items) throws Exception {
        for (int i = 0; i < items.length; i++) {
            try {
                arrayItems[i] = Integer.parseInt(items[i]);
            }
            catch (NumberFormatException e) {
                throw new Exception("Неправильный ввод массива!");
            }
        }
    }

    public static void valueToTheEnd(int[] arrayItems, int val) {
        int begin = 0;
        int end = arrayItems.length - 1;
        while (end != 0 && arrayItems[end] == val) {
            end--;
        }
        while (begin < end) {
            if (arrayItems[begin] == val) {
                arrayItems[begin] = arrayItems[end];
                arrayItems[end] = val;
                end--;
            }
            begin++;
        }
    }

    public static void task3() {
        Scanner in = new Scanner(System.in);
        boolean doInput = true;
        String[] items;
        int[] arrayItems = new int[0];

        while (doInput) {
            doInput = false;
            System.out.print("Введите числа через пробел: ");
            items = (in.nextLine()).split(" ");
            arrayItems = new int[items.length];
            try {
                fillArrayIntByStr(arrayItems, items);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                doInput = true;
            }
        }

        doInput = true;
        int val = 0;
        while (doInput) {
            doInput = false;
            System.out.print("Введите число, которое необходимо поместить в конец: ");
            try {
                val = Integer.parseInt(in.nextLine());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                doInput = true;
            }
        }
        valueToTheEnd(arrayItems, val);
        for (int i = 0; i < arrayItems.length; i++) {
            System.out.print(arrayItems[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public static void task4() {
        Scanner in = new Scanner(System.in);
        boolean doInput = true;
        int val = 0;
        while (doInput) {
            doInput = false;
            System.out.print("Введите n: ");
            try {
                val = Integer.parseInt(in.nextLine());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                doInput = true;
            }
        }
        System.out.print("Треугольное число: ");
        System.out.println(val * (val + 1) / 2);
    }

    public static void main(String[] args) {
        task2();
    }
}