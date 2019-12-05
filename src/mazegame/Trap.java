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
public class Trap {
    public int type;
    public String name;
    public int value;
    public int row_pos;
    public int col_pos;
    public int trap;

    public Trap() {
    }

    /**
     * 
     * @return trap value
     */
    public int getTrap() {
        return trap;
    }
    
    public void setTrap(int howMany) {
        trap = howMany;
    }

    /**
     * removes the trap at the location
     * @param howMany number of trap to remove
     */
    public void removeTrap(int howMany) {
        trap -= howMany;
    }

    /**
     * 
     * @return value of trap at location
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @param row_pos the row to set the trap at
     */
    public void setRow(int row_pos) {
        this.row_pos = row_pos;
    }

    /**
     * 
     * @param col_pos the col to set the trap at
     */
    public void setCol(int col_pos) {
        this.col_pos = col_pos;
    }

    /**
     * 
     * @param Row row to test the presence of a trap
     * @param Col col to test the presence of a trap
     * @return true if a trap is present there
     */
    public Boolean isFound(int Row, int Col){
        return (row_pos == Row && col_pos == Col);
    }
}