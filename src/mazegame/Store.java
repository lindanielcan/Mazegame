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
public class Store {
    public int row_pos;
    public int col_pos;
    public int store;

    public Store(){
    }

    /**
     * 
     * @return store number 
     */
    public int getStore() {
        return store;
    }

    /**
     * 
     * @param store number to set the store to
     */
    public void setStore(int store) {
        this.store = store;
    }

    /**
     * 
     * @param type the item's number
     * @return the string that is attache to the item's number
     */
    public String showItem(int type) {
        String strItem = "";

        switch (type) {
            case 1:
                strItem = "Bow";
                break;
            case 2:
                strItem = "Sword";
                break;
            case 3:
                strItem = "Health Potion";
                break;
            case 4:
                strItem = "Spear";
                break;
            case 5:
                strItem = "Wand";
                break;
            case 6:
                strItem = "Dagger";
                break;
            case 7:
                strItem = "AK47";
                break;
            case 8:
                strItem = "Grenade";
                break;
        }
        return strItem;
    }
}
