
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author poweg9141
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void notmain(String[] args) {
        //new board object
        Board b = new Board(8, 8);
        //put a peg
        b.putPeg(Color.GREEN, 3, 5);
        //remove a peg
        b.removePeg(3, 5);
        //set a message
        b.displayMessage("Hello There");
        //get a click
        while (true) {
            Coordinate click = b.getClick();
            int col = click.getCol();
            int row = click.getRow();
            b.putPeg(Color.BLACK, row, col);

        }
    }
}
