package com.example.State;

import com.example.Player.Player;

interface GameState {
    void next(GameContext context, Player player, boolean hasWon);
    boolean isGameOver();
}
