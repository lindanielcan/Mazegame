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
// Test
import static java.lang.Math.abs;
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
    protected Store[][] Stores; // S = Store
    protected Player player = new Player();
    
    protected int[] Inventory = new int[100];
    public int numInventory;
    
    public Boolean gameOver = false;
            

    
    //protected int[][] Player = new int[NUM_ROWS][NUM_COLS];
    
    private int row_pos;
    private int col_pos;
    private char move;
    

    public Maze(int max_rows, int max_cols) {
        
        num_rows = max_rows;
        num_cols = max_cols;
        
        Board = new Room[num_rows][num_cols];
        Treasures = new Treasure[num_rows][num_cols]; // T = Treasure
        Opponents = new Opponent[num_rows][num_cols]; // O = Opponent
        Traps = new Trap[num_rows][num_cols];     // Z = Trap
        Stores = new Store[num_rows][num_cols]; // S = Store
        numInventory = 0;
    }
    
    public void generateMaze() {
        int currentRow = 0;
        int currentCol = 0;
        
        while ((Board[num_rows-1][num_cols-1].validDirections & 1<<4) != 1<<4) {
            Set<Integer> validDirections = new HashSet<>();
            
            // Up
            if ((Board[currentRow][currentCol].validDirections & 1<<3) == 1<<3)
                validDirections.add(0);
                 
            // Down
            if ((Board[currentRow][currentCol].validDirections & 1<<2) == 1<<2)
                validDirections.add(1);
            
            // Right
            if ((Board[currentRow][currentCol].validDirections & 1<<1) == 1<<1)
                validDirections.add(2);
            
            // Left
            if ((Board[currentRow][currentCol].validDirections & 1) == 1)
                validDirections.add(3);
            
            
            int randomDirection = new Random().nextInt(validDirections.size());
            
            int i = 0;
            int direction = -1;
            for (Object obj : validDirections) {
                if (i==randomDirection)
                    direction = (int) obj;
                ++i;
            }
            
            Room temp;
            switch (direction) {
                case 0:
                    temp = Board[currentRow-1][currentCol];
                    temp.validDirections &= ~(1<<2);
                    Board[currentRow][currentCol].enableMove(0);
                    temp.enableMove(1);
                    currentRow -= 1;
                    break;
                case 1:
                    temp = Board[currentRow+1][currentCol];
                    temp.validDirections &= ~(1<<3);
                    Board[currentRow][currentCol].enableMove(1);
                    temp.enableMove(0);
                    currentRow += 1;
                    break;
                case 2:
                    temp = Board[currentRow][currentCol+1];
                    temp.validDirections &= ~(1);
                    Board[currentRow][currentCol].enableMove(2);
                    temp.enableMove(3);
                    currentCol += 1;
                    break;
                case 3:
                    temp = Board[currentRow][currentCol-1];
                    temp.validDirections &= ~(1<<1);
                    Board[currentRow][currentCol].enableMove(3);
                    temp.enableMove(2);
                    currentCol -= 1;
                    break;
            }
            
            Board[currentRow][currentCol].validDirections |= 1<<4;
        }
    }
    
    public void drawBoard() {
        col_pos = player.getCol_pos();
        row_pos = player.getRow_pos();
       
        for (int i = 0; i < num_cols * 4 ; i++) {
            System.out.print("--");
        }
        
        System.out.println("-");
        
        System.out.print("|");
        // Outer loop to print rows.
        for (int row = 0; row < num_rows; row++) {
            
            // Inner loop to print columns
            for (int col = 0; col < num_cols; col++) {
                
                
                // Player
                if (row == row_pos && col == col_pos) {
                    System.out.print("P");
                } else {
                    System.out.print(" ");
                }           
                
                // Display blackness unless player is close:
                if (abs(row-row_pos) < 2 && abs(col-col_pos) < 2) {
                    // Tresures
                    if (Treasures[row][col].getTreasure() > 0) {
                        System.out.print("T");
                    } else {
                        System.out.print(" ");
                    }     

                    // Opponents
                    if (Opponents[row][col].getOpponent() > 0) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    } 

                    // Traps
                    if (Traps[row][col].getTrap() > 0) {
                        System.out.print("Z");
                    } else {
                        System.out.print(" ");
                    }                 

                    // Stores
                    if (Stores[row][col].getStore() > 0) {
                        System.out.print("S");
                    } else {
                        System.out.print(" ");
                    } 

                    System.out.print(" ");
                } else {
                    System.out.print("████ ");
                }
                
                if (!Board[row][col].moveRight || !(abs(row-row_pos) < 2 && abs(col-col_pos) < 2))
                    System.out.print(" |");
                else {
                    System.out.print("  ");
                }
                
            }
            
            System.out.println("");
            
            for (int i = 0; i < num_cols; i++) {
                if (!Board[row][i].moveDown || !(abs(row-row_pos) < 2 && abs(i-col_pos) < 2))
                    System.out.print("--------");
                else
                    System.out.print("        ");
            }
            
            System.out.println("-");
            
            System.out.print(row==num_rows-1 ? "" : "|");
        }                   
    }
    
    public void loadBoard() {
        
        // Initialize Rooms,Treasures,Opponent,Traps,Player,Store.
        for (int row = 0; row < num_rows;  row++) {
            for (int col = 0; col < num_cols; col++) {
                Board[row][col] = new Room();
                Treasures[row][col] = new Treasure();
                Opponents[row][col] = new Opponent();
                Traps[row][col] = new Trap();
                Stores[row][col] = new Store();
            }            
        }
        
        for (int row = 0; row < num_rows;  row++) {
            for (int col = 0; col < num_cols; col++) {
                if (row > 0)
                    Board[row][col].validDirections |= 1<<3;
                
                if (row < num_rows-1)
                    Board[row][col].validDirections |= 1<<2;
                
                if (col > 0)
                    Board[row][col].validDirections |= 1;
                
                if (col < num_cols-1)
                    Board[row][col].validDirections |= 1<<1;
            }
        }
     
        
        // Initialize the board
        generateMaze();
        // Randomize Treasures.
        for(int i=0; i < ((num_rows+num_cols)/2*3/4); i++) {
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            int randomType = rand.nextInt(8);
            Treasures[rand_row][rand_col].setTreasure(randomType+1); // Torch
        }
        
        // Randomize Traps.
        for(int i=0; i< ((num_rows+num_cols)/4);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            Traps[rand_row][rand_col].setTrap((num_rows+num_cols)/4);
        }

        // Randomize Opponents.
        for(int i=0; i< ((num_rows+num_cols)/4);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            Opponents[rand_row][rand_col].setOpponent((num_rows+num_cols)/4);
        }

        // Randomize stores.
        for(int i=0; i< ((num_rows+num_cols)/3);i++){
            int rand_row = rand.nextInt(num_rows); 
            int rand_col = rand.nextInt(num_cols); 
            Stores[rand_row][rand_col].setStore((num_rows+num_cols)/3);
        }
        
    }
    
    public void getMove() {
        System.out.println("T for Treasure, Z for Trap, O for Opponent, S for Store and P for player.");
        System.out.print("Please enter your move (U-Up, D-Down, L-Left, R-Right, Q-Quit, T-Take, F-Fight, I-Show Inventory): ");
        
        move = input.next(".").charAt(0);
        move = Character.toUpperCase(move);
        
    }
    
    public Boolean validMove(char direction) {
        Boolean isValid = false;
        
        if (direction == 'U' && Board[player.getRow_pos()][player.getCol_pos()].moveUp) {
            isValid = true;
        }
        
        if (direction == 'D' && Board[player.getRow_pos()][player.getCol_pos()].moveDown) {
            isValid = true;
        }

        if (direction == 'L' && Board[player.getRow_pos()][player.getCol_pos()].moveLeft) {
            isValid = true;
        }

        if (direction == 'R' && Board[player.getRow_pos()][player.getCol_pos()].moveRight) {
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
        
        if (direction == 'T') {
            if (Treasures[player.getRow_pos()][player.getCol_pos()].getTreasure() > 0) {
                
                addInventory(Treasures[player.getRow_pos()][player.getCol_pos()].getTreasure());
            }
            else
            {
                System.out.println("There is no Treasure in this room.");
            }
        
            isValid = true;
        }            
            
        if (direction == 'Q') {
            isValid = true;
            gameOver = true;
            
        }
        
        if (direction == 'F') {
            int randMonster = rand.nextInt(8);
            //Opponents[player1[row_pos][col_pos].getRow_pos()][player1[row_pos][col_pos].getCol_pos()].setOpponent(randMonster+1);
            if (Opponents[row_pos][col_pos].getOpponent() > 0) {
                // Fighting The Opponent
                System.out.println("Fighting the " + Opponents[row_pos][col_pos].showOpponent(randMonster+1));
                
                // Must have a sword and a shield
                if (searchInventory(2) && searchInventory(6) ) {
                    System.out.println("You have defeated the " + Opponents[row_pos][col_pos].showOpponent(Opponents[row_pos][col_pos].getOpponent()));
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
        System.out.println("Taking the Treasure "  + Treasures[row_pos][col_pos].showTreasure(Treasures[row_pos][col_pos].getTreasure()) + ".");
        
        Inventory[numInventory] = Treasures[row_pos][col_pos].getTreasure();
        numInventory++;
        
        Treasures[row_pos][col_pos].setTreasure(0);
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
    
    public void checkBoard() {
        if (Treasures[player.getRow_pos()][player.getCol_pos()].getTreasure() > 0) {
            System.out.println("You have found a " + Treasures[0][0].showTreasure(Treasures[player.getRow_pos()][player.getCol_pos()].getTreasure()));
        }
    }
    
    public void playGame() {
        loadBoard();
           
        do {
            // Draw the maze
            drawBoard();
            
            // Check to see if the player encountered anything
            checkBoard();

            // Get the player's move
            getMove();

            // Validate the move and move accordingly
            if (validMove(move)) {

              // Move the Player   
              if (move == 'U') {
                  player.moveUp();
              }

              if (move == 'D') {
                  player.moveDown();
              }

              if (move == 'L') {
                  player.moveLeft();
              }

              if (move == 'R') {
                  player.moveRight();
              }
            } else {
                System.out.println("That is not a valid move.");
            }

        } while (!gameOver && move != 'Q');
        
        System.out.println("Thank you for playing our Maze game.");
    }
    
}

// TODO: Move this to GitHub
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
