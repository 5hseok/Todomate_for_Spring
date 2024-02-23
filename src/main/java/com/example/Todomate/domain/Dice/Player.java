package com.example.Todomate.domain.Dice;

import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    public int getNumberOfDiceRoll(){
        System.out.print("숫자를 입력하시오 : ");
        return input.nextInt();
    }
}
