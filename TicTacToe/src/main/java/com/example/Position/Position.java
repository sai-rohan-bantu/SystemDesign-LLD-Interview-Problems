package com.example.Position;

import lombok.Data;

@Data
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
