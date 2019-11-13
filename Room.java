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
    public int row_pos;
    public int col_pos;
    
    public Room() {
        moveUp = true; // false;
        moveDown = true; // false;
        moveRight = true; // false;
        moveLeft = true; // false;     
        this.row_pos = row_pos;
        this.col_pos = col_pos;
    }

    public int getRow_pos() {
        return row_pos;
    }

    public int getCol_pos() {
        return col_pos;
    }
}
