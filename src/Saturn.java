/**
 * Instances of Saturn represent a type of Planet
 * that the player can choose to go to during the game.
 * This could also be a randomized starting planet.
 */
public class Saturn extends Planet {

    /**
     * A string representation of the name.
     */
    private static final String NAME = "Saturn";

    /**
     * Saturn constructor
     */
    Saturn() {
        super(NAME);
    }
}