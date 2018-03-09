/**
 * Class to represent an Athlete.
 * @author CS1331 TAs
 * @version 13.3.1
 */
public class Athlete {

    private String name;
    private int energy;
    private int strength;


    /**
     * Public constructor for Athlete. Takes in a name, energy, and strength.
     * @param name Name of the athlete.
     * @param energy Athlete's initial energy.
     * @param strength Athlete's initial strength.
     */
    public Athlete(String name, int energy, int strength) {
        this.name = name;
        this.energy = energy;
        this.strength = strength;
    }

    /**
     * Public constructor for Athlete. Takes in only a name, and invokes
     * the other constructor with inital energy 15 and initial strength 5.
     * @param name Name of the athlete.
     */
    public Athlete(String name) {
        this(name, 15, 5);
    }

    /**
     * Getter for name.
     * @return Name of the athlete.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for energy.
     * @return Energy of the athlete.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Getter for strength.
     * @return Strength of the athlete.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Trains the athlete. Increases strength by one, depletes energy by the
     * value of the old strength. You need to fix this method to disallow
     * overtraining of an Athlete as such: if energy < strength,
     * throw an OvertrainedAthleteException.
     */
    public void train() {
        energy -= strength;
        strength++;
    }

    /**
     * Rests the athlete. Increases the energy by 5.
     */
    public void rest() {
        energy += 5;
    }

    /**
     * toString implementaton for Athlete. Returns something like:
     * "Athlete: Jimmy, energy: 5, strength: 5".
     * @return String representation of Athlete.
     */
    public String toString() {
        return String.format("Athlete: %s, energy: %d, "
            + "strength: %d", name, energy, strength);
    }
}
