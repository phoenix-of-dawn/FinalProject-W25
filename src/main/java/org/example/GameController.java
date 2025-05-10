package org.example;

import org.example.modules.*;
import org.example.modules.Module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class GameController {
    private List<Module> modules;
    private int strikesLeft;
    private long timeTaken;
    private String playerName;

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

    /**
     * runs the game and handles all the outside logic
     */
    public void run() {
        System.out.println("Do you want to see previous runs or do a new run? 1 or 2");
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        while (!in.equals("1") && !in.equals("2")) {
            System.out.println("Invalid input");
            in = sc.next();
        }

        if (in.equals("1")) {
            showRuns();
            return;
        }

        System.out.println("You have a bomb with modules: ");
        for (Module module : modules) {
            System.out.println(module.getName());
        }

        System.out.println("Your time starts now!");
        long startTime = System.currentTimeMillis();

        for (Module module : modules) {
            module.display();
            if (strikesLeft <= 0) {
                System.out.println("The bomb has exploded. You have lost");
                timeTaken = System.currentTimeMillis() - startTime;
                saveRun();
                return;
            }
            System.out.println("Good job! Success!");
            saveRun();
            return;
        }
    }

    /**
     * when someone fails at a module, remove a strike
     */
    public void strike() {
        strikesLeft--;
    }

    /**
     * initializes the modules array list
     */
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

    /**
     * saves a run to a csv file
     */
    private void saveRun() {
        File runs = new File("src/main/resources/runs.csv");

        try (FileWriter fileWriter = new FileWriter(runs, true)) {
            String toWrite = "";
            toWrite += playerName + ",";
            toWrite += (strikesLeft >= 0) + ",";
            toWrite += strikesLeft + ",";
            toWrite += timeTaken + "\n";
            fileWriter.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("File not writable: ", e);
        }
    }

    /**
     * displays all the runs in order of completion
     */
    private void showRuns() {
        File file = new File("src/main/resources/runs.csv");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String runString = sc.nextLine();
                if (runString == null || runString.isBlank()) {
                    return;
                }

                String[] run = runString.split(",");
                System.out.printf("Name: %s. Bomb defused: %b. Strikes left: %s. Time taken (in seconds): %d",
                        run[0],
                        Boolean.getBoolean(run[1]),
                        run[2],

                        // Is in milliseconds, need to divide by 1000 to get seconds
                        Long.getLong(run[3]) / 1000
                );
            }
        } catch (FileNotFoundException e) {
            System.out.println("No runs completed yet.");
        }
    }

    public List<Module> getModules() {
        return modules;
    }

    public int getStrikesLeft() {
        return strikesLeft;
    }
}
