/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

/**
 *
 * @author Can Lin and Marik Rogenski
 */
public class MazeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates 10x10 maze & plays the game
        Maze m1 = new Maze(10, 10);
        m1.playGame();
    }
}
