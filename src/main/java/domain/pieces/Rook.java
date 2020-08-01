package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import java.util.ArrayList;

public class Rook extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Rook(Side side) {
        super(side, "rook");
    }
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> tiles = new ArrayList<>();
        
        return tiles;
    }
    
    public int getValue() {
        int value = 50;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
