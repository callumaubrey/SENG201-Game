/**
 * Instances of Planet represent all the planets in the game.
 * Each planet can only have one transporter part found
 */
public class Planet {

    /**
     * Array of all planets
     */
    private static final Planet[] ALL_PLANETS = {
        new Mars(),
        new Venus(),
        new Earth(),
        new Mercury(),
        new Jupiter(),
        new Saturn()
    };
	
    /**
     * A string representation of the name of planet.
     */
    private String name;
    
    /**
     * A boolean to check if transporter part is found or not
     */
    private boolean transporterPartFound;

    /**
     * Planet constructor
     * @param name The name of planet
     */
    Planet(String name) {
    	this.name = name;
        this.transporterPartFound = false;
    }

    /**
     * An empty Planet constructor
     */
    Planet() {}

    /**
     * Returns the name of the planet
     * @return name
     */
    public String getName() {
    	return name;
    }

    /**
     * Sets transporterPartFound equal to true
     */
    public void foundTransporterPart() {
        transporterPartFound = true;
    }

    /**
     * Returns if transporter part is found or not
     * @return True if found False otherwise
     */
    public boolean transporterPartFound() {
        return transporterPartFound;
    }
    
    /**
     * Gets all planets array
     * @return ALL_PLANETS A planet array with all planet objects in it
     */
    public Planet[] getAll() {
    	return ALL_PLANETS;
    }

    /**
     * Gets planet by given name
     * @param name The string to search for.
     * @return the found planet object or an empty Planet object if not found
     */
    public Planet getByName(String name) {
        for (int i = 0; i < ALL_PLANETS.length; i++) {
            if (name.equals(ALL_PLANETS[i].getName())) {
                return ALL_PLANETS[i];
            }
        }
        return new Planet();
    }

    /**
     * toString
     * @return String)
     */
    public String toString() {
        return "Planet: " + this.getName();
    }
}