
import java.util.ArrayList;


/** This class models the Doctor in the game. A Doctor has
 *  a position and can move to a new position.
 */
public class Doctor {

    //variables to hold the x and y position of the doctor on the board
    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        //sets the passed in coloumn and row to the doctors column and row
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //gets the absolute value of the difference between the doctors column 
        //and row and the column and row the player clicked on
        int dRow = Math.abs(row - newRow);
        int dCol = Math.abs(col - newCol);
        //if the absolute value is less than or equal to 1, move the doctor to where the player clicked
        if(dRow <= 1 && dCol <= 1){
            this.row = newRow;
            this.col = newCol;
        //if the player clicked somewhere other than right beside the doctor the doctor telepors randomly
        }else{
            this.row = (int)(Math.random() * 12);
            this.col = (int)(Math.random() * 12);    
            System.out.println("Go Go Gadget, Teleporting Egg!");
        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;
    }
    
    /**
     * Runs through the list of all the daleks in the game and checks if 
     * they are at the same position as the doctor. If any one of them are this
     * method returns true because the daleks have caught the doctor, if all of 
     * the daleks are at different positions this method returns false because 
     * the doctor has not yet been caught
     * @param daleks the arrayList of all the daleks in the game
     * @return true if the doctors been caught, false if not
     */
    public boolean checkCrash(ArrayList<Dalek> daleks){
        //for loops to run through the list of daleks
        for(Dalek dalek:daleks){
            //if the dalek is at the same row And coloumn aas the doctor
            if(this.row == dalek.getRow() && this.col == dalek.getCol()){
                //return true, the doctor has been caught
                return true;
            }
        }
        //if all daleks are in different positions, return false
        return false;
    }

}
