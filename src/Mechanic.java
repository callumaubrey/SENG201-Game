/**
 * Instances of Mechanic represent a type of crew member
 * that the player can choose. A new instance should be created during SetUpScreen
 *
 */
public class Mechanic extends CrewMember {

    /**
     * A string representation of the type of Crew Member.
     */
    private static final String TYPE = "Mechanic";

    /**
     * A string representation of the specialty of Crew Member.
     */
    private static final String SPECIALTY = "This guy can repair more shield health than normal";

    /**
     * A string representation of the description of Crew Member.
     */
    private static final String DESCRIPTION = "If its broken, he can fix it";

    /**
     * An integer representation of the max health of Crew Member.
     */
    private static final int HEALTH = 75;

    /**
     * An integer representation of the decrement of Crew Member.
     * How much tiredness, hunger and health degrade over time.
     */
    private static final int DECREMENT = 15;

    /**
     * An integer representation of how much health the crew member can restore to the space ship shield.
     */
    private static final int SHIELD_INCREMENT = 60;

    /**
     * Mechanic constructor
     * @param name A string for the name of the crew member
     */
    Mechanic(String name) {
        super(name, TYPE, DESCRIPTION, HEALTH, SPECIALTY, DECREMENT, SHIELD_INCREMENT);
    }
}