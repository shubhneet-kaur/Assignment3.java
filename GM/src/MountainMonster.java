public class MountainMonster extends Monster {
    private int climbingSkill; // Additional field unique to MountainMonster

    // Constructor to initialize MountainMonster details
    public MountainMonster(String name, String color, int strength, int speed, int climbingSkill) {
        super(name, color, strength, speed);
        this.climbingSkill = climbingSkill;
    }

    // Getter for climbing skill
    public int getClimbingSkill() {
        return climbingSkill;
    }

    // Override special ability
    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " climbs steep terrains with a skill level of " + climbingSkill + "!");
    }
}