/**
 * Instances of Mars represent a type of Planet
 * that the player can choose to go to during the game.
 * This could also be a randomized starting planet.
 */
public class Mars extends Planet {

    /**
     * A string representation of the name.
     */
	private final static String NAME = "Mars";

    /**
     * Mars constructor
     */
    Mars() {
        super(NAME);
    }
}