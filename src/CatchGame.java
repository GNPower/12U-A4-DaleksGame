
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    //An arrayList to stre the daleks in
    ArrayList<Dalek> daleks = new ArrayList<Dalek>();
    //a bards and doctor object
    Board b;
    Doctor d;

    /**
     * The constructor to set all the initial positions of the daleks and doctor
     * as well as the width and height of the board
     * @param dalekNum the number of daleks initially in the game
     * @param boardX the width of the board
     * @param boardY the height of the board
     */
    public CatchGame(int dalekNum, int boardX, int boardY) {
        //creates the board object using the width and height passed in
        b = new Board(boardX, boardY);
        //for loops runs te amount of times as there are daleks, dalekNum times.
        for (int i = 0; i < dalekNum; i++) {
            //adds a new dalek to the arraylist of daleks, at a random spot on the board
            daleks.add(new Dalek((int) (Math.random() * boardX), (int) (Math.random() * boardY)));
        }
        //adds a new doctor to a random spot on the borad
        d = new Doctor((int) (Math.random() * boardX), (int) (Math.random() * boardY));
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //calls the moveDoctor method, to move the doctor to a new spot on the board
        moveDoctor();
        //calls the moveDalek method, to move all the daleks to new spots on the board
        moveDaleks();
        //calls the renderScene method, displays all the new positions on the board
        renderScene();
    }

    /**
     * The method called to put all the pegs back onto the board once every piece has moved
     */
    public void renderScene() {
        //for loop to run through every dalek once
        for (Dalek dalek : daleks) {
            //if the dalek has not crashed place a black peg at their spot
            if (!dalek.hasCrashed()) {
                b.putPeg(Color.BLACK, dalek.getRow(), dalek.getCol());
            //if the dalek has crashed put a red peg at their position
            } else {
                b.putPeg(Color.RED, dalek.getRow(), dalek.getCol());
            }

        }
        //put a green peg at the doctors position
        b.putPeg(Color.GREEN, d.getRow(), d.getCol());
    }

    /**
     * method called to move the doctor to a new spot on the board. Get the players click
     * and passes the row and column the player clicked on to the doctors move method
     */
    public void moveDoctor() {
        //gets the square the player clicked on
        Coordinate c = b.getClick();
        //stores the row and column of the square in variables
        int row = c.getRow();
        int col = c.getCol();
        //removes the doctors old peg before moving him to a new square
        b.removePeg(d.getRow(), d.getCol());
        //call the doctors move method and passes in the row and colummn the player clicked on
        d.move(row, col);
    }

    /**
     * method called to move all the daleks to their new positions on the board
     */
    public void moveDaleks() {
        //for loops to run through every dalek
        for (Dalek dalek : daleks) {
            //if the dalek hasent crashed
            if (!dalek.hasCrashed()) {
                //removes the daleks old peg before moving it to its new position
                b.removePeg(dalek.getRow(), dalek.getCol());
                //calls the daleks move method and passes the doctor
                dalek.advanceTowards(d);
            }
            //calls the method to check all daleks if they have crashed
            checkDaleksForCrash();
        }
    }

    /**
     * Checks every dalek with every other dalek to see if any of them have crashed
     * with each other, and if they have sets both the crashed daleks hasCrashed 
     * variables to true.
     */
    private void checkDaleksForCrash() {
        //for loop to run through every dalek
        for (int i = 0; i < daleks.size(); i++) {
            //for loop to run through every dalek ahead of the dalek in the earlier for loops position
            for (int j = i + 1; j < daleks.size(); j++) {
                //checks the two daleks together to see if they have crashed
                //done by calling the checkCrash method in the Dalek class
                daleks.get(i).checkCrash(daleks.get(j));
            }
        }
    }

    /**
     * checks if the game has ended by either the doctor being caught or if
     * all the daleks crashed.
     * @return true if the game is not over, false if the game is over
     */
    public boolean checkGameOver() {
        //checks if either methods called in the if statement return true
        if (checkForDoctorCrach() || checkWin()) {
            //returns false, the game is over
            return false;
        }
        //if neither methods 
        return true;
    }

    public boolean checkForDoctorCrach() {
        return d.checkCrash(daleks);
    }

    public boolean checkWin() {
        int daleksCrashed = 0;
        for (Dalek dalek : daleks) {
            if (dalek.hasCrashed() == true) {
                daleksCrashed++;
            }
        }
        if (daleksCrashed == daleks.size()) {
            return true;
        }
        return false;
    }

    public void endGame(boolean win) {
        if (!win) {
            b.removePeg(d.getRow(), d.getCol());
            b.putPeg(Color.YELLOW, d.getRow(), d.getCol());
            b.displayMessage("Game Over! The Doctor Was Caught!");
        } else {
            b.displayMessage("The Doctor Has Won!");
        }
    }
}
