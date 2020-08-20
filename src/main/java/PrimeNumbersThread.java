package main.java;
/**
 * So we can add threads from Method class later on.
 */

public class PrimeNumbersThread extends Thread{
    Methods countPrimeRef;
    PrimeNumbersThread(Methods cP){
        countPrimeRef=cP;
    }

    @Override
    public void run() {
        countPrimeRef.countOfPrimeNumbers();
    }
}
