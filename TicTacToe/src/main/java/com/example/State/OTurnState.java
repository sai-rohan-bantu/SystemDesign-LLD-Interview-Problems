package com.example.State;

import com.example.Enum.Symbol;
import com.example.Player.Player;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setState(player.getSymbol() == Symbol.X ? new XWinState() : new OWinState());
        } else {
            context.setState(new XTurnState());
        }
    }
    @Override
    public boolean isGameOver() {
        return false;
    }
}
