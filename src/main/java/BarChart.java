package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class BarChart {
    public static void barChart() {
        ArrayList<Long> keys = new ArrayList<>((tenMostCommon().keySet()));
        ArrayList<Integer> values = new ArrayList<>(tenMostCommon().values());
        Integer howManyLines = values.get(0);
        Integer fixer = howManyLines - 1;
        System.out.println();
        while (howManyLines > 0) {
            System.out.print("           ");
            for (int i = 0; i <= 198; i++) {
                if (i % 22 == 0 && values.get(i / 22) - fixer > 0) {
                    System.out.print("\u2588\u2588");
                }
                System.out.print(" ");
            }
            System.out.println();
            howManyLines--;
            fixer--;
        }
        int counter=12-keys.get(0).toString().length()/2;
        int j =10-counter;
        int index=0;
        for ( int i = j; i <= 220; i++) {
            if (counter  == 0) {
                System.out.print(keys.get(index));
                if (index>=9){break;}
                counter=24-(keys.get(index).toString().length()+keys.get(index+1).toString().length())/2;
                index++;
            }
            System.out.print(" ");
            counter--;
        }
        System.out.println();
    }

    public static Map tenMostCommon() {
        Map<Long, Integer> map = new HashMap<>();
        for (Long t : Test1.list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

}
