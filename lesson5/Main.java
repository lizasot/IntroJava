package lesson5;

import java.util.*;

public class Main {

    public static void task1() {
        Map<String, String> phoneDirectory = new HashMap<>();
        phoneDirectory.put("88005553535","Кристина");
        phoneDirectory.put("88005553532","Кристина");
        phoneDirectory.put("88005243212","Марина");
        System.out.println(phoneDirectory);
    }

    public static HashMap<String, Integer> countRepeat(LinkedList<String> myList) {
        HashMap<String, Integer> result = new HashMap<>();
        String name;
        for (String item:myList) {
            name = Arrays.asList(item.split(" ")).get(0);
            if (result.get(name) != null) {
                result.put(name, result.get(name) + 1);
            } else {
                result.put(name, 1);
            }
        }
        return result;
    }

    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите список сотрудников через запятую: ");
        LinkedList<String> myList = new LinkedList<>(Arrays.asList((in.nextLine()).split(", ")));
        HashMap<String, Integer> countRepeatList = countRepeat(myList);
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String key : countRepeatList.keySet()) {
            map.put(key, countRepeatList.get(key));
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        task2();
    }
}