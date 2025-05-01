package org.example.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * @param wireColor color of wire
     */
    public WiresModule(List<WireColor> wireColors) {
        this.name = "Wires";
        this.difficulty = 4;

        this.wireColors = wireColors;
    }

    /**
     * Displays wires in output
     * <p>
     * Ex.: "You see wires of color "Red, Green, Blue, White, Blue""
     */
    @Override
    public void display() {

    }

    @Override
    public boolean solve(String answer) {
        return false;
    }

    public List<WireColor> getWireColors() {
        return wireColors;
    }
}
