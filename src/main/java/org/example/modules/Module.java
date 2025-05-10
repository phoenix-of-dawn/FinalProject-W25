package org.example.modules;

import java.util.Comparator;
import java.util.Objects;

public abstract class Module implements Comparable<Module> {
    protected String name;
    protected int difficulty;

    /**
     * displays the module
     */
    abstract public void display();

    /**
     * Checks if the answer is right
     * @param answer the answer
     * @return whether it is right or not
     */
    abstract public boolean solve(String answer);

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
                case "difficulty" -> o1.difficulty - o2.difficulty;
                case null, default -> o1.compareTo(o2);
            };
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Module module)) return false;
        return difficulty == module.difficulty && Objects.equals(name, module.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
