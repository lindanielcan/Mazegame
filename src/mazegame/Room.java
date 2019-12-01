/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

/**
 *
 * @author Can Lin & Marik Rogenski
 */
public class Room {
    public boolean moveUp;
    public boolean moveDown;
    public boolean moveRight;
    public boolean moveLeft;
    public short validDirections;
    public int row_pos;
    public int col_pos;
    
    public Room() {
        moveUp = false;
        moveDown = false;
        moveRight = false;
        moveLeft = false;
        validDirections = 00000;
        // validDirections will be using bit maninpultation
        /*
        0 - most significant bit: modified
        0 - up enabled
        0 - down enabled
        0 - right enabled
        0 - left enabled
        */
    }
    
    
    /**
     * @param m which move to enable
     * 0 - up
     * 1 - down
     * 2 - right
     * 3 - left
     * 
     * This function is used in order to enable directional moves as the maze is generated.
    */
    public void enableMove(int m) {
        switch (m) {
            case 0:
                moveUp = true;
                break;
            case 1:
                moveDown = true;
                break;
            case 2:
                moveRight = true;
                break;
            case 3:
                moveLeft = true;
                break;
        }
    }

    public int getRow_pos() {
        return row_pos;
    }

    public int getCol_pos() {
        return col_pos;
    }
}
