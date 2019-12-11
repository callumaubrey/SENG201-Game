/**
 * Instances of Nerd represent a type of crew member
 * that the player can choose. A new instance should be created during SetUpScreen
 *
 */
public class Nerd extends CrewMember {

    /**
     * A string representation of the type of Crew Member.
     */
    private static final String TYPE = "Nerd";

    /**
     * A string representation of the specialty of Crew Member.
     */
    private static final String SPECIALTY = "Great for algebra, but no good in space.";

    /**
     * A string representation of the description of Crew Member.
     */
    private static final String DESCRIPTION = "Although he would much rather be playing Runescape, this nerd can never turn down a space adventure.";

    /**
     * An integer representation of the health of Crew Member.
     */
    private static final int HEALTH = 80;

    /**
     * An integer representation of the decrement of Crew Member.
     * How much tiredness, hunger and health degrade over time.
     */
    private static final int DECREMENT = 15;

    /**
     * An integer representation of how much health the crew member can restore to the space ship shield.
     */
    private static final int SHIELD_INCREMENT = 50;

    /**
     * Nerd constructor
     * @param name A string for the name of the crew member
     */
    Nerd(String name) {
        super(name, TYPE, DESCRIPTION, HEALTH, SPECIALTY, DECREMENT, SHIELD_INCREMENT);
    }
}