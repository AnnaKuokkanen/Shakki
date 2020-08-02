package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.*;

public class King extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public King(Side side) {
        super(side, "king");
    }
    
    /**
     * king can move and capture on tile up, down, right or left
     * @param board for current game situation
     * @return list of tiles where king can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (tiles[x + 1][y] == null || tiles[x + 1][y].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 1][y]);
        }
        if (tiles[x][y + 1] == null || tiles[x + 1][y].getPiece().getSide() != this.side) {
            moves.add(tiles[x][y + 1]);
        }
        if (tiles[x][y - 1] == null || tiles[x + 1][y].getPiece().getSide() != this.side) {
            moves.add(tiles[x][y - 1]);
        }
        if (tiles[x - 1][y] == null || tiles[x + 1][y].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 1][y]);
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 900;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}