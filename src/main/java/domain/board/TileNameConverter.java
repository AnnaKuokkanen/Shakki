package domain.board;

/**
 * This class provides methods for converting moves 
 * from Tile pairs to String and from String format to 
 * Tile pairs.
 */
public class TileNameConverter {
    
    private String[] letters;
    
    public TileNameConverter() {
        this.letters = new String[8];
        this.letters[0] = "a";
        this.letters[1] = "b";
        this.letters[2] = "c";
        this.letters[3] = "d";
        this.letters[4] = "e";
        this.letters[5] = "f";
        this.letters[6] = "g";
        this.letters[7] = "h";
    }
    
    /**
     * @return location in textual form, like "a1" for tile in location (0, 0)
     * @param x depicts column 
     * @param y depicts row 
     */
    public String convertToString(int x, int y) {
        String tile = "";
        
        tile += letters[x];
        tile += Integer.toString(8 - y);
        
        return tile;
    } 
    
    /**
     * this method enables changing opponents moves to Tile values
     * and updating the board.
     * 
     * @param move depicts move in textual form 
     * @return array which contains two tiles:
     * array[0] = start
     * array[1] = finish
     */
    public Tile[] convertToTile(String move) {
        Tile[] tiles = new Tile[2];
        char[] moves = move.toCharArray();

        for (int i = 0; i < 8; i++) {
            if (String.valueOf(moves[0]).equals(letters[i])) {
                tiles[0] = new Tile(i, 8 - Character.getNumericValue(moves[1]));
            }
            if (String.valueOf(moves[2]).equals(letters[i])) {
                tiles[1] = new Tile(i, 8 - Character.getNumericValue(moves[3]));
            }
        } 
        return tiles;
    }
}