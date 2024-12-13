

public class BasicMonster extends Monster {
    // Constructor to initialize the basic monster
    public BasicMonster(String name, String color, int strength, int speed) {
        super(name, color, strength, speed);
    }

    // Implement the abstract special ability method
    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " performs a basic roar as a special ability!");
    }
}{
}
