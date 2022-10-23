package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите числа через пробел: ");
        String inputNumbs = in.nextLine();
        List<String> strNumbs = new ArrayList<>(Arrays.asList(inputNumbs.split(" ")));
        List<Integer> numbs = new ArrayList<>();
        for (String item : strNumbs) {
            numbs.add(Integer.parseInt(item));
        }

        System.out.print("Введённый список чисел: ");
        for (Integer item : numbs) {
            System.out.print(item + " ");
        }
        System.out.print("\n");

        System.out.print("Максимальный элемент: ");
        System.out.print(Collections.max(numbs));
        System.out.print("\n");

        System.out.print("Минимальный элемент: ");
        System.out.print(Collections.min(numbs));
        System.out.print("\n");

        System.out.print("Среднее арифметическое: ");
        Integer sum = 0;
        for (Integer item : numbs) {
            sum += item;
        }
        System.out.print((float) sum / (float) numbs.size());
        System.out.print("\n");

        System.out.print("Удаление чётных чисел: ");
        for (int i = 0; i < numbs.size(); i++) {
            if (numbs.get(i) % 2 == 0) {
                numbs.remove(i);
                i--;
            }
        }
        System.out.print("\n");

        for (Integer item : numbs) {
            System.out.print(item + " ");
        }
    }
}
