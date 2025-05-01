package org.example.modules;

import java.util.Random;

public class MathModule extends Module {
    private String expression;
    private int answer;
    private String operation;

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

    @Override
    public void display() {
        // TODO: Implement display for MathModule
    }

    @Override
    public boolean solve(String answer) {
        // TODO: Implement solve for MathModule
        return false;
    }

    /**
     * this initializes the answer variable
     */
    private void initAnswer() {
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
