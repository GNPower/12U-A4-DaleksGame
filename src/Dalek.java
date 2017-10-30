
import java.util.ArrayList;

/**
 * This class models a Delek in the game. A Delek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    //variables to hold the row and column of the dalek
    private int row, col;
    //boelean to hold whether the dalek has crashed or not
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        //sets the row and column of the dalek to the row and column passed in
        this.row = theRow;
        this.col = theCol;
        //by default the dalek has not crashed
        this.hasCrashed = false;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        //only moves the dalek if it has not crashed
        if (!hasCrashed) {
            //gets the row and column of the doctor
            int dRow = doc.getRow();
            int dCol = doc.getCol();
            //if the daleks row is larger than the doctors row move the dalek left
            if (row > dRow) {
                row--;
            //if the daleks row is smaller than the doctors row move the dalek right
            } else if (row < dRow) {
                row++;
            }
            //if the daleks column is larger than the doctors column move the dalek up
            if (col > dCol) {
                col--;
            //if the daleks column is smaller than the doctors column move the dalek down
            } else if (col < dCol) {
                col++;
            }
            //if the daleks column or row are equal to the doctors, it does not move in that direction
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        hasCrashed = true;        
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        return this.hasCrashed;
    }
    
    /**
     * Checks the row and column of this dalek and the dalek passed in,
     * if they are both he same (i.e. they have crashed into one another), 
     * it crashes both daleks.
     * @param d the dalek it is checking if it has crashed with
     */
    public void checkCrash(Dalek d){
        //checks if the row and column of both daleks are the same
        if(this.row == d.row && this.col == d.col){
            //if they are it crashes both daleks
            crash();
            d.crash();
        }
    }
}
