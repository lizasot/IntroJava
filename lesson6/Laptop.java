package lesson6;

import java.util.*;

public class Laptop {
    private static HashMap<Integer, Laptop> TotalLaptop = new HashMap<>();
    private static HashMap<Integer, String> Criteria = new HashMap<>(){{
        put(1,"Имя");
        put(2,"В наличии");
        put(3,"Цена");
        put(4,"ОЗУ");
        put(5,"Диагональ экрана");
        put(6,"Объём памяти");
        put(7,"Операционная система");
    }};
    private String Name;
    private boolean IsAvailable;
    private Float Price;
    private Integer Ram;
    private Float ScreenDiagonal;
    private Integer Ssd;
    private OperationalSystem System;

    public static String outputTotalLaptopByStat(Integer stat, String range)
    {
        StringBuilder result = new StringBuilder(150 * Laptop.TotalLaptop.size());
        Boolean isGood = false;
        for (Laptop item : Laptop.TotalLaptop.values()) {
            isGood = false;
            if (stat == 0) {
                isGood = true;
            } else if (stat == 1 && range.equals(item.Name)) {
                isGood = true;
            } else if (stat == 2 && range.equals(String.valueOf(item.IsAvailable))) {
                isGood = true;
            } else if (stat == 3 && Float.valueOf(range) >= item.Price) {
                isGood = true;
            } else if (stat == 4 && Integer.valueOf(range) <= item.Ram) {
                isGood = true;
            } else if (stat == 5 && Float.valueOf(range) <= item.ScreenDiagonal) {
                isGood = true;
            } else if (stat == 6 && Integer.valueOf(range) <= item.Ssd) {
                isGood = true;
            } else if (stat == 7 && OperationalSystem.valueOf(range) == item.System) {
                isGood = true;
            }

            if (isGood) {
                result.append("[");
                result.append(item.outputStat());
                result.append("]\n");
            }
        }
        return result.toString();
    }

    public static String outputTotalLaptop()
    {
        return outputTotalLaptopByStat(0, "");
    }
    public static String outputStats()
    {
        StringBuilder result = new StringBuilder(200);
        for (Integer key : Laptop.Criteria.keySet()) {
            result.append(key);
            result.append(": ");
            result.append(Laptop.Criteria.get(key));
            result.append("\n");
        }
        return result.toString();
    }
    public static String getValidRange(Integer stat)
    {
        StringBuilder result = new StringBuilder(100);
        if (stat == 1) {
            result.append("название ноутбука");
        } else if (stat == 2) {
            result.append("наличие в магазине (false или true)");
        } else if (stat == 3) {
            result.append("максимальную цену ноутбука (от 10000 до 100000");
        } else if (stat == 4) {
            result.append("минимальное ОЗУ ноутбука (от 8 до 32)");
        } else if (stat == 5) {
            result.append("максимальную диагональ экрана (от 10 до 30)");
        } else if (stat == 6) {
            result.append("максимальный объём памяти (от 128 до 1024)");
        } else if (stat == 7) {
            result.append("операционную систему ");
            result.append(Arrays.asList(OperationalSystem.values()));
        }
        return result.toString();
    }
    public String outputStat()
    {
        StringBuilder result = new StringBuilder(200);
        result.append("Name: ");
        result.append(Name);
        result.append(", ");
        result.append("IsAvailable: ");
        result.append(IsAvailable);
        result.append(", ");
        result.append("Price: ");
        result.append(Price);
        result.append(", ");
        result.append("Ram: ");
        result.append(Ram);
        result.append(", ");
        result.append("ScreenDiagonal: ");
        result.append(ScreenDiagonal);
        result.append(", ");
        result.append("Ssd: ");
        result.append(Ssd);
        result.append(", ");
        result.append("OperationalSystem: ");
        result.append(System.name());
        return result.toString();
    }

    public Laptop() {
        this.Name = "Laptop Standard " + Laptop.TotalLaptop.size() + 1;
        this.IsAvailable = true;
        this.Price = (float)30000;
        this.Ram = 8;
        this.ScreenDiagonal = (float)15.6;
        this.Ssd = 512;
        this.System = System.Windows_11;
        Laptop.TotalLaptop.put(Laptop.TotalLaptop.size() + 1, this);
    }

    public Laptop(Random R) {
        Integer thisLaptopID = Laptop.TotalLaptop.size() + 1;
        this.Name = "Laptop Standard " + thisLaptopID;
        this.IsAvailable = R.nextBoolean();
        this.Price = R.nextFloat(10_000,100_000);
        this.Ram = R.nextInt(1,5) * 8;
        this.ScreenDiagonal = (float)R.nextInt(5,16) * 2;
        this.Ssd = R.nextInt(1,9) * 128;
        OperationalSystem sys = System.values()[R.nextInt(0, System.values().length)];
        this.System = sys;
        Laptop.TotalLaptop.put(thisLaptopID, this);
    }

    public Laptop(String name, boolean isAvailable, Float price, Integer ram, Float screenDiagonal, Integer ssd, OperationalSystem operationalSystem) {
        this.Name = name;
        this.IsAvailable = isAvailable;
        this.Price = price;
        this.Ram = ram;
        this.ScreenDiagonal = screenDiagonal;
        this.Ssd = ssd;
        this.System = operationalSystem;
        Laptop.TotalLaptop.put(Laptop.TotalLaptop.size() + 1, this);
    }
}