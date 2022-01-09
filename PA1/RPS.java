/**
 * Name: Lehan Xiang
 * ID: A16528297
 * Email: lxiang@ucsd.edu
 * Sources used: None
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the main function of the RPS project.
 */

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.SourceDataLine;

/**
 * Sub class of RPSAbstract.
 */
public class RPS extends RPSAbstract {
    
    /**
     * This method sets moves for the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove)
    {

        // Checking invalid input.
        if (!isValidMove(playerMove)) {
            System.out.println(INVALID_INPUT);
                return INVALID_INPUT_OUTCOME;
            }

        // Checking if the game is a draw.
        if (playerMove.equals(cpuMove)) {
            return TIE_OUTCOME;
        }

        // Checking if the player wins.
        else if (playerMove.equals(DEFAULT_MOVES[2]) 
                    && cpuMove.equals(DEFAULT_MOVES[0])) {
            return PLAYER_WIN_OUTCOME;
        }
        else if (playerMove.equals(DEFAULT_MOVES[0]) 
                    && cpuMove.equals(DEFAULT_MOVES[1])) {
            return PLAYER_WIN_OUTCOME;
        }
        else if (playerMove.equals(DEFAULT_MOVES[1]) 
                    && cpuMove.equals(DEFAULT_MOVES[2])) {
            return PLAYER_WIN_OUTCOME;
        }

        // Checking if the cpu wins.
        else {
            return CPU_WIN_OUTCOME;
        }

    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }

        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
        System.out.println("Game not yet implemented.");

        // String object which will store player's move
        String playermove;

        // Prints the promt.
        System.out.println(PROMPT_MOVE);

        // Reads in player's move.
        playermove = in.nextLine();

        // As long as player doesn't type "q" the gamne will not end.
        while (!playermove.equals(QUIT)) {
            // Generats cpu's move and put it into cpuMove.
            String cpuMove = game.genCPUMove();
            // Play the game.
            game.play(playermove, cpuMove);
            // Asking user's input.
            System.out.println(PROMPT_MOVE);
            // Storing user's input.
            playermove = in.nextLine();
        }

        // Game over.
        game.end();

        in.close();
    }
}
