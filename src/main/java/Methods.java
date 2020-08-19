package main.java;

import java.math.BigInteger;

public class Methods {
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
