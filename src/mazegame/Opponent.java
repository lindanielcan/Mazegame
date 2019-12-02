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
public class Opponent {
    public int type;
    public String name;
    public int value;
    public int row_pos;
    public int col_pos;
    public int opponent;

    public Opponent() {
        this.type = type;
        this.name = name;
        this.value = value;
        this.row_pos = row_pos;
        this.col_pos = col_pos;
        this.opponent = opponent;
    }

    public int getOpponent() {
        return opponent;
    }

    public void setOpponent(int howMany) {
        opponent = howMany;
    }

    public void removeOpponent(int howMany) {
        opponent -= howMany;
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

    public Boolean isFound(int Row, int Col){
        return (row_pos == Row && col_pos == Col);
    }

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
