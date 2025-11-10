package com.example.State;

public class XWinState implements GameState {
    @Override
    public void next(GameContext context, com.example.Player.Player player, boolean hasWon) {
        // Game is over, no further state transitions.
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
