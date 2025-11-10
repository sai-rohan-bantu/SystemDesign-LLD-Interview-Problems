package com.example.Board;

import com.example.Enum.Symbol;
import com.example.Player.Player;
import com.example.Position.Position;
import com.example.State.GameContext;

public class Board {
    int rows;
    int cols;
    Symbol[][] grid;
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Symbol[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        return grid[row][col] == Symbol.EMPTY;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(Position position, Symbol symbol) {
        int row = position.getRow();
        int col = position.getCol();
        if (isValidMove(position)) {
            grid[row][col] = symbol;
        }
    }

    public void checkGameState(GameContext gameContext, Player currentPlayer) {
        for(int i=0;i<rows;i++){
            if(grid[i][0]!=Symbol.EMPTY && isWinningLine(grid[i])){
                gameContext.next(currentPlayer, true);
                return;
            }
        }
        for(int i=0;i<rows;i++){
            Symbol[] column = new Symbol[cols];
            for(int j=0;j<cols;j++){
                column[j] = grid[j][i];
            }
            if(column[0]!=Symbol.EMPTY && isWinningLine(column)){
                gameContext.next(currentPlayer, true);
                return;
            }
        }
        Symbol[] diag1 = new Symbol[Math.min(rows, cols)];
        Symbol[] diag2 = new Symbol[Math.min(rows, cols)];

        for(int i=0;i<Math.min(rows, cols);i++){
            diag1[i] = grid[i][i];
            diag2[i] = grid[i][cols - i - 1];
        }

        if(diag1[0]!=Symbol.EMPTY && isWinningLine(diag1)){
            gameContext.next(currentPlayer, true);
            return;
        }
        if(diag2[0]!=Symbol.EMPTY && isWinningLine(diag2)){
            gameContext.next(currentPlayer, true);
            return;
        }
        gameContext.next(currentPlayer, false);
    }

    public boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol symbol : line) {
            if (symbol != first) {
                return false;
            }
        }
        return true;
    }
}
