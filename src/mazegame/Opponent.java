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
public class Opponent {
    public int type;
    public String name;
    public int value;
    public int row_pos;
    public int col_pos;
    public int opponent;

    public Opponent() {
    }

    /**
     * 
     * @return the opponent contained at a certain cell
     */
    public int getOpponent() {
        return opponent;
    }

    /**
     * Sets the opponent at a cell
     * @param howMany the value of the opponent to add
     */
    public void setOpponent(int howMany) {
        opponent = howMany;
    }

    /**
     * Removes the opponent at a cell
     * @param howMany the value of the opponent to remove
     */
    public void removeOpponent(int howMany) {
        opponent -= howMany;
    }

    /**
     * 
     * @return the value of the opponent at the cell
     */
    public int getValue() {
        return value;
    }

    public void setRow(int row_pos) {
        this.row_pos = row_pos;
    }

    public void setCol(int col_pos) {
        this.col_pos = col_pos;
    }

    /**
     * 
     * @param Row the row to search
     * @param Col the col to search
     * @return true if an opponent is at the cell
     */
    public Boolean isFound(int Row, int Col){
        return (row_pos == Row && col_pos == Col);
    }

    /**
     * 
     * @param opponent value to transform to a string
     * @return string of the opponent's name
     */
    public String showOpponent(int opponent) {
        String strOpponent = "";

        switch (opponent) {
            case 1:
                strOpponent = "Gnome";
                break;
            case 2:
                strOpponent = "Dragon";
                break;
            case 3:
                strOpponent = "Ogre";
                break;
            case 4:
                strOpponent = "Manticore";
                break;
            case 5:
                strOpponent = "Wolf";
                break;
            case 6:
                strOpponent = "Hydra";
                break;
            case 7:
                strOpponent = "Mimic";
                break;
            case 8:
                strOpponent = "Wizard";
                break;
        }

        return strOpponent;
    }

}
