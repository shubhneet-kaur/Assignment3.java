

public class FlyingMonster extends Monster {
    private int wingSpan; // Additional field unique to FlyingMonster

    // Constructor to initialize FlyingMonster details
    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    // Getter for wingspan
    public int getWingSpan() {
        return wingSpan;
    }

    // Override special ability
    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " soars into the sky with a wingspan of " + wingSpan + " meters!");
    }
}{
}
