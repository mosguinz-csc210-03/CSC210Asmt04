/*
 * Assignment 04
 * Description: [Part 1 of 2] BMI using methods
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.io.PrintStream;
import java.util.Scanner;

public class BmiMethods {

    /* Carat line width for pro version, per ASMT 03 (1)(5) specification. */
    private static final int LINE_WIDTH = 63;

    public static void main(String[] args) {
        bmiPro();
    }

    /**
     * Contains execution loop for the standard BMI calculator.
     * <p>
     * See also: https://github.com/mosguinz-csc210-03/CSC210Asmt01/blob/master/src/BMI.java
     */
    public static void bmiStd() {
        printHeaderStd();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Input prompts for height (in feet and inches, separately). */
        System.out.println("Please enter your height in feet and inches (press Enter after each number)");
        System.out.print("Feet: ");

        /* Scan and store the user's input for height in feet. */
        int heightFt = scan.nextInt();
        System.out.print("Inches: ");

        /* Scan and store the user's input for height in inches. */
        int heightIn = scan.nextInt();
        PrintStream printf = System.out.printf("Your height: %d'%d\"", heightFt, heightIn);

        /* Input prompt for weight. */
        System.out.print("\n\nPlease enter your weight in pounds: ");
        double weight = scan.nextDouble();

        /* Format and print output to 2 decimal places. */
        System.out.printf("Your weight: %.2f lbs", weight);
        System.out.printf("\n\n>>> Your BMI is: %.2f", calculateBMI(weight, heightFt * 12 + heightIn));
    }

    /**
     * Contains execution loop for the BMI table calculator.
     * <p>
     * See also: https://github.com/mosguinz-csc210-03/CSC210Asmt03/blob/master/src/TableBmi.java
     */
    public static void bmiPro() {
        printHeaderPro();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Input prompts for height (in feet and inches, split on first whitespace) */
        System.out.print("Enter height in feet and inches: ");
        int height = scan.nextInt() * 12 + scan.nextInt();

        /* Input prompts for min and max weights. */
        System.out.print("Enter the low weight in pounds: ");
        double weightMin = scan.nextDouble();
        System.out.print("Enter the high weight in pounds: ");
        double weightMax = scan.nextDouble();

        /* Display the table and print termination message. */
        displayTable(height, weightMax, weightMin);
        System.out.println('\n' + "^".repeat(LINE_WIDTH));
        System.out.println("^    Thank you for using my program.");
        System.out.println("^".repeat(LINE_WIDTH));
    }

    /**
     * Calculate the BMI from the given weight and height.
     *
     * @param weight Weight in pounds.
     * @param height Height in inches.
     * @return The BMI value (lbs/in^2).
     */
    private static double calculateBMI(double weight, double height) {
        return 703 * weight / (height * height);
    }

    /**
     * Print the program welcome header for the standard version, according to
     * the specifications defined in Assessment 01 under (3)(a).
     */
    private static void printHeaderStd() {
        System.out.println("============================");
        System.out.println("Welcome to my BMI calculator");
        System.out.println("============================");
    }

    /**
     * Print the program header for the pro version. Made to be identical to the
     * example per requirement in Assessment 03 under (1)(5).
     */
    private static void printHeaderPro() {
        System.out.println("^".repeat(LINE_WIDTH));
        System.out.println("^ Welcome to:");
        System.out.println("^    BODY MASS INDEX (BMI) Computation PRO");
        System.out.println("^               by Mos");
        System.out.println("^");
        System.out.println("^".repeat(LINE_WIDTH));
    }

    /**
     * Display the BMI table (pro version) from the given parameters.
     *
     * @param height    The height in inches.
     * @param weightMax The maximum weight in pounds.
     * @param weightMin The minimum weight in pounds.
     */
    private static void displayTable(double height, double weightMax, double weightMin) {
        /* Print table header. */
        System.out.println("\nWEIGHT\t BMI\t\t CONDITION");

        /* Generate and print BMI table in increments of 5 lbs.*/
        double bmi;
        String cond;
        for (; weightMin <= weightMax; weightMin += 5) {
            /* Calculate the BMI. */
            bmi = calculateBMI(weightMin, height);
            /* Determine if the BMI is considered "overweight". */
            cond = bmi > 25 ? "overweight" : "not overweight";
            /* Print the table row. */
            System.out.printf("%.0f\t\t %3.4f\t %s%n", weightMin, bmi, cond);
        }
    }
}
