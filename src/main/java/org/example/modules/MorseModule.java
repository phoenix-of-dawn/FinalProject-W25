package org.example.modules;

import org.example.GameController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MorseModule extends Module {
    private String decodedString;
    private String code;

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Map<Character, String> MORSE_TO_ALPHABET = new HashMap<>();

    static {
        MORSE_TO_ALPHABET.put('a', ".-");
        MORSE_TO_ALPHABET.put('b', "-...");
        MORSE_TO_ALPHABET.put('c', "-.-.");
        MORSE_TO_ALPHABET.put('d', "-..");
        MORSE_TO_ALPHABET.put('e', ".");
        MORSE_TO_ALPHABET.put('f', "..-.");
        MORSE_TO_ALPHABET.put('g', "--.");
        MORSE_TO_ALPHABET.put('h', "....");
        MORSE_TO_ALPHABET.put('i', "..");
        MORSE_TO_ALPHABET.put('j', ".---");
        MORSE_TO_ALPHABET.put('k', "-.-");
        MORSE_TO_ALPHABET.put('l', ".-..");
        MORSE_TO_ALPHABET.put('m', "--");
        MORSE_TO_ALPHABET.put('n', "-.");
        MORSE_TO_ALPHABET.put('o', "---");
        MORSE_TO_ALPHABET.put('p', ".--.");
        MORSE_TO_ALPHABET.put('q', "--.-");
        MORSE_TO_ALPHABET.put('r', ".-.");
        MORSE_TO_ALPHABET.put('s', "...");
        MORSE_TO_ALPHABET.put('t', "-");
        MORSE_TO_ALPHABET.put('u', "..-");
        MORSE_TO_ALPHABET.put('v', "...-");
        MORSE_TO_ALPHABET.put('w', ".--");
        MORSE_TO_ALPHABET.put('x', "-..-");
        MORSE_TO_ALPHABET.put('y', "-.--");
        MORSE_TO_ALPHABET.put('z', "--..");
    }

    public MorseModule() {
        this.name = "Morse";
        this.difficulty = 5;

        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            this.decodedString += String.valueOf(ALPHABET.charAt(rand.nextInt(0, 26)));
        }

        for (int i = 0; i < decodedString.length() - 1; i++) {
            this.code += MORSE_TO_ALPHABET.get(this.decodedString.charAt(i)) + " / ";
        }
        this.code += MORSE_TO_ALPHABET.get(this.decodedString.charAt(decodedString.length() - 1)) + " / ";
    }

    /**
     * ONLY USE THIS FOR TESTING
     * @param decodedString Answer
     * @param code Morse code of decoded string
     */
    public MorseModule(String decodedString, String code) {
        this.name = "Morse";
        this.difficulty = 5;

        this.decodedString = decodedString;
        this.code = code;
    }

    @Override
    public void display() {
        System.out.println("You see a display with \"" + code + "\" on it");
        System.out.println("There is a keyboard with only the alphabet on it. What do you write on it?");

        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        while (!ans.matches("[a-z]+")) {
            System.out.println("Invalid input");
            ans = sc.next();
        }

        if (!solve(ans)) {
            GameController.getInstance().strike();
            display();
        }
    }

    @Override
    public boolean solve(String answer) {
        return answer.equals(decodedString);
    }

    public String getDecodedString() {
        return decodedString;
    }

    public String getCode() {
        return code;
    }
}
