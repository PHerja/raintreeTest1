package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    //private static final int RECORD_COUNT=3380000;
    private static final int RECORD_COUNT = 33800;

    private static List<Long> list = new ArrayList<>();
    private static File file;

    public static void main(String[] args) throws IOException {
        createFile();
        saveIntoFile();
        long start = System.currentTimeMillis();
        loadFromFile();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds to read the file.");
        long start1 = System.currentTimeMillis();
        //barChart();
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) / 1000f + " seconds to calculate bar chart.");
        long start2 = System.currentTimeMillis();
        countOfPrimeNumbers();
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2) / 1000f + " seconds to calculate Prime numbers.");
        long start3 = System.currentTimeMillis();
        countOfArmstrongNumbers();
        long end3 = System.currentTimeMillis();
        System.out.println((end3 - start3) / 1000f + " seconds to calculate Armstrong numbers.");

    }

    private static void createFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = input.next();
        input.close();
        setFile(new File(fileName + ".txt"));
    }

    private static long randomGenerator() {
        return 1 + (long) (Math.random() * (Long.MAX_VALUE - 1));
    }
    private static long randomGenerator2() {
        return 1 + (long) (Math.random() * (100000 - 1));
    }

    private static void saveIntoFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        int i = 0;
        while (i < RECORD_COUNT) {
            writer.write(randomGenerator2() + " ");
            i++;
        }
        writer.close();
    }

    private static void loadFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            list.add(sc.nextLong());
        }
        sc.close();
    }

    private static void setFile(File file) {
        Test1.file = file;
    }

    public static void barChart() {
        ArrayList <Integer> keys = new ArrayList<>();
        keys.addAll(tenMostCommon().keySet());
        Integer[] keyArray = new Integer[]{15, 12, 9, 7, 4, 3, 2, 2, 1, 0};
        Integer howManyLines = keys.get(0);
        Integer fixer = howManyLines - 1;

        while (howManyLines > 0) {
            System.out.print("           ");
            for (int i = 0; i <= 198; i++) {
                if (i % 22 == 0 && keys.get(i / 22) - fixer > 0) {
                    System.out.print("\u2588\u2588");
                }
                System.out.print(" ");
            }
            System.out.println();
            howManyLines--;
            fixer--;
        }
        tenMostCommon();

    }
    public static Map tenMostCommon() {
        Map<Long, Integer> map = new HashMap<>();
        for (Long t : Test1.list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }
        Map<Long,Integer> topTen =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return topTen;
    }
    private static boolean isArmstrongNumber(long number){
        long originalNumber = number, remainder, result = 0;
        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }
        return result == number;
    }

    public static void countOfArmstrongNumbers() {
        long count = 0;
        for (long index : Test1.list) {
            if(isArmstrongNumber(index)){
                count++;
            }
        }
        System.out.println("count of Armstrong numbers= " + count);
    }

    public static void countOfPrimeNumbers(){
        BigInteger bigInteger;
        int count=0;
        for (long index : Test1.list) {
            bigInteger=BigInteger.valueOf(index);
            if (bigInteger.isProbablePrime(5)) {
                count++;
            }
        }
        System.out.println("count of Prime numbers= " + count);
    }

}
