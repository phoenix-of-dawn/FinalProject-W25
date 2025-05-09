package org.example;

import org.example.modules.*;
import org.example.modules.Module;

import java.util.*;

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

        instance = new GameController();
        return instance;
    }

    public void start() {
        for (Module module : modules) {
            module.display();
        }
    }

    public void strike() {
        strikesLeft--;
    }

    private void initModules() {
        this.modules = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int next = rand.nextInt(0, 5);
            while (seen.contains(next)) {
                next = rand.nextInt(0, 5);
            }
            seen.add(next);

            Module moduleToAdd = switch (next) {
                case 0 -> new WiresModule();
                case 1 -> new ButtonModule();
                case 2 -> new MathModule();
                case 3 -> new MorseModule();
                case 4 -> new CaeserModule();
                default -> throw new IllegalStateException();
            };

            this.modules.add(moduleToAdd);
        }

        this.modules.sort(new Module.ModuleComparator("difficulty"));
    }

    private void saveRun() {
        // TODO: Implement this
    }

    public List<Module> getModules() {
        return modules;
    }

    public int getStrikesLeft() {
        return strikesLeft;
    }
}
