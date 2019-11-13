/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.util.Random;

/**
 *
 * @author Can Lin & Marik Rogenski
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
        this.treasure = treasure;
        this.value = value;
        this.row_pos = row_pos;
        this.col_pos = col_pos;
    }

    public int getTreasure() {
        return treasure;
//        Random rand = new Random();
//        int treasure = rand.nextInt(8);
//        return (treasure+1);        
    }
    
    public void setTreasure(int howMany) {
        treasure = howMany;
    }
    
    public void removeTreasure(int howMany) {
        treasure -= howMany;
    }
    
    public int getValue() {
        return value;
    }

    public void setRow(int row_pos) {
        this.row_pos = row_pos;
    }

    public void setCol(int col_pos) {
        this.col_pos = col_pos;
    }

    public int getRow_pos() {
        return row_pos;
    }

    public int getCol_pos() {
        return col_pos;
    }
    
    
    
    public Boolean isFound(int Row, int Col){
        return (row_pos == Row && col_pos == Col);
    }
    
    
    public String showTreasure(int type) {
        String strTreasure = "";
        
        switch (type) {
            case 1:
                strTreasure = "Jewel";
                break;
            case 2:
                strTreasure = "Sword";
                break;
            case 3:
                strTreasure = "Potion";
                break;
            case 4:
                strTreasure = "Map";
                break;
            case 5:
                strTreasure = "Key";
                break;
            case 6:
                strTreasure = "Shield";
                break;
            case 7:
                strTreasure = "Armor";
                break;
            case 8:
                strTreasure = "Torch";
                break;            
        }
        
        return strTreasure;
    }
}
