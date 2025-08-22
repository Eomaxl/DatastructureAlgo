package com.concurrency.session3;

public class EvenOddRunner {

    public static void run(){
        final EvenOddState state = new EvenOddState(EvenOddTurn.ODD);
        final EvenPrinter evenPrinter = new EvenPrinter(10, state);
        final OddPrinter oddPrinter= new OddPrinter(10, state);

        new Thread(evenPrinter).start();
        new Thread(oddPrinter).start();
    }
}
