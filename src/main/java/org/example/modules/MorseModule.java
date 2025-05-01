package org.example.modules;

import java.util.Map;

public class MorseModule extends Module {
    private String decodedString;
    private String code;

    private static Map<Character, String> ALPHABET;

    public MorseModule() {
        // TODO: Make this
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
        // TODO: Implement display for MorseModule
    }

    @Override
    public boolean solve(String answer) {
        // TODO: Implement solve for MorseModule
        return false;
    }

    public String getDecodedString() {
        return decodedString;
    }

    public String getCode() {
        return code;
    }
}
