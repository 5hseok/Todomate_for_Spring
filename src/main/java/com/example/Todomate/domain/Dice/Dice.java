package com.example.Todomate.domain.Dice;

import java.util.Arrays;

public class Dice {
    public final int diceMaxNum;
    public int[] numCount;
    public int executeNum;

    public Dice(int diceMaxNum, int executeNum) {
        this.diceMaxNum = diceMaxNum;
        this.numCount = new int[diceMaxNum];
        Arrays.fill(numCount, 0);
        this.executeNum = executeNum;
    }

    public void roll(){
        for(int i = 0; i < executeNum; i++){
            this.numCount[(int)(Math.random() * 6)] += 1;
        }
    }
    public void printResult(){
        for(int i=0; i < numCount.length; i++){
            System.out.println((i+1) + "은 "+ numCount[i] +"번 나왔습니다.");
        }
    }
}
