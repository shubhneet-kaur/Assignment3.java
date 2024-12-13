

import java.util.ArrayList;
import java.io.*;

public class MonsterManager {
    private ArrayList<Monster> monsters; // List to store monsters

    // Constructor to initialize the monster list
    public MonsterManager() {
        monsters = new ArrayList<>();
    }

    // Method to add a new monster to the collection
    public void addMonster(Monster monster) {
        monsters.add(monster);
        System.out.println(monster.getName() + " has been added to the collection.");
    }

    // Method to breed two monsters and create a new one
    public void breedMonsters(int index1, int index2) {
        if (index1 < 0 || index1 >= monsters.size() || index2 < 0 || index2 >= monsters.size()) {
            System.out.println("Invalid indices. Please try again.");
            return;
        }

        Monster parent1 = monsters.get(index1);
        Monster parent2 = monsters.get(index2);

        String newName = parent1.getName() + "-" + parent2.getName();
        String newColor = parent1.getColor() + "-" + parent2.getColor();
        int newStrength = (parent1.getStrength() + parent2.getStrength()) / 2;
        int newSpeed = (parent1.getSpeed() + parent2.getSpeed()) / 2;

        Monster offspring = new BasicMonster(newName, newColor, newStrength, newSpeed);
        addMonster(offspring);
        System.out.println("New monster created: " + offspring);
    }

    // Method to save all monsters to a file
    public void saveGame(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Monster monster : monsters) {
                monster.saveToFile(filename);
            }
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    // Method to load monsters from a file
    public void loadGame(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            monsters.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Monster monster = new BasicMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                monsters.add(monster);
            }
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading game: " + e.getMessage());
        }
    }

    // Method to display monsters
    public void displayMonsters(boolean detailed) {
        if (monsters.isEmpty()) {
            System.out.println("No monsters in the collection.");
            return;
        }
        for (Monster monster : monsters) {
            System.out.println(detailed ? monster.toString() : monster.getName());
        }
    }
}

