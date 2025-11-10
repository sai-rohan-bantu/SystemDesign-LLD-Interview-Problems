package com.example.Player;

import com.example.Board.Board;
import com.example.Position.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);
}
