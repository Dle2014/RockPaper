/**
 * Created by David Lopez on 16/02/2016.
 **/

import java.util.Random;


public final class RockPaperScissors {

    /**
     * Static values used in the game
     */
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;

    /**
     * General vars used in the game
     */
    private static int user1Wins = 0;
    private static int user2Wins = 0;
    private static int draws = 0;

    /**
     * Show the results of the game
     */
    private static void showResults() {
        System.out.println("\nFinal Results :");
        System.out.println("\nThe user 2 wins :" + getUser2Wins());
        System.out.println("\nThe user 1 wins :" + getUser1Wins());
        System.out.println("\nThe draws are :" + getDraws());
    }

    /**
     * Get Wins from user1
     *
     * @return
     */
    public static int getUser1Wins() {
        return user1Wins;
    }

    /**
     * Get Wins from user2
     *
     * @return
     */
    public static int getUser2Wins() {
        return user2Wins;
    }

    /**
     * Get draws
     *
     * @return
     */
    public static int getDraws() {
        return draws;
    }

    /**
     * Method to return a random option
     *
     * @return
     */
    public static int getRandomResult() {
        Random random = new Random();
        return random.nextInt(3);
    }

    /**
     * Method to return ROCK option
     *
     * @return
     */
    public static int getRock() {
        return ROCK;
    }

    /**
     * Method to evaluate the winner of the round
     *
     * @param user1Choice
     * @param user2Choice
     * @return
     */
    public static Boolean isUser1Winer(Integer user1Choice, Integer user2Choice) {
        if (user1Choice == ROCK && user2Choice == SCISSORS || user1Choice == PAPER && user2Choice == ROCK || user1Choice == SCISSORS && user2Choice == PAPER) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to evaluate and to the counter the result of the round
     *
     * @param user1Choice
     * @param user2Choice
     */
    public static void checkResults(Integer user1Choice, Integer user2Choice) {

        if (user1Choice == user2Choice) {
            System.out.println("Draw");
            draws++;
        } else if (isUser1Winer(user1Choice, user2Choice)) {
            System.out.println("\nThe user 1 wins!");
            user1Wins++;
        } else {
            System.out.println("\nThe user 2 wins!");
            user2Wins++;
        }
    }

    /**
     * Method to start the game with the iterations
     */
    private static void play() {
        int round = 0;
        System.out.println("\n The game start \n");
        while (round < 100) {
            round++;
            /* Randomly generate user1 choice */
            final int user1Choice = getRandomResult();
            System.out.println("\n User 1 choice was \n" + CHOICES[user1Choice]);
            /* User 2 always choose Rock */
            final int user2Choice = getRock();
            System.out.println("\n User 2 choice was \n" + CHOICES[user2Choice]);
            checkResults(user1Choice, user2Choice);
        }
        showResults();
    }

    /**
     * Default method to check and play the game
     *
     * @param argv
     */
    public static void main(final String[] argv) {
        play();
    }
}
