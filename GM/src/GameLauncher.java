

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        MonsterManager manager = new MonsterManager(); // Instantiate the MonsterManager
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        while (true) {
            // Display main menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Monster");
            System.out.println("2. View Monsters");
            System.out.println("3. Breed Monsters");
            System.out.println("4. Save Game");
            System.out.println("5. Load Game");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Create a new monster
                    System.out.println("Enter monster details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Strength: ");
                    int strength = scanner.nextInt();
                    System.out.print("Speed: ");
                    int speed = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Choose monster type
                    System.out.println("Choose Monster Type:");
                    System.out.println("1. Basic Monster");
                    System.out.println("2. Flying Monster");
                    System.out.println("3. Aquatic Monster");
                    System.out.println("4. Mountain Monster");
                    System.out.println("5. Desert Monster");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Monster newMonster = null;
                    switch (type) {
                        case 1:
                            newMonster = new BasicMonster(name, color, strength, speed);
                            break;
                        case 2:
                            System.out.print("Wing Span: ");
                            int wingSpan = scanner.nextInt();
                            newMonster = new FlyingMonster(name, color, strength, speed, wingSpan);
                            break;
                        case 3:
                            System.out.print("Swim Speed: ");
                            int swimSpeed = scanner.nextInt();
                            newMonster = new AquaticMonster(name, color, strength, speed, swimSpeed);
                            break;
                        case 4:
                            System.out.print("Climbing Skill: ");
                            int climbingSkill = scanner.nextInt();
                            newMonster = new MountainMonster(name, color, strength, speed, climbingSkill);
                            break;
                        case 5:
                            System.out.print("Heat Resistance: ");
                            int heatResistance = scanner.nextInt();
                            newMonster = new DesertMonster(name, color, strength, speed, heatResistance);
                            break;
                        default:
                            System.out.println("Invalid type. Returning to main menu.");
                            continue;
                    }

                    if (newMonster != null) {
                        manager.addMonster(newMonster);
                    }
                    break;

                case 2:
                    // View monsters
                    System.out.println("View Monsters:");
                    System.out.print("Do you want detailed view? (yes/no): ");
                    String detailedView = scanner.nextLine();
                    manager.displayMonsters(detailedView.equalsIgnoreCase("yes"));
                    break;

                case 3:
                    // Breed two monsters
                    System.out.println("Available Monsters:");
                    manager.displayMonsters(false);
                    System.out.print("Enter index of first monster: ");
                    int index1 = scanner.nextInt();
                    System.out.print("Enter index of second monster: ");
                    int index2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    manager.breedMonsters(index1, index2);
                    break;

                case 4:
                    // Save game
                    System.out.print("Enter filename to save game: ");
                    String saveFile = scanner.nextLine();
                    manager.saveGame(saveFile);
                    break;

                case 5:
                    // Load game
                    System.out.print("Enter filename to load game: ");
                    String loadFile = scanner.nextLine();
                    manager.loadGame(loadFile);
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting game. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
