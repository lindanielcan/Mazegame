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
public class Trap {
    public int type;
    public String name;
    public int value;
    public int row_pos;
    public int col_pos;
    public int trap;

    public Trap() {
        this.type = type;
        this.name = name;
        this.value = value;
        this.row_pos = row_pos;
        this.col_pos = col_pos;
        this.trap = trap;
    }
    
    public int getTrap() {
        return trap;        
    }
    
    public void setTrap(int howMany) {
        trap = howMany;
    }
    
    public void removeTrap(int howMany) {
        trap -= howMany;
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
}
