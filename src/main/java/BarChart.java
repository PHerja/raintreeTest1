package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class BarChart {
    public static void barChart() {
        ArrayList<Long> keys = new ArrayList<>(tenMostCommon().keySet());
        ArrayList<Integer> values = new ArrayList<>(tenMostCommon().values());
        Integer howManyLines = values.get(0);
        Integer fixer = howManyLines - 1;

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
