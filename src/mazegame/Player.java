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
    public int score;
    public int coin;
    public int chanceOfCelocate;


    public Player(){
        row_pos = 0;
        col_pos = 0;
        healthPoint = 20;
        score = 0;
        this.coin = coin;
        this.chanceOfCelocate = chanceOfCelocate;
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

    public void setRow_pos(int row_pos) {
        this.row_pos = row_pos;
    }

    public void setCol_pos(int col_pos) {
        this.col_pos = col_pos;
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

    public int getHealthPoint() {
        return healthPoint;
    }

}
