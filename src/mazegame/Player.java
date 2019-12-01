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
public class Player {
    public int row_pos;
    public int col_pos;
    public int player;
    public int healthPoint;
    
    public Player(){
        row_pos = 0;
        col_pos = 0;
        healthPoint = 10;
    }

    public int getRow_pos() {
        return row_pos;
    }

    public int getCol_pos() {
        return col_pos;
    }
    
    public int getPlayer() {
        return player;        
    }   
    
    public void moveUp(){
        row_pos--;
    }
    public void moveDown(){
        row_pos++;
    }
    public void moveLeft(){
        col_pos--;
    }
    public void moveRight(){
        col_pos++;
    }
    
    public void setPlayer(int howMany) {
        player = howMany;
    }
}
