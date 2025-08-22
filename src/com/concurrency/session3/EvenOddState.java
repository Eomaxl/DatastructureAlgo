package com.concurrency.session3;

public class EvenOddState {
    private EvenOddTurn evenOddTurn;

    public EvenOddState(EvenOddTurn evenOddTurn) {
        this.evenOddTurn = evenOddTurn;
    }

    public EvenOddTurn getTurn(){
        return this.evenOddTurn;
    }

    public void setTurn(EvenOddTurn turn){
        this.evenOddTurn = turn;
    }
}
