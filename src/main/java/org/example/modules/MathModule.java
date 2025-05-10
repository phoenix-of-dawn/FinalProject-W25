package org.example.modules;

import org.example.GameController;

import java.util.Random;
import java.util.Scanner;

public class MathModule extends Module {
    private final String expression;
    private int answer;
    private final String operation;

    private static final String digits = "0123456789";
    private static final String operations = "+-*";

    public MathModule() {
        this.name = "Math";
        this.difficulty = 1;

        Random rand = new Random();

        this.operation = String.valueOf(operations.charAt(rand.nextInt(0, 3)));

        this.expression = digits.charAt(rand.nextInt(0, 10)) + "" +
                digits.charAt(rand.nextInt(0,10)) + " " +
                this.operation + " " +
                digits.charAt(rand.nextInt(0,10)) +
                digits.charAt(rand.nextInt(0,10)) +
                " = ?";

        initAnswer();
    }

    /**
     * ONLY USE FOR TESTING PURPOSES
     * @param expression math expression
     * @param operation the operation done (+-*)
     */
    public MathModule(String expression, String operation) {
        this.name = "Math";
        this.difficulty = 1;

        this.expression = expression;
        this.operation = operation;

        initAnswer();
    }

    /**
     * Displays the output and handles the input
     * <br>
     * Ex.: "You see a display with "2+2=?" on it, what do you write?"
     */
    @Override
    public void display() {
        System.out.println("You see a display with \"" + expression + "\" on it.");
        System.out.println("Underneath it, you see a keypad. What do you do?");

        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        while (!isValidInput(ans)) {
            System.out.println("Invalid input");
            ans = sc.nextLine();
        }

        if (!solve(ans)) {
            GameController.getInstance().strike();
            if (GameController.getInstance().getStrikesLeft() <= 0) {
                return;
            }
            display();
        }
    }

    @Override
    public boolean solve(String answer) {
        return Integer.parseInt(answer) == this.answer;
    }

    /**
     * checks if the input is valid
     * @param in input
     * @return whether it is valid
     */
    private boolean isValidInput(String in) {
        try {
            Integer.parseInt(in);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * this initializes the answer variable
     */
    private void initAnswer() {
        // should not throw as the string will always be formatted as intended
        this.answer = switch (this.operation) {
            case "+" -> Integer.parseInt(this.expression.substring(0, 2)) +
                    Integer.parseInt(this.expression.substring(5,7));
            case "-" -> Integer.parseInt(this.expression.substring(0, 2)) -
                    Integer.parseInt(this.expression.substring(5,7));
            case "*" -> Integer.parseInt(this.expression.substring(0, 2)) *
                    Integer.parseInt(this.expression.substring(5,7));
            case null, default -> throw new IllegalStateException("This is not supposed to happen: " +
                    "operation is chosen from \"+-*\" and not " + this.operation);
        };
    }

    public String getExpression() {
        return expression;
    }

    public int getAnswer() {
        return answer;
    }

    public String getOperation() {
        return operation;
    }
}
