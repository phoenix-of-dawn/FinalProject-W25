package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Module> modules;
    private int strikesLeft;

    private static GameController instance;

    private GameController() {
        this.strikesLeft = 3;
        this.modules = new ArrayList<>();

        initModules();
    }

    public static GameController getInstance() {
        if (instance != null) {
            return instance;
        }

        return new GameController();
    }

    public void start() {
        // TODO: Implement starting the game
    }

    private static void initModules() {
        // TODO: Implement this
    }

    private static void saveRun() {
        // TODO: Implement this
    }

    public List<Module> getModules() {
        return modules;
    }

    public int getStrikesLeft() {
        return strikesLeft;
    }
}
