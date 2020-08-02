package domain.board;

public class TileNameConverter {
    
    String[] letters;
    
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
     *
     * @return location in textual form, like "a1" for tile in location (0,0)
     */
    public String convert(int x, int y) {
        String tile = "";
        
        tile.concat(letters[x]);
        tile.concat(Integer.toString(y + 1));
        
        return tile;
    } 
}