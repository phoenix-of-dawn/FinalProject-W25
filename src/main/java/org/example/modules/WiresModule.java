package org.example.modules;

import org.example.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WiresModule extends Module {
    public enum WireColor {
        RED, WHITE, BLUE, BLACK, ORANGE;

        static WireColor getRandomColor() {
            WireColor[] values = WireColor.values();
            Random rand = new Random();

            return values[rand.nextInt(0, values.length)];
        }
    }

    List<WireColor> wireColors;

    public WiresModule() {
        this.name = "Wires";
        this.difficulty = 4;

        this.wireColors = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.wireColors.add(WireColor.getRandomColor());
        }
    }

    /**
     * ONLY USE FOR TESTING PURPOSES
     * @param wireColors color of wire
     */
    public WiresModule(List<WireColor> wireColors) {
        this.name = "Wires";
        this.difficulty = 4;

        this.wireColors = wireColors;
    }

    /**
     * Displays wires in output and handles input
     * <p>
     * Ex.: "You see wires of color "Red, Green, Blue, White, Blue""
     */
    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);

        System.out.println("You see wires of colors:");
        for (WireColor wire : this.wireColors) {
            System.out.println(wire.toString());
        }
        System.out.println("Which wire would you like to cut? 1, 2, 3, 4 or 5?");

        String ans = sc.next();
        while (!(ans.equals("1")
                || ans.equals("2")
                || ans.equals("3")
                || ans.equals("4")
                || ans.equals("5")))
        {
            System.out.println("Invalid input, try again");
            ans = sc.next();
        }

        boolean success = solve(ans);

        if (!success) {
            GameController.getInstance().strike();
            if (GameController.getInstance().getStrikesLeft() <= 0) {
                return;
            }
            display();
        }
    }

    @Override
    public boolean solve(String answer) {
        return false;
    }

    public List<WireColor> getWireColors() {
        return wireColors;
    }
}
