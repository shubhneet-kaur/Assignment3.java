public class AquaticMonster extends Monster {
    private int swimSpeed; // Additional field unique to AquaticMonster

    // Constructor to initialize AquaticMonster details
    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    // Getter for swim speed
    public int getSwimSpeed() {
        return swimSpeed;
    }

    // Override special ability
    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " swims rapidly at a speed of " + swimSpeed + " meters per second!");
    }
}