package org.example.modules;

import java.util.Random;

public class CaeserModule extends Module {
    private int shift;
    private String caeserString = "";
    private String decodedString = "";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public CaeserModule() {
        this.name = "Caeser";
        this.difficulty = 1;

        Random rand = new Random();

        this.shift = rand.nextInt(1,26);

        for (int i = 0; i < 8; i++) {
            decodedString += ALPHABET.charAt(rand.nextInt(0, 26));
        }

        for (int i = 0; i < 8; i++) {
            char toAdd = (char) ((decodedString.charAt(i) + shift - 'a') % 26 + 'a');
            caeserString += toAdd;
        }
    }

    /**
     * ONLY EVER USE FOR TESTING
     * @param shift the amount of letter to shift
     * @param decodedString string before it is encrypted with the caeser cypher
     */
    public CaeserModule(int shift, String decodedString) {
        this.name = "Caeser";
        this.difficulty = 1;

        this.shift = shift;
        this.decodedString = decodedString;

        for (int i = 0; i < 8; i++) {
            char toAdd = (char) ((decodedString.charAt(i) + shift - 'a') % 26 + 'a');
            caeserString += toAdd;
        }
    }

    @Override
    public void display() {

    }

    @Override
    public boolean solve(String answer) {
        return false;
    }

    public String getCaeserString() {
        return caeserString;
    }
}
