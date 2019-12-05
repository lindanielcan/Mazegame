/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.util.Random;

/**
 *
 * @author Can Lin and Marik Rogenski
 */
public class Treasure {
    Random rand = new Random();
    public int type = rand.nextInt(7) + 1;
    public String name;
    public int value;
    public int row_pos;
    public int col_pos;
    public int treasure;

    public Treasure() {
    }

    /**
     * 
     * @return value of the treasure
     */
    public int getTreasure() {
        return treasure;
    }

    /**
     * 
     * @param howMany the value of the treasure to be set
     */
    public void setTreasure(int howMany) {
        treasure = howMany;
    }

    /**
     *
     * @param howMany the treasure to remove from the cell
     */
    public void removeTreasure(int howMany) {
        treasure -= howMany;
    }

    /**
     * 
     * @return value of the treasure
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @param row_pos the new row of the treasure
     */
    public void setRow(int row_pos) {
        this.row_pos = row_pos;
    }

    /**
     * 
     * @param col_pos the new col of the treasure
     */
    public void setCol(int col_pos) {
        this.col_pos = col_pos;
    }

    /**
     * 
     * @return the row pos of the treasure
     */
    public int getRow_pos() {
        return row_pos;
    }

    /**
     * 
     * @return the col position of the treasure
     */
    public int getCol_pos() {
        return col_pos;
    }

    /**
     * 
     * @param Row the row to be tested for treasure
     * @param Col the col to be tested for treasure
     * @return true if treasure is located at the Row and Col
     */
    public Boolean isFound(int Row, int Col){
        return (row_pos == Row && col_pos == Col);
    }

    /**
     * 
     * @param type value of the treasure
     * @return the string that is attached to the value of the treasure
     */
    public String showTreasure(int type) {
        String strTreasure = "";

        switch (type) {
            case 1:
                strTreasure = "Bow";
                break;
            case 2:
                strTreasure = "Sword";
                break;
            case 3:
                strTreasure = "Health Potion";
                break;
            case 4:
                strTreasure = "Spear";
                break;
            case 5:
                strTreasure = "Wand";
                break;
            case 6:
                strTreasure = "Dagger";
                break;
            case 7:
                strTreasure = "AK47";
                break;
            case 8:
                strTreasure = "Grenade";
                break;
        }

        return strTreasure;
    }
}
