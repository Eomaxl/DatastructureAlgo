package com.concurrency.session3;

public class OddPrinter implements Runnable {
    private int n;
    private EvenOddState state;

    public OddPrinter(int n, EvenOddState state) {
        this.n = n;
        this.state = state;
    }

    @Override
    public void run() {
        int currentNum = 1;
        while (currentNum <= n) {
            synchronized (state){
                while (state.getTurn() == EvenOddTurn.ODD) {
                    state.wait();
                }
                System.out.println(currentNum);
                currentNum += 2;
                state.setTurn(EvenOddTurn.EVEN);
                state.notifyAll();
            }
        }
    }
}