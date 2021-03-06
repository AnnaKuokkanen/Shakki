package domain.pieces;

import chess.model.Side;
import domain.board.*;
import datastructureproject.datastructure.ArrayList;

public class Pawn extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Pawn(Side side) {
        super(side, PieceName.PAWN);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    /**
     * Pawn can move straight forward or capture diagonally.
     * @param board for current game situation
     * @return list of tiles where pawn can legally move
     */
    @Override
    public ArrayList getPossibleMoves(Board board) {
        ArrayList moves = new ArrayList();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (this.side == Side.BLACK) {
            if (y + 1 < 8 && tiles[x][y + 1].free()) {
                moves.add(tiles[x][y + 1]);
            }
            if (x - 1 >= 0 && y + 1 < 8 && !tiles[x - 1][y + 1].free() && differentSide(tiles[x - 1][y + 1])) {
                moves.add(tiles[x - 1][y + 1]);
            }
            if (x + 1 < 8 && y + 1 < 8 && !tiles[x + 1][y + 1].free() && differentSide(tiles[x + 1][y + 1])) {
                moves.add(tiles[x + 1][y + 1]);
            }
        } else if (this.side == Side.WHITE) {
            if (y - 1 >= 0 && tiles[x][y - 1].free()) {
                moves.add(tiles[x][y - 1]);
            }
            if (x - 1 >= 0 && y - 1 >= 0 && !tiles[x - 1][y - 1].free() && differentSide(tiles[x - 1][y - 1])) {
                moves.add(tiles[x - 1][y - 1]);
            }
            if (x + 1 < 8 && y - 1 >= 0 && !tiles[x + 1][y - 1].free() && differentSide(tiles[x + 1][y - 1])) {
                moves.add(tiles[x + 1][y - 1]);
            }
        }
        
        return moves;
    }

    @Override
    public int getValue() {
        int value = 10;
        if (side == Side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
