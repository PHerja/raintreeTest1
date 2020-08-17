package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    private static List<Long> list=new ArrayList<>();
    private static File file;

    public static void main(String[] args) throws IOException {
        createFile();
        saveIntoFile();
        long start=System.currentTimeMillis();
        loadFromFile();
        long end= System.currentTimeMillis();
        System.out.println((end-start) / 1000f + " seconds to read file.");

    }
    private static void createFile() {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName=input.next();
        input.close();
        setFile(new File(fileName + ".txt"));
    }

    private static long randomGenerator(){
        return 1+(long)(Math.random() * (Long.MAX_VALUE - 1));
    }

    private static void saveIntoFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        int i=0;
        while ( i<3380000){
            writer.write(randomGenerator() +" ");
            i++;
        }
        writer.close();
    }

    private static void loadFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            list.add(sc.nextLong());
        }
        sc.close();
    }

    public static void setFile(File file) {
        Test1.file = file;
    }

    public static void barChart(){

    }

    public static void countOfPrimeNumbers(){

    }

    public static void countOfArmstrongNumbers(){

    }
}
