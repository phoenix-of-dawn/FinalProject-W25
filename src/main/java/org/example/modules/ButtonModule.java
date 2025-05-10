package org.example.modules;

import org.example.GameController;

import java.util.Random;
import java.util.Scanner;

public class ButtonModule extends Module {
    public enum ButtonColor {
        RED, BLUE, GREEN, YELLOW, WHITE;

        /**
         * Picks a random value from the enum
         * @return a random ButtonColor
         */
        static ButtonColor getRandomValue() {
            Random rand = new Random();
            ButtonColor[] values = ButtonColor.values();
            return values[rand.nextInt(0, 5)];
        }
    }

    ButtonColor buttonColor;

    public ButtonModule() {
        this.name = "Button";
        this.difficulty = 2;

        this.buttonColor = ButtonColor.getRandomValue();
    }

    /**
     * ONLY USE THIS FOR TEST
     * @param buttonColor color to set button to
     */
    public ButtonModule(ButtonColor buttonColor) {
        this.buttonColor = buttonColor;
    }

    /**
     * Displays the Button module and handles input
     * <p>
     * Ex.: "You see a button of the color RED
     * <p>
     * What do you do? press or hold
     */
    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);

        System.out.println("You see a button of the color " + this.buttonColor.toString());
        System.out.println("What do you do? press or hold <amount of time in seconds>");

        String ans = sc.nextLine();

        while (!isValidInput(ans))
        {
            System.out.println("Invalid input, try again");
            ans = sc.nextLine();
        }

        boolean success = solve(ans);
        if (!success)  {
            GameController.getInstance().strike();
            if (GameController.getInstance().getStrikesLeft() <= 0) {
                return;
            }
            display();
        }
    }

    @Override
    public boolean solve(String answer) {
        return switch (buttonColor) {
            case RED, WHITE -> answer.equals("press");
            case BLUE -> answer.equals("hold 3");
            case GREEN -> answer.equals("hold 1");
            case YELLOW -> answer.equals("hold 10");
        };
    }

    private boolean isValidInput(String in) {
        if (in.equals("press")) {
            return true;
        }

        if (in.startsWith("hold")) {
            try {
                Integer.parseInt(in.substring(5));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }

    public ButtonColor getButtonColor() {
        return buttonColor;
    }
}
