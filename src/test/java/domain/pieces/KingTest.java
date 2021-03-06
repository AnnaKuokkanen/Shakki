package domain.pieces;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KingTest {
    
    private King blackKing;
    private King whiteKing;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteKing = new King(Side.WHITE);
        this.blackKing = new King(Side.BLACK);
    }
    
    @Test
    public void doesKingHaveTheRightValue() {
        assertEquals(-900, this.blackKing.getValue());
        assertEquals(900, this.whiteKing.getValue());
    }
    
    @Test
    public void doesKingStayIfTilesAreOccupiedBySameSidePieces() {
        this.board = new Board();
        this.board.setupBoard();
        
        ArrayList moves = new ArrayList();
        
        board.getBoard()[1][1].setPiece(whiteKing);
        
        board.getBoard()[0][0].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[0][1].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[0][2].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[1][0].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[2][0].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[2][1].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[2][2].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whiteKing.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKing.getPossibleMoves(board).get(i));
        }
        
        assertTrue(moves.isEmpty());    
    }
    
    @Test
    public void doesKingMoveWhenTilesOccupiedByOpponents() {
        this.board = new Board();
        this.board.setupBoard();
        
        ArrayList moves = new ArrayList();
        
        board.getBoard()[1][1].setPiece(whiteKing);
        
        board.getBoard()[0][0].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[0][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[0][2].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[1][0].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[1][2].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[2][0].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[2][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[2][2].setPiece(new Pawn(Side.BLACK));
        
        for (int i = 0; i < whiteKing.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKing.getPossibleMoves(board).get(i));
        }
        
        assertTrue(moves.size() == 8);
        assertTrue(moves.contains(new Tile(0, 0)));
        assertTrue(moves.contains(new Tile(0, 1)));
        assertTrue(moves.contains(new Tile(0, 2)));
        assertTrue(moves.contains(new Tile(1, 0)));
        assertTrue(moves.contains(new Tile(1, 2)));
        assertTrue(moves.contains(new Tile(2, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(2, 2)));
    }
    
    @Test
    public void doesKingMoveWhenTilesAreFree() {
        this.board = new Board();
        this.board.setupBoard();
        
        ArrayList moves = new ArrayList();
        
        board.getBoard()[1][1].setPiece(whiteKing);
        
        for (int i = 0; i < whiteKing.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKing.getPossibleMoves(board).get(i));
        }
        
        assertTrue(moves.size() == 8);
        assertTrue(moves.contains(new Tile(0, 0)));
        assertTrue(moves.contains(new Tile(0, 1)));
        assertTrue(moves.contains(new Tile(0, 2)));
        assertTrue(moves.contains(new Tile(1, 0)));
        assertTrue(moves.contains(new Tile(1, 2)));
        assertTrue(moves.contains(new Tile(2, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(2, 2)));
    }
}
