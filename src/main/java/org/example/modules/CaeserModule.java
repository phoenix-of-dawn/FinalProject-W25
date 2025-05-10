package org.example.modules;

import org.example.GameController;

import java.util.Random;
import java.util.Scanner;

public class CaeserModule extends Module implements Randomizable {
    private int shift;
    private String caeserString = "";
    private String decodedString = "";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public CaeserModule() {
        this.name = "Caeser";
        this.difficulty = 1;

        randomize();
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
        System.out.println("You see a display with the word \"" + caeserString + "\" and the number " + shift);
        System.out.println("Underneath it, there is a keyboard with the only the alphabet on it.");
        System.out.println("What do you write?");

        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        while (!ans.matches("[a-z]+")) {
            System.out.println("Invalid input");
            ans = sc.next();
        }

        if (!solve(ans)) {
            GameController.getInstance().strike();
            if (GameController.getInstance().getStrikesLeft() <= 0) {
                return;
            }
            randomize();
            display();
        }
    }

    @Override
    public boolean solve(String answer) {
        return answer.equals(decodedString);
    }

    @Override
    public void randomize() {
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

    public String getCaeserString() {
        return caeserString;
    }
}
