/**
 * Instances of Plaster represent a type of Medical Supply
 * that the player can choose to purchase and apply to a crew member
 */
class Plaster extends MedicalSupply {

    /**
     * A string representation of the type of medical supply.
     */
    public static final String TYPE = "Plaster";

    /**
     * An integer representation of the health the medical supply gives.
     */
    public static final int HEALTH = 20;

    /**
     * An integer representation of the cost of the medical supply.
     */
    public static final int COST = 10;

    /**
     * Plaster constructor.
     */
    Plaster() {
        super(TYPE, HEALTH, COST);
    }
}

/**
 * Instances of Bandage represent a type of Medical Supply
 * that the player can choose to purchase and apply to a crew member
 */
class Bandage extends MedicalSupply {

    /**
     * A string representation of the type of medical supply.
     */
    public static final String TYPE = "Bandage";

    /**
     * An integer representation of the health the medical supply gives.
     */
    public static final int HEALTH = 30;
    
    /**
     * An integer representation of the cost of the medical supply.
     */
    public static final int COST = 20;

    /**
     * Bandage constructor.
     */
    Bandage() {
        super(TYPE, HEALTH, COST);
    }
}

/**
 * Instances of FirstAidKit represent a type of Medical Supply
 * that the player can choose to purchase and apply to a crew member
 */
class FirstAidKit extends MedicalSupply {

    /**
     * A string representation of the type of medical supply.
     */
    public static final String TYPE = "First Aid Kit";

    /**
     * An integer representation of the health the medical supply gives.
     */
    public static final int HEALTH = 50;

    /**
     * An integer representation of the cost of the medical supply.
     */
    public static final int COST = 40;

    /**
     * FirstAidKit constructor.
     */
    FirstAidKit() {
        super(TYPE, HEALTH, COST);
    }
}

/**
 * Instances of SpacePlagueCure represent a type of Medical Supply
 * that the player can choose to purchase and apply to a crew member
 */
class SpacePlagueCure extends MedicalSupply {

    /**
     * A string representation of the type of medical supply.
     */
    public static final String TYPE = "Space Plague Cure";

    /**
     * An integer representation of the health the medical supply gives.
     */
    public static final int HEALTH = 0;
    
    /**
     * An integer representation of the cost of the medical supply.
     */
    public static final int COST = 50;

    /**
     * SpacePlagueCure constructor.
     */
    SpacePlagueCure() {
        super(TYPE, HEALTH, COST);
        isSpacePlagueCure = true;
    }
}

/**
 * Instances of Medical Supply represent all the Medical Supplies in the game.
 * Each Medical Supply has a cost, hunger level and a count
 * The count is what is used to determine how many of that item
 * are in the inventory.
 */
public class MedicalSupply {
    
    /**
    * An string representation of the type of medical supply.
    */
    private String type;

    /**
    * An integer representation of health the medical supply gives.
    */
    private int health;

    /**
    * An integer representation of the cost of the medical supply.
    */
    private int cost;

    /**
    * An integer representation of the count of the medical supply.
    */
    private int countOfItems;

    /**
    * A boolean to determine of medical supply cures space plague or not.
    */
    protected boolean isSpacePlagueCure;

    /**
    * MedicalSupply constructor
    */
    MedicalSupply(String type, int health, int cost) {
        this.type = type;
        this.cost = cost;
        this.health = health;
        this.countOfItems = 0;
        this.isSpacePlagueCure = false;
    }

    /**
    * Blank MedicalSupply constructor
    */
    MedicalSupply() {}

    /**
    * Increment count of items
    */
    public void incrementItemCount() {
        countOfItems += 1;
    }

    /**
    * Decrement count of items
    */
    public void decrementItemCount() {
        countOfItems -= 1;
    }

    /**
    * toString()
    * @return string
    */
    public String toString() {
        String ret = this.type + " (" + countOfItems + ")\n";
        return ret;
    }

    /**
    * Gets type of medical supply
    * @return type The type of medical supply.
    */
    public String getType() {
        return type;
    }

    /**
    * Gets health of medical supply
    * @return health The health of medical supply.
    */
    public int getHealth() {
        return health;
    }

    /**
    * Gets count of medical supply
    * @return countOfItems The count of medical supply.
    */
    public int getCount() {
        return countOfItems;
    }

    /**
    * Gets cost of medical supply
    * @return cost The cost of medical supply.
    */
    public int getCost() {
        return cost;
    }

    /**
    * Checks if item exists or not (count > 0)
    * @return boolean
    */
    public boolean exists() {
        if (countOfItems > 0) {
            return true;
        }
        return false;
    }

    /**
    * Checks if item is space plague cure or not
    * @return boolean
    */
    public boolean isSpacePlagueCure() {
        return isSpacePlagueCure;
    }
}
