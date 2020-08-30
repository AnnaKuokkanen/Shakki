package datastructureproject;

import chess.bot.ChessBot;
import chess.bot.MyBot;
import chess.engine.GameState;
import chess.model.Side;

/**
 * Performance tests for MyBot.
 * 
 */
public class PerformanceTest {

    private static MyBot bot;
    
    public static void main(String[] args) {
        int[] depths = new int[] {1, 2, 3, 4};
        int moves = 20;
        
        for (int i = 0; i < depths.length; i++) {
            bot = new MyBot(depths[i]);
            GameState gamestate = new GameState();
            
            gamestate.playing = Side.WHITE;
            gamestate.turn = Side.WHITE;
            
            for (int j = 0; j < moves; j++) {
                if (j == 0) {
                    System.out.println("Starting to search with depth " + depths[i]);
                }
                long begin = System.nanoTime();
                bot.nextMove(gamestate);
                long finish = System.nanoTime();
                System.out.println("Time passed: " + (finish - begin));
            }
        }
    }
}
