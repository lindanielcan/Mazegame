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

import java.util.*;

public class Maze {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    
    public int num_rows; // = 10;
    public int num_cols; // = 10;
    
    protected Room[][] Board; //  = new Room[10][10];
    protected Treasure[][] Treasures; // = new int[NUM_ROWS][NUM_COLS]; // T = Treasure
    protected Opponent[][] Opponents; // = new int[NUM_ROWS][NUM_COLS]; // O = Opponent
    protected Trap[][] Traps; // = new int[NUM_ROWS][NUM_COLS];     // Z = Trap
    protected Player[][] player1; // P = Player 
    protected Store[][] store1; // S = Store
    
    protected int[] Inventory = new int[100];
    public int numInventory;
    
//    public int storeAddressRow = 0;
//    public int storeAddressCol = 0;
//    protected static int numTreasures = 0;
//    protected static int numOpponents = 0;
//    protected static int numTraps = 0;
//    protected static int numStores = 0;
    protected int[] rowTreasureContainer;
    protected int[] colTreasureContainer;
    protected int[] rowOpponentContainer;
    protected int[] colOpponentContainer;
    protected int[] rowTrapContainer;
    protected int[] colTrapContainer;
    protected int[] rowStoreContainer;
    protected int[] colStoreContainer;
    //protected Boolean checkKeys;
    public Boolean gameOver = false;
            

    
    //protected int[][] Player = new int[NUM_ROWS][NUM_COLS];
    
    private int row_pos;
    private int col_pos;
    private char move;
    

    public Maze(int max_rows, int max_cols) {
        
        num_rows = max_rows;
        num_cols = max_cols;
        rowTreasureContainer = new int[num_rows];
        colTreasureContainer = new int[num_cols];
        rowOpponentContainer = new int[num_rows];
        colOpponentContainer = new int[num_cols];
        rowTrapContainer = new int[num_rows];
        colTrapContainer = new int[num_cols];
        rowStoreContainer = new int[num_rows];
        colStoreContainer = new int[num_cols];
        
        Board = new Room[num_rows][num_cols];
        Treasures = new Treasure[num_rows][num_cols]; // T = Treasure
        Opponents = new Opponent[num_rows][num_cols]; // O = Opponent
        Traps = new Trap[num_rows][num_cols];     // Z = Trap
        player1 = new Player[num_rows][num_cols]; // P = Player
        store1 = new Store[num_rows][num_cols]; // P = Player
        numInventory = 0;

                
        playGame();
    }
    
