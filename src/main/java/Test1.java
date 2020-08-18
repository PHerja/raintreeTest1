package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    //private static final int RECORD_COUNT=3380000;
    private static final int RECORD_COUNT = 3380000;

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
        barChart();
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) / 1000f + " seconds to calculate bar chart.");
        long start2 = System.currentTimeMillis();
        countOfPrimeNumbersBigInt();
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

    private static void saveIntoFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        int i = 0;
        while (i < RECORD_COUNT) {
            writer.write(randomGenerator() + " ");
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

    private static void barChart() {
        Map<Long, Long> frequencyMap =
                list.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        int i=0;
        for (Map.Entry<Long, Long> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if (i>=9) break;
            i++;
        }
    }

    private static void countOfArmstrongNumbers() {
        List<Long> armstrongNumbersList = new ArrayList<>();
        long remainder,sum,digits,temp;
        for (long index : list) {
            sum = 0; temp = index; digits = 0;
            while (temp != 0) {
                digits++;
                temp = temp/10;
            }
            temp = index;
            while (temp != 0) {
                remainder = temp%10;
                sum = sum + power(remainder, digits);
                temp = temp/10;
            }
            if ( index == sum ){
                armstrongNumbersList.add(index);
            }
        }
        System.out.println("count of Armstrong numbers= " + armstrongNumbersList.size());
    }

    private static void countOfPrimeNumbersBigInt(){
        List<Long> primeNumbersList = new ArrayList<>();
        BigInteger bigInteger;
        for (long index : list) {
            bigInteger=BigInteger.valueOf(index);
            if (bigInteger.isProbablePrime(5)) {
                primeNumbersList.add(index);
            }
        }
        System.out.println("count of Prime numbers= " + primeNumbersList.size());
    }
    private static long power(long n, long r) {
        long c, p = 1;
        for (c = 1; c <= r; c++)
            p = p*n;
        return p;
    }

}
