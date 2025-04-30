package org.example.modules;

public interface Randomizable {
    /**
     * randomizes the module's puzzle
     * The puzzle should NEVER be equal to the puzzle before calling this function
     */
    void randomize();
}
