/*
 * Assignment 04
 * Description: [Part 2 of 2] Dice value tracker
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Random;
import java.util.Scanner;

public class Dice {

    private static final int DICE_FACES = 6;
    private static final int MIN_ROLLS = 1;
    private static final int MAX_ROLLS = 1000000;

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        Scanner scan = new Scanner(System.in);
        int nThrows = promptRolls(scan);

    }

    /**
     * Prompt the user to enter number of throws they would like to perform. The
     * prompt will continue until the user enters a value within the valid
     * bounds (MIN_ROLLS <= t <= MAX_ROLLS).
     *
     * @param scan The `Scanner` object to use.
     * @return The valid number of throws.
     */
    private static int promptRolls(Scanner scan) {
        int t;
        do {
            System.out.printf("Enter the number of throws between %,d to %,d inclusive.%n", MIN_ROLLS, MAX_ROLLS);
            System.out.print("Or enter 0 to quit: ");
            t = scan.nextInt();
        } while (t < MIN_ROLLS || t > MAX_ROLLS);
        return t;
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

    private static void displayRollFreq() {

    }
}
