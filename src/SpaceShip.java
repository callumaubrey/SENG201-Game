import java.lang.Math;

/**
 * The SpaceShip object is used for the space ship during the game.
 * It calculates the pieces required
 * based on the number of days.
 */
public class SpaceShip {

	/**
	 * A string representation of the name of the space ship.
	 */
	private String name;

	/**
	 * An integer representation for the number of pieces required.
	 */
	private int piecesRequired;
	
	/**
	 * An integer representation for shield health.
	 */
	private int shieldHealth;
	
	/**
	 * An integer representation for the number of days to play in the game.
	 */
	private int numDays;
	
	/**
	 * An integer representation for the number of pieces found.
	 */
	private int piecesFound;
	
	/**
	 * SpaceShip constructor.
	 * @param name The name for the ship.
	 * @param numDays The number of days to play.)
	 */
	SpaceShip(String name, int numDays) {
		this.name = name;
		this.shieldHealth = 100;
		this.piecesFound = 0;
		this.numDays = numDays;
		calculatePiecesRequired();
	}
	
 	/**
 	 * Calculates pieces required based on number of days.
 	 */
	private void calculatePiecesRequired() {
		int piecesRequired = Math.round((this.numDays * 2) / 3);
		this.piecesRequired = piecesRequired;
	}
	
	/**
	 * Checks if all parts are found
	 * @return boolean True if found false otherwise.
	 */
	public boolean allPartsFound() {
		if (piecesFound == piecesRequired) {
			return true;
		}
		return false;
	}

	/**
	 * Adds a peice to the piecesFound property.
	 */
	public void addPeice() {
		piecesFound += 1;
		if (piecesFound > piecesRequired) {
			piecesFound = piecesRequired;
		}
	}

	/**
	 * Checks if the space ship has enough health to travel.
	 * @return boolean true if can travel false if not.
	 */
	public boolean canTravel() {
		if (shieldHealth <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Repairs the ship given member property
	 * @param member A crew member object.
	 */
	public void repair(CrewMember member) {
		incrementShieldLevel(member.getShieldIncrement());
	}

	/**
	 * Decreases the shield level if < 0 then sets it to 0
	 * @param decrement The amount to decrement by
	 */
	public void decreaseShieldLevel(int decrement) {
		shieldHealth -= decrement;
		if (shieldHealth < 0) {
			shieldHealth = 0;
		}
	}

	/**
	 * Increases the shield level if > 100 then sets it to 100
	 * @param increment The amount to increment by
	 */
	public void incrementShieldLevel(int increment) {
		shieldHealth += increment;
		if (shieldHealth > 100) {
			shieldHealth = 100;
		}
	}

	/**
	 * Increases the shield level if > 100 then sets it to 100
	 * @param increment The amount to increment by
	 */
	public int getShieldHealth() {
		return shieldHealth;
	}

	/**
	 * Checks if shield health is full.
	 * @return boolean is shieldhealth full false otherwise.
	 */
	public boolean isFullHealth() {
		if (shieldHealth >= 100) {
			return true;
		}
		return false;
	}

	/**
	 * Gets pieces required.
	 * @return piecesRequired The pieces required to fix the ship.
	 */
	public int getPiecesRequired() {
		return piecesRequired;
	}

	/**
	 * Gets pieces found.
	 * @return piecesFound The pieces found.
	 */
	public int getPiecesFound() {
		return piecesFound;
	}

	/**
	 * Gets the name of the space ship.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * toString property.
	 * @return string
	 */
	public String toString() {
		String data = "Name: " + this.getName() + "\n";
		data += "Shield Health: " + this.getShieldHealth() + "\n";
		data += "Pieces Required: " + this.getPiecesRequired();
		return data;
	}
}