    public void drawBoard() {
       
        for (int i = 0; i < num_cols * 4 ; i++) {
            System.out.print("--");
        }
        
        System.out.println("-");
        
        // Outer loop to print rows.
        for (int row = 0; row < num_rows; row++) {
            
            // Inner loop to print columns
            for (int col =0; col < num_cols; col++) {
                System.out.print("| ");
                
                // Player
                if (row == player1[row_pos][col_pos].getRow_pos() && col == player1[row_pos][col_pos].getCol_pos()) {
                    System.out.print("P");//+ player1[row_pos][col_pos].getRow_pos()+ player1[row_pos][col_pos].getCol_pos());
                }
                
                else
                {
                    System.out.print(" ");
                }           
                
                if (Treasures[row][col].getTreasure() > 0) {
                    System.out.print("T");
                    //Use two arrays that contain locations of treasures to munipulate treasures.
//                    while(true){
//                        rowTreasureContainer[numTreasures] = row;
//                        colTreasureContainer[numTreasures] = col;
//                        break;
//                    }
//                    rowTreasureContainer[numTreasures] = row;
//                    colTreasureContainer[numTreasures] = col;
                    //System.out.print(row+"" + col + "" + rowTreasureContainer[numTreasures]+""+colTreasureContainer[numTreasures]);
//                    numTreasures++;
                }
                else
                {
                    System.out.print(" ");
                }             
                
                //if (Treasures[row][col].getTreasure() > 0) {
                    
//                    if(player1[row_pos][col_pos].getRow_pos() == row
//                        && player1[row_pos][col_pos].getCol_pos() == col
//                        && move == 'T'){
//                        rowAddressContainer[storeAddressRow] = row;
//                        storeAddressRow++;
//                        colAddressContainer[storeAddressCol] = col;
//                        storeAddressCol++;
//                        System.out.print(" ");
//                        for(int i=0; i<((num_rows+num_cols)*3/4);i++){
//                            if(rowAddressContainer[i] == row && colAddressContainer[i] == col){checkKeys = true;}
//                            else{
//                                checkKeys = false;
//                            }
//                        }
//                        if(checkKeys){
//                            System.out.print(" ");
//                        }
//                        if(checkKeys = false){
//                            System.out.print("T");
//                        }
//                      }
//                    else{
//                         System.out.print(" ");
                    //}
//                    
                //}
//if (Treasures[row][col].getTreasure() > 0) {
//                    if(player1[row_pos][col_pos].getRow_pos() == Treasures[row_pos][col_pos].getRow_pos()
//                    && player1[row_pos][col_pos].getCol_pos() == Treasures[row_pos][col_pos].getCol_pos()
//                    && move == 'T'){
//                        rowAddressContainer[storeAddressRow] = player1[row_pos][col_pos].getRow_pos();
//                        storeAddressRow++;
//                        colAddressContainer[storeAddressCol] = player1[row_pos][col_pos].getCol_pos();
//                        storeAddressCol++;
//                        
//                        //System.out.print(" ");
//                        for(int i=0; i<((num_rows+num_cols)*3/4);i++){
//                            if(rowAddressContainer[i] == Treasures[row_pos][col_pos].getRow_pos()&&
//                                    colAddressContainer[i] == Treasures[row_pos][col_pos].getCol_pos()){checkKeys = true;}
//                            else{
//                                checkKeys = false;
//                            }
//                        }
//                        if(checkKeys == true){
//                            System.out.print(" ");
//                        }
//                        
//                }
                //else{
                    //System.out.print(" ");
                //}          
                 
                // Opponents
                if (Opponents[row][col].getOpponent() > 0) {
                    System.out.print("O");
//                    rowOpponentContainer[numOpponents] = row;
//                    colOpponentContainer[numOpponents] = col;
//                    numOpponents++;
                }
                else
                {
                    System.out.print(" ");
                } 
                
                // Traps
                if (Traps[row][col].getTrap() > 0) {
                    System.out.print("Z");
//                    rowTrapContainer[numTraps] = row;
//                    colTrapContainer[numTraps] = col;
//                    numTraps++;
                }
                else
                {
                    System.out.print(" ");
                }                 
                
                if (store1[row][col].getStore() > 0) {
                    System.out.print("S");
//                    rowStoreContainer[numStores] = row;
//                    rowStoreContainer[numStores] = col;
//                    numStores++;
                }
                else
                {
                    System.out.print(" ");
                }        
                System.out.print(" ");
                
            }
            
            System.out.println("|");

            for (int i = 0; i < num_cols * 4; i++) {
                System.out.print("--");
            }
            
            System.out.println("-");
        
        }                   
    }
    
    public void loadBoard() {
        // Set Player Position

        // Initialize Rooms,Treasures,Opponent,Traps,Player,Store.
        for (int row = 0; row < num_rows;  row++) {
            for (int col = 0; col < num_cols; col++) {
                row_pos = row;
                col_pos = col;
                Board[row_pos][col_pos] = new Room();
                Treasures[row_pos][col_pos] = new Treasure();
                Opponents[row_pos][col_pos] = new Opponent();
                Traps[row_pos][col_pos] = new Trap();
                player1[row_pos][col_pos] = new Player();
                store1[row_pos][col_pos] = new Store();
            }            
        }
     
        
        // Initialize the board
        // Randomize Treasures.
        for(int i=0; i< ((num_rows+num_cols)/2*3/4);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            //int randomType = rand.nextInt(8);
            Treasures[rand_row][rand_col].setTreasure((num_rows+num_cols)/2*3/4); // Torch
            rowTreasureContainer[i] = rand_row;
            colTreasureContainer[i] = rand_col;
        }
        //if(player1[row_pos][col_pos] == Treasures[row_pos][col_pos]){
                        //System.out.print(" ");
                        //rowAddressContainer[storeAddressRow] = row_pos;
                        //storeAddressRow++;
                        //colAddressContainer[storeAddressCol] = col_pos;
                        //storeAddressCol++;
                        //for(int i=0; i<(((num_rows+num_cols)*3/4));i++){
                            //if (row_pos == rowAddressContainer[i]&& col_pos == colAddressContainer[i]){
                                //return true;
                            //}
                        //}
                        //return false;
                    //}
        
        // Randomize Traps.
        for(int i=0; i< ((num_rows+num_cols)/4);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            Traps[rand_row][rand_col].setTrap((num_rows+num_cols)/4); 
            rowTrapContainer[i] = rand_row;
            colTrapContainer[i] = rand_col;
        }

        // Randomize Opponents.
        for(int i=0; i< ((num_rows+num_cols)/4);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            Opponents[rand_row][rand_col].setOpponent((num_rows+num_cols)/4); 
            rowOpponentContainer[i] = rand_row;
            colOpponentContainer[i] = rand_col;
        }

        // Randomize stores.
        for(int i=0; i< ((num_rows+num_cols)/3);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            store1[rand_row][rand_col].setStore((num_rows+num_cols)/3); 
            rowStoreContainer[i] = rand_row;
            colStoreContainer[i] = rand_col;
        }
        
        //Directions
//        Board[0][0].moveRight = true;
//        Board[0][1].moveDown = true;
//        Board[1][1].moveDown = true;
//        Board[2][1].moveLeft = true;
    }
    
