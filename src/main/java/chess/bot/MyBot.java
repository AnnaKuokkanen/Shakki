package chess.bot;

import chess.engine.GameState;
import datastructureproject.algorithm.RandomChoice;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;

public class MyBot implements ChessBot {
    
    private RandomChoice choice;
    TileNameConverter converter = new TileNameConverter();
    private final Board board = new Board();
    
    public MyBot() {
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    @Override
    public String nextMove(GameState gamestate) {       
        if (gamestate.getMoveCount() > 0) { 
            String opponentMove = gamestate.getLatestMove();
            
            Tile[] opponentTiles = converter.convertToTile(opponentMove);
            Tile start = opponentTiles[0];
            Tile finish = opponentTiles[1];
            
            int startX = start.getX();
            int startY = start.getY();
            int finishX = finish.getX();
            int finishY = finish.getY();

            if (board.getBoard()[finishX][finishY].getPiece() != null) {
                board.getBoard()[finishX][finishY].getPiece().remove();
            }
            
            board.getBoard()[finishX][finishY].setPiece(board.getBoard()[startX][startY].getPiece());
            board.getBoard()[startX][startY].setPiece(null);
        }
        
        this.choice = new RandomChoice(board);
        
        return choice.chooseMove();
    }
}