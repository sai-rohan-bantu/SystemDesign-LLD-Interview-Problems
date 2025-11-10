package com.example.Player;

import com.example.Board.Board;
import com.example.Enum.Symbol;
import com.example.Position.Position;
import lombok.Data;


@Data
public class Player {
    private Symbol symbol;
    private PlayerStrategy strategy;

    public Player(Symbol symbol,PlayerStrategy strategy) {
        this.strategy = strategy;
        this.symbol = symbol;
    }

}