    public void getMove() {
        System.out.println("T for Treasure, Z for Trap, O for Opponent, S for Store and P for player.");
        System.out.print("Please enter your move (U-Up, D-Down, L-Left, R-Right, Q-Quit, T-Take, F-Fight, I-Show Inventory): ");
        
        move = input.next(".").charAt(0);
        move = Character.toUpperCase(move);
        //testing:show keys in the Inventory.
//        for(int i=0; i< Inventory.length;i++){
//            if(Inventory[i]!=0){
//            System.out.println(Inventory[i]);}
//            if(Inventory[i]!=0){
//            System.out.print("");
//            }
        //}

        //System.out.println(player1[row_pos][col_pos].getRow_pos());
        //System.out.println(player1[row_pos][col_pos].getCol_pos());
        //System.out.println(Treasures[row_pos][col_pos].getRow_pos());
        //System.out.println(Treasures[row_pos][col_pos].getCol_pos());
    }
    
//    public Boolean isInArray (int arr[], int size, int key) {
//        for(int i=0; i<(size);i++){
//            if (key == arr[i]){
//                return true;
//            }
//        }
//        return false;
//    }
    
    public Boolean validMove(char direction) {
        Boolean isValid = false;
        
        if (direction == 'U' && player1[row_pos][col_pos].getRow_pos() > 0 && Board[row_pos][col_pos].moveUp) {
            isValid = true;
        }
        
        if (direction == 'D' && player1[row_pos][col_pos].getRow_pos() < num_rows - 1 && Board[row_pos][col_pos].moveDown) {
            isValid = true;
        }

        if (direction == 'L' && player1[row_pos][col_pos].getCol_pos() > 0&& Board[row_pos][col_pos].moveLeft) {
            isValid = true;
        }

        if (direction == 'R' && player1[row_pos][col_pos].getCol_pos() < num_cols - 1 && Board[row_pos][col_pos].moveRight) {
            isValid = true;
        }
        
        if (direction == 'I') {
            
            System.out.println("Showing Inventory:");
            
            if (numInventory > 0) {
                for (int i = 0; i < numInventory; i++) {
                    System.out.println(i + " - " + Treasures[row_pos][col_pos].showTreasure(Inventory[i]));
                }
            }
            else
            {
                System.out.println("There is no inventory.");
            }
            
            isValid = true;
        }        
        //if(direction == 'W'){System.out.println(Treasures[row_pos][col_pos].getTreasure());}
        if (direction == 'T') {
            if (Treasures[player1[row_pos][col_pos].getRow_pos()][player1[row_pos][col_pos].getCol_pos()].getTreasure() > 0){
                    //isInArray(rowTreasureContainer,numTreasures,player1[row_pos][col_pos].getRow_pos())&&
                    //isInArray(colTreasureContainer,numTreasures,player1[row_pos][col_pos].getCol_pos())) {
                // Take the Treasure
                int randomType = rand.nextInt(8);
                addInventory(randomType+1);                
            }
            else
            {
                System.out.println("There is no Treasure in this room.");
            }
        
            isValid = true;
            //System.out.println(  " - " + Treasures[row_pos][col_pos].showTreasure(2));
        }            
            
        if (direction == 'Q') {
            isValid = true;
        }
        
        if (direction == 'F') {
            int randMonster = rand.nextInt(8);
            //Opponents[player1[row_pos][col_pos].getRow_pos()][player1[row_pos][col_pos].getCol_pos()].setOpponent(randMonster+1);
            if (Opponents[player1[row_pos][col_pos].getRow_pos()][player1[row_pos][col_pos].getCol_pos()].getOpponent() > 0) {
                // Fighting The Opponent
                System.out.println("Fighting the " + Opponents[row_pos][col_pos].showOpponent(randMonster+1));
                
                // Must have a sword and a shield
                if (searchInventory(2) && searchInventory(6) ) {
                    System.out.println("You have defeated the " + Opponents[player1[row_pos][col_pos].getRow_pos()]
                            [player1[row_pos][col_pos].getCol_pos()]
                            .showOpponent(Opponents[row_pos][col_pos].getOpponent()));
                }
                else
                {
                    System.out.println("You have been defeated by the " + Opponents[row_pos][col_pos].showOpponent(randMonster+1));
                    System.out.println("Game Over");
                    gameOver = true;
                }
                            
            }
            else
            {
                System.out.println("There is no Opponent in this room.");
            }            
            
            isValid = true;
        }        
        
        
        return isValid;
    }
    
