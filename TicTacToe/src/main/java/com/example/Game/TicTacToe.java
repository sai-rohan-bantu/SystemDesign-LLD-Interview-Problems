package com.example.Game;

import com.example.Board.Board;
import com.example.Enum.Symbol;
import com.example.Player.Player;
import com.example.Player.PlayerStrategy;
import com.example.Position.Position;
import com.example.State.GameContext;

public class TicTacToe implements BoardGame {

    private Board board;
    private Player playerX;
    private Player playerY;
    private Player currentPlayer;

    private GameContext gameContext;

    public TicTacToe(PlayerStrategy strategyX, PlayerStrategy strategyY, int rows, int cols) {
        this.board = new Board(rows, cols);
        this.playerX = new Player(Symbol.X, strategyX);
        this.playerY = new Player(Symbol.O, strategyY);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext();
    }

    @Override
    public void play() {
        System.out.println("Playing TicTacToe...");

        do{
            board.printBoard();
            Position move = currentPlayer.getStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            board.checkGameState(gameContext, currentPlayer);
            if(!gameContext.isGameOver()){
                switchPlayer();
            }
        }while(!gameContext.isGameOver());
        announceWinner();

    }

    @Override
    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerY : playerX;
    }

    @Override
    public void announceWinner() {
        board.printBoard();
        if (gameContext.getCurrentState() != null) {
            System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
        } else {
            System.out.println("The game is a draw.");
        }
    }
}
