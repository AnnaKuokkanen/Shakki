package domain.board;

import domain.pieces.Piece;

/**
 * This class contains basic attributes for a single tile on 
 * the playing board such as location and piece it holds.
 */
public class Tile {
    
    private int x;
    private int y;
    private Piece piece;
    private final String id;
    private final TileNameConverter converter = new TileNameConverter();
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = converter.convertToString(x, y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String getId() {
        return id;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        if (this.piece != null) {
            this.piece.remove();
        }
        this.piece = piece;
        if (piece != null) {
            this.piece.setLocation(this.x, this.y);
        }
    }
    
    public boolean free() {
        return piece == null;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Tile) {
            Tile tile = (Tile) o;
            return (this.x == tile.getX() && this.y == tile.getY());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }
}
