package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    //private static final int RECORD_COUNT=3380000;
    private static Long recordCount = 3380000L;
    public static List<Long> list = new ArrayList<>();
    private static File file;
    private static String fileName;

    public static void main(String[] args) throws IOException {
        try {
            if (args[0].isEmpty()) {
                System.out.println("Filename is needed ! ");
                System.exit(0);
            }
            fileName = args[0] + ".txt";
            if (!args[1].isEmpty()) {
                recordCount = Long.parseLong(args[1]) / 20;
            }
        }catch(Exception e) {
            System.out.println("Something went wrong !!!");
        }
        createFile();
        saveIntoFile();
        long start = System.currentTimeMillis();
        loadFromFile();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds to read the file.");
        BarChart barChart= new BarChart();
        Methods methods = new Methods();
        long start1 = System.currentTimeMillis();
        barChart.barChart();
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) / 1000f + " seconds to calculate bar chart.");
        long start2 = System.currentTimeMillis();
        methods.countOfPrimeNumbers();
        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2) / 1000f + " seconds to calculate Prime numbers.");
        long start3 = System.currentTimeMillis();
        methods.countOfArmstrongNumbers();
        long end3 = System.currentTimeMillis();
        System.out.println((end3 - start3) / 1000f + " seconds to calculate Armstrong numbers.");

    }

    private static void createFile() {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = input.next();
        input.close();*/
        setFile(new File(fileName + ".txt"));
    }

    private static long randomGenerator() {
        return 1 + (long) (Math.random() * (Long.MAX_VALUE - 1));
    }
    private static long randomGenerator2() {
        return 1 + (long) (Math.random() * (1000 - 1));
    }

    private static void saveIntoFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        int i = 0;
        while (i < recordCount) {
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
}
