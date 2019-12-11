/**
 * Instances of Earth represent a type of Planet
 * that the player can choose to go to during the game.
 * This could also be a randomized starting planet.
 */
public class Earth extends Planet {

    /**
     * A string representation of the name.
     */
    private static final String NAME = "Earth";

    /**
     * Earth constructor
     */
    Earth() {
        super(NAME);
    }
}