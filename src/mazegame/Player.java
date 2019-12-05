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
public class Player {
    public int row_pos;
    public int col_pos;
    public int player;
    public int healthPoint;
    public int score;
    public int coin;
    public int chanceOfCelocate;


    public Player(){
        row_pos = 0;
        col_pos = 0;
        healthPoint = 20;
        score = 0;
    }

    /**
     *
     * @return row pos of player
     */
    public int getRow_pos() {
        return row_pos;
    }

    /**
     * 
     * @return col pos of player
     */
    public int getCol_pos() {
        return col_pos;
    }

    /**
     * 
     * @return player at cell
     */
    public int getPlayer() {
        return player;
    }

    /**
     * Sets the player's row position
     * @param row_pos the new row position for the player
     */
    public void setRow_pos(int row_pos) {
        this.row_pos = row_pos;
    }

    /**
     * Sets the player's col position
     * @param col_pos the new col position for the player
     */
    public void setCol_pos(int col_pos) {
        this.col_pos = col_pos;
    }

    /**
     * Moves the player up a row
     */
    public void moveUp(){
        row_pos--;
    }
    
    /**
     * Moves the player down a row
     */
    public void moveDown(){
        row_pos++;
    }
    
    /**
     * Moves the player to a column to the left
     */
    public void moveLeft(){
        col_pos--;
    }
    
    /**
     * Moves the player to a column to the right
     */
    public void moveRight(){
        col_pos++;
    }

    /**
     * Sets the value of the player
     * @param howMany the number the player should be assigned
     */
    public void setPlayer(int howMany) {
        player = howMany;
    }

    /**
     * 
     * @return the health points of the player
     */
    public int getHealthPoint() {
        return healthPoint;
    }

}
