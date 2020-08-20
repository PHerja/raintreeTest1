package main.java;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Methods {
    private  Set<Long> set=new HashSet<>(Test1.list);
    private  boolean isArmstrongNumber(long number){
        long originalNumber = number, remainder, result = 0;
        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }
        return result == number;
    }

    public void countOfArmstrongNumbers() {
        long start = System.currentTimeMillis();
        int count = 0;
        for (long index : set) {
            if(isArmstrongNumber(index)){
                count++;
            }
        }
        System.out.println("count of Armstrong numbers= " + count);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds to calculate Armstrong numbers.");
    }

    public void countOfPrimeNumbers(){
        long start = System.currentTimeMillis();
        BigInteger bigInteger;
        int count=0;
        for (long index : set) {
            bigInteger=BigInteger.valueOf(index);
            if (bigInteger.isProbablePrime(5)) {
                count++;
            }
        }
        System.out.println("count of Prime numbers= " + count);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds to calculate Prime numbers.");
    }

}
