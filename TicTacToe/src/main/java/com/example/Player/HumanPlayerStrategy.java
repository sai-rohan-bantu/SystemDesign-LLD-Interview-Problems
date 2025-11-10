package com.example.Player;

import com.example.Board.Board;
import com.example.Position.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {


    private String name;
    private Scanner scanner;

    public HumanPlayerStrategy(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public Position makeMove(Board board) {
        while(true){
            System.out.println(name + ", enter your move (row and column): ");
            try
            {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position position = new Position(row, col);
                if (board.isValidMove(position)) {
                    return position;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid input. Please enter numeric values for row and column.");
                scanner.nextLine();
            }
        }
    }
}
