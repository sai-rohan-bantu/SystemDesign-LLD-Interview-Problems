package com.example;

import com.example.Game.TicTacToe;
import com.example.Player.HumanPlayerStrategy;
import com.example.Player.PlayerStrategy;

public class Main {
    public static void main(String[] args) {

        System.out.println("TicTacToe Problem Example");

        PlayerStrategy xStrategy = new HumanPlayerStrategy("Sai");
        PlayerStrategy oStrategy = new HumanPlayerStrategy("Rohan");
        TicTacToe ticTacToe = new TicTacToe(xStrategy, oStrategy,3 , 3);
        ticTacToe.play();
    }
}
