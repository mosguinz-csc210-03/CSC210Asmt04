/*
 * Assignment 04
 * Description: [Part 2 of 2] Dice value tracker
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    private static final int DICE_FACES = 6;
    private static final int MIN_ROLLS = 1;
    private static final int MAX_ROLLS = 1000000;

    public static void main(String[] args) {
        loop();
    }

    /**
     * Run the execution loop.
     */
    public static void loop() {
        Scanner scan = new Scanner(System.in);
        int nRolls = promptRolls(scan);
        if (nRolls == -1) return;
        displayRollFreq(nRolls);

    }

    /**
     * Prompt the user to enter number of throws they would like to perform. The
     * prompt will continue until the user enters a value within the valid
     * bounds (MIN_ROLLS <= t <= MAX_ROLLS) or a sentinel value (0).
     *
     * @param scan The `Scanner` object to use.
     * @return The valid number of rolls or -1 if the user terminates the
     * program.
     */
    private static int promptRolls(Scanner scan) {
        int rolls;
        do {
            System.out.printf("Enter the number of throws between %,d to %,d inclusive.%n", MIN_ROLLS, MAX_ROLLS);
            System.out.print("Or enter 0 to quit: ");
            rolls = scan.nextInt();

            if (rolls == 0) {
                System.out.println("Thank you for playing my Dice Probability Program");
                return -1;
            }
        } while (rolls < MIN_ROLLS || rolls > MAX_ROLLS);
        return rolls;
    }

    /**
     * Roll the dice. Returns the rolled dice value from 1 to DICE_FACES,
     * inclusive.
     *
     * @return The rolled value.
     */
    private static int rollDice() {
        return new Random().nextInt(DICE_FACES) + 1;
    }

    /**
     * Display the roll frequency for each faces of a dice, given the number of
     * rolls.
     * <p>
     * For each roll, the method will print the roll result and the cumulative
     * occurrences of all faces.
     * <p>
     * At the end, it will display the "average probability" of each face. With
     * the sufficient number of given rolls, this value should be roughly
     * equivalent to 1 / DICE_FACES.
     *
     * @param nRolls The number of rolls.
     */
    private static void displayRollFreq(int nRolls) {
        int roll;
        int[] rollCount = new int[DICE_FACES];

        /* Roll the dice `nRolls` times and keep track of each occurrences. */
        for (int i = 0; i < nRolls; i++) {
            roll = rollDice();
            rollCount[roll - 1] += 1;

            System.out.printf("Rolled: %d%n", roll);
            System.out.println(Arrays.toString(rollCount));
        }

        /* Sum up the probability of each value occurrence. */
        double pSum = 0;
        for (double occurrence : rollCount) pSum += occurrence / nRolls;

        /* Then divide the sum by the number of faces to get the mean value. */
        System.out.printf("Average probability is: %.3f%n", pSum / DICE_FACES);
    }
}
