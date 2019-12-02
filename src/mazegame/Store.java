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
public class Store {
    public int row_pos;
    public int col_pos;
    public int store;

    public Store(){
        this.row_pos = row_pos;
        this.col_pos = col_pos;
        this.store = store;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

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
