public class DesertMonster extends Monster {
    private int heatResistance; // Additional field unique to DesertMonster

    // Constructor to initialize DesertMonster details
    public DesertMonster(String name, String color, int strength, int speed, int heatResistance) {
        super(name, color, strength, speed);
        this.heatResistance = heatResistance;
    }

    // Getter for heat resistance
    public int getHeatResistance() {
        return heatResistance;
    }

    // Override special ability
    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " withstands extreme heat with a resistance level of " + heatResistance + "!");
    }
}{
}
