
import java.awt.Color;


/** This class creates a game and starts the game play.
 */
public class MainGame {

    public static void main(String args[]) {
        //create a new game with the peramiters
        //number of daleks - 3
        //board width - 12
        //board height - 12
        CatchGame game = new CatchGame(3, 12, 12);
        //renders the initial scene of the game
        game.renderScene();
        //sets whether the game is still running, true by default
        boolean running = true;
        //sets whether the player has won or lost when the game ends, lost by default
        boolean endState = false;
        //main loop to run the game
        while(running){
            //calls the playgame method in the CatchGame class
            //this method deals with all game logic
            game.playGame();
            //checks whether the game has ended for any reason and updates the boolean accordingly
            running = game.checkGameOver();
            //checks whether the player has won or lost and updates the boolean accordingly
            //if the game is not over boolean deafults to lost
            endState = game.checkWin();
        }
        //calls the end game method which ends the game according to whether the player won or not
        game.endGame(endState);        
    }

}
