

import java.io.*;

// Abstract base class for all monsters
public abstract class Monster {
    private String name;
    private String color;
    private int strength;
    private int speed;

    // Constructor to initialize monster details
    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    // Getters for monster attributes
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    // Save monster details to a file
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true)); // Append mode
        writer.write(name + "," + color + "," + strength + "," + speed + "\n");
        writer.close();
    }

    // Load a single monster from a file
    public static Monster loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        if (line != null) {
            String[] parts = line.split(",");
            reader.close();
            return new BasicMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
        reader.close();
        return null; // Return null if the file is empty or no data is available
    }

    // Override toString for a descriptive monster representation
    @Override
    public String toString() {
        return "Name: " + name + ", Color: " + color + ", Strength: " + strength + ", Speed: " + speed;
    }

    // Abstract method to define unique abilities for each monster
    public abstract void performSpecialAbility();
}{
}
