package org.example.modules;

import java.util.Random;

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
        this.buttonColor = ButtonColor.getRandomValue();
    }

    /**
     * ONLY USE THIS FOR TEST
     * @param buttonColor color to set button to
     */
    public ButtonModule(ButtonColor buttonColor) {
        this.buttonColor = buttonColor;
    }

    @Override
    public void display() {
        // TODO Implement this
    }

    @Override
    public boolean solve(String answer) {
        // TODO Implement this
        return false;
    }

    public ButtonColor getButtonColor() {
        return buttonColor;
    }
}
