package org.example.modules;

import java.util.Comparator;

public abstract class Module implements Comparable<Module> {
    String name;
    int difficulty;

    /**
     * displays the module
     */
    abstract void display();

    /**
     * Checks if the answer is right
     * @param answer the answer translated into an int
     * @return whether it is right or not
     */
    abstract boolean solve(int answer);

    @Override
    public int compareTo(Module o) {
        return (o.difficulty - this.difficulty) * 1000 + (o.name.compareTo(this.name));
    }

    public static class ModuleComparator implements Comparator<Module> {
        String compared;

        public ModuleComparator(String compared) {
            this.compared = compared;
        }

        @Override
        public int compare(Module o1, Module o2) {
            return switch (this.compared) {
                case "name" -> o1.name.compareTo(o2.name);
                case "difficulty" -> o2.difficulty - o1.difficulty;
                case null, default -> o1.compareTo(o2);
            };
        }
    }
}
