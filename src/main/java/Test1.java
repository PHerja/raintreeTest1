package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
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
        loadFromFile();
        BarChart barChart= new BarChart();
        Methods methods = new Methods();
        PrimeNumbersThread thread=new PrimeNumbersThread(methods);
        System.out.println();
        thread.start();
        barChart.barChart();
        methods.countOfArmstrongNumbers();
    }

    /**
     * Scanner input for just in case ...
     */

    private static void createFile() throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        fileName = input.next();*/

        setFile(new File(fileName + ".txt"));
        FileWriter writer = new FileWriter(file);
        int i = 0;
        while (i < recordCount) {
            writer.write(randomGenerator() + " ");
            i++;
        }
        writer.close();
        //input.close();
    }

    private static long randomGenerator() {
        return 1 + (long) (Math.random() * (Long.MAX_VALUE - 1));
    }

    private static void loadFromFile() throws FileNotFoundException {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            list.add(sc.nextLong());
        }
        sc.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds to read the file.");
    }

    private static void setFile(File file) {
        Test1.file = file;
    }
}
