package com.concurrency.session3;

public class EvenPrinter implements Runnable{

    private int n;
    private EvenOddState state;

    public EvenPrinter(int n, EvenOddState state) {
        this.n = n;
        this.state = state;
    }

    @Override
    public void run() {
        int curNum = 2;
        while (curNum <= n) {
            while (state.getTurn() != EvenOddTurn.EVEN) {
                System.out.println(curNum);
                curNum += 2;
                state.setTurn(EvenOddTurn.ODD);
            }
        }
    }
}