    public void addInventory(int type) {
        int randomType = rand.nextInt(8);
        type = randomType;
        System.out.println("Taking the Treasure "  + Treasures[player1[row_pos][col_pos].getRow_pos()]
                [player1[row_pos][col_pos].getCol_pos()].showTreasure(randomType+1) + ".");
        
        Inventory[numInventory] = randomType+1;
        numInventory++;
        //Random rand = new Random();
        //int randint = rand.nextInt(7);
        //Treasures[row_pos][col_pos].setTreasure(randint+1);//Randomize treasure from type 1 to type 8.
    }
    
    
    public Boolean searchInventory(int type) {
        Boolean blnResult = false;
        for (int i = 0; i < numInventory; i++) {
            if (Inventory[i] == type) {
                System.out.println(Treasures[row_pos][col_pos].showTreasure(Inventory[i]));
                blnResult = true;
            }
        }               
        
        return blnResult;
    }
    
    public void playGame() {
        // Initialze the Maze
        //loadBoard();
        Scanner myObj = new Scanner(System.in);
        char playAgain = 'y';
        
        while(gameOver == false){
            loadBoard();
        //do{
        // Play the game        
            do {
                // Draw the maze
                drawBoard();
               
                // Get the player's move
                getMove();
                
                // Validate the move and move accordingly
                if (validMove(move)) {
                
                  // Move the Player   
                  if (move == 'U') {
                      player1[row_pos][col_pos].moveUp();
                  }
              
                  if (move == 'D') {
                      player1[row_pos][col_pos].moveDown();
                  }
                
                  if (move == 'L') {
                      player1[row_pos][col_pos].moveLeft();
                  }

                  if (move == 'R') {
                      player1[row_pos][col_pos].moveRight();
                  }
                  
                  if(move == 'U'&&move == 'D'&&move == 'L'&&move == 'R'&&move == 'I'&&move == 'T'&&move == 'Q'&&move == 'F'){
                      System.out.println("Invalid move: Please try again.");
                  }
                } 
                } while (!gameOver && move != 'Q');
            System.out.println("Do you want to play again? Type y or something else.");
            playAgain = input.next(".").charAt(0);
            playAgain = Character.toUpperCase(move);
            //Somehow when the player enter y for playAgain, it returns F for playAgain.
            if(playAgain == 'F'){gameOver = false;}
        }
        System.out.println("Thank you for playing our Maze game.");
    }
    
}

// Here's what I have done:
// created several classes, changed 2D arrays to classes.
// fixed some issues while changing 2D arrays to classes.
// fixed the issue with the truesure class, the player was not able to find the treasure, and the treasure was shown in a spot without "T".
// Work on the opponent setting, can not work correctly so far. The player is unable to correctly determine whether the opponent exist in the spot.
// fix the re-play issue,. The player will enter y to play again when the game restart, and the player will return to (0,0) and see a new board.


// Here's some issue I need to fix. Move them to the "Here's what I have done:" list once it's fixed.

// fix InputMismatchException, the player receives the InputMismatchException when inputing invalid inputs..
// store the location of treasure, get rid of T in Maze when the player takes the treasure.
// Do the same thing about other three objects like how you did it with treasure.
