package com.example.Todomate.domain.Dice;

public class DiceGame {
    public static void main(String[] args) throws Exception{
        Player player = new Player();

        Dice dice = new Dice(6, player.getNumberOfDiceRoll());

        dice.roll();
        dice.printResult();
        System.exit(0);
    }
}