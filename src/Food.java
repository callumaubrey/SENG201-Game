/**
 * Instances of Steak represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Steak extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Steak";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 50;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 100;

    /**
     * Steak Constructor
     */
    Steak() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Salad represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Salad extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Salad";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 40;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 75;

    /**
     * Salad Constructor
     */
    Salad() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Apple represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Apple extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Apple";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 10;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 10;

    /**
     * Apple Constructor
     */
    Apple() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Noodles represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Noodles extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Noodles";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 15;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 20;

    /**
     * Noodles Constructor
     */
    Noodles() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Soup represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Soup extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Soup";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 20;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 30;

    /**
     * Soup Constructor
     */
    Soup() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Pasta represent a type of Food
 * that the player can choose to purchase and apply to a crew member
 */
class Pasta extends Food {

    /**
     * A string representation of the type of food.
     */
    public static final String TYPE = "Pasta";

    /**
     * An integer representation of the cost of the food.
     */
    public static final int COST = 30;

    /**
     * An integer representation of the hunger level the food gives.
     */
    public static final int HUNGER_LEVEL = 60;

    /**
     * Pasta Constructor
     */
    Pasta() {
        super(TYPE, COST, HUNGER_LEVEL);
    }
}

/**
 * Instances of Food represent all the food in the game.
 * Each food has a cost, hunger level and a count
 * The count is what is used to determine how many of that item
 * are in the inventory.
 */
public class Food {

    /**
     * A string representation of the type of food.
     */ 
	private String type;

    /**
     * An integer representation of the cost of food.
     */ 
    private int cost;

    /**
     * An integer representation of the hunger it reduces.
     */ 
    private int hungerLevel;

    /**
     * An integer representation of the count of how many items are in inventory.
     */ 
	private int count;
	
    /**
     * Food constructor
     * @param type String of the type of food.
     * @param cost Integer of cost of food.
     * @param hunger Integer of how much health is restored.
     */
    Food(String type, int cost, int hunger) {
        this.type = type;
        this.cost = cost;
        this.count = 0;
        this.hungerLevel = hunger;
    }

    /**
     * Empty Food constructor
     */
    Food() {}

    /**
     * toString
     * @return String
     */
    public String toString() {
        String ret = this.type + " (" + count + ")\n";
        return ret;
    }

    /**
     * Gets type of food
     * @return type of food
     */
    public String getType() {
        return type;
    }

    /**
     * Gets cost of food
     * @return cost of the food.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Increments the item count
     */
    public void incrementItemCount() {
        count += 1;
    }

    /**
     * Increments the item count
     */
    public void decrementItemCount() {
        count -= 1;
        if (count < 0) {
            count = 0;
        }
    }

    /**
     * Gets count of how many items there are
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Gets hunger level
     * @return hungerlevel
     */
    public int getHungerLevel() {
        return hungerLevel;
    }

    /**
     * Checks if item exists (count > 0)
     * @return true if exists False otherwise
     */
    public boolean exists() {
        if (count > 0) {
            return true;
        }
        return false;
    }
}
