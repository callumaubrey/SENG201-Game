import java.util.Random;
import java.time.LocalTime;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Math;

/**
 * The GameEnvironment instance carrys all the games data.
 * This is the most important class for the game
 * It holds a Crew instance, SpaceShip, SpaceOutPost and Planet instance
 * It also does all the random events and determines the day
 */
public class GameEnvironment {

    /**
     * The crew which holds all the crew members and their data.
     */
    private Crew crew;

    /**
     * An integer representation of the number of days.
     */
    private int numDays;

    /**
     * The Space Ship. Holds all information regarding the spaceship.
     */
    private SpaceShip spaceShip;
    
    /**
     * The space out post which holds all the medical supplies and foods
     */
    private SpaceOutPost spaceOutPost;

    /**
     * A planet object for the curent planet.
     */
    private Planet currentPlanet;

    /**
     * The planet object.
     */
    private Planet planet;

    /**
     * An integer for the current day
     */
    private int currentDay;
    
    /**
     * An integer for the number of days specified by the player.
     */
    private int maxDays;

    /**
     * An integer of all the gold found, to help produce a score.
     */
    private int goldFound;

    public boolean allAreDead = false;
	
    /**
     * GameEnvironment constructor
     * @param teamName
     * @param numMembers
     * @param numDays
     * @param shipName
     */
    GameEnvironment(String teamName, int numMembers, int numDays, String shipName) {
    	this.crew = new Crew(teamName, numMembers);
    	this.spaceShip = new SpaceShip(shipName, numDays);
    	this.numDays = numDays;
    	this.spaceOutPost = new SpaceOutPost();
    	this.currentDay = 1;
        this.maxDays = numDays;
    	findStartingPlanet();
        this.planet = new Planet();
    }
    
    /**
     * Checks if current day is less than or equal to num days
     * @return boolean
     */
    public boolean isValidCurrentDay() {
        if (currentDay < maxDays) {
            return true;
        }
        return false;
    }
    
    /**
     * Finds the starting planet
     */
    private void findStartingPlanet() {
        // Randomized event to find starting planet
        Random rand = new Random();
        double randNum = rand.nextDouble();
        if (randNum < 0.16) {
            currentPlanet = new Earth();
        } else if (randNum >= 0.16 && randNum < 0.33) {
            currentPlanet = new Mars();
        } else if (randNum >= 0.33 && randNum < 0.49) {
            currentPlanet = new Mercury();
        } else if (randNum >= 0.49 && randNum < 0.66) {
            currentPlanet = new Venus();
        } else if (randNum >= 0.66 && randNum < 0.83) {
            currentPlanet = new Saturn();
        } else {
            currentPlanet = new Jupiter();
        }
    }

    /**
     * Checks if defeated - last day and no crew actions
     */
    public boolean isDefeated() {
        if (hasDaysLeft()) {
            return false;
        }
        
        boolean isDefeated = true;
        for (CrewMember member: crew.getMembers()) {
            if (member.isAlive() && member.hasActionsLeft()) {
                isDefeated = false;
            }
        }
        return isDefeated;
    }

    /**
     * Searchs planet for space parts
     * @return String the part found
     */
    public String searchPlanetForParts() {
        Random random = new Random();

        String returnStr = "";

        int randomAction = random.nextInt(4);
        if (randomAction == 4) {
            returnStr = "You have found nothing";
        }

        if (randomAction == 0) {
            if (!spaceShip.allPartsFound() && !currentPlanet.transporterPartFound()) {
                spaceShip.addPeice();
                currentPlanet.foundTransporterPart();
                returnStr = "You have found a transporter part";
            } else {
                returnStr = "Go travel to another planet to find a transporter part";
            }
        }

        if (randomAction == 1) {
            // Food.
            int foodIndex = random.nextInt(spaceOutPost.getFoods().size());
            Food foodFound = spaceOutPost.getFoods().get(foodIndex);
            foodFound.incrementItemCount();
            returnStr = "You have found food: " + foodFound.getType();
        }

        if (randomAction == 2) {
            // Medical supply
            int medicalSupplyIndex = random.nextInt(spaceOutPost.getMedicalSupplies().size());
            MedicalSupply medicalItemFound = spaceOutPost.getMedicalSupplies().get(medicalSupplyIndex);
            medicalItemFound.incrementItemCount();
            returnStr = "You have found a medical supply: " + medicalItemFound.getType();
        }

        if (randomAction == 3) {
            // Increment money randomly
            int randIncrement = random.nextInt(50);
            if (randIncrement == 0) {
                randIncrement = 1;
            }
            goldFound += randIncrement;
            spaceOutPost.incrementMoney(randIncrement);
            returnStr = "You have found money: $" + randIncrement;
        }

        return returnStr;
    }
    
    /**
     * Determines the random event to occur
     * @return randomEvent If 1 its alien pirates, if 2 its space plague and so on
     */
    public int determineRandomEvent() {
        Random random = new Random();
        double randomNumber = random.nextDouble();
        int randomEvent;
        // Random events can only be Alien Pirates and Space Plague
        if (randomNumber < 0.5) {
            randomEvent = 1;
            alienPirates();
        } else {
            randomEvent = 2;
            spacePlague();
        }

        return randomEvent;
    }

    /**
     * Does the alien pirates random event
     * Steals somethhing from your inventory
     */
    public void alienPirates() {
        // If outpost is not empty
        if (!spaceOutPost.isInventoryEmpty()) {
            // Get all array lists of foods and medical supplies owned
            ArrayList<MedicalSupply> medicalSuppliesOwned = new ArrayList<MedicalSupply>();
            for (MedicalSupply m: spaceOutPost.getMedicalSupplies()) {
                if (m.exists()) {
                    medicalSuppliesOwned.add(m);
                }
            }

            ArrayList<Food> allFoodsOwned = new ArrayList<Food>();
            for (Food f: spaceOutPost.getFoods()) {
                if (f.exists()) {
                    allFoodsOwned.add(f);
                }
            }

            // Random event of 1 or 2 to see if we are stealing meds or foods
            Random random = new Random();
            int medOrFood = random.nextInt(2);
            if (medOrFood == 1) {
                if (medicalSuppliesOwned.size() > 0) {
                    stealMedicalSupply(medicalSuppliesOwned);
                } else {
                    stealFood(allFoodsOwned);
                }
            } else {
                if (allFoodsOwned.size() > 0) {
                    stealFood(allFoodsOwned);
                } else {
                    stealMedicalSupply(medicalSuppliesOwned);
                }
            }
        }
    }

    /**
     * Steals food from space out post
     * @param allFoodsOwned An array list of all foods that are owned.
     */
    private void stealFood(ArrayList<Food> allFoodsOwned) {
        Random random = new Random();
        int itemIndex = random.nextInt(allFoodsOwned.size());
        Food foodToRemove = allFoodsOwned.get(itemIndex);
        spaceOutPost.removeFood(foodToRemove);
    }

    /**
     * Steals medical supply from space out post
     * @param medicalSuppliesOwned An array list of all medical supplies that are owned.
     */
    private void stealMedicalSupply(ArrayList<MedicalSupply> medicalSuppliesOwned) {
        Random random = new Random();
        int itemIndex = random.nextInt(medicalSuppliesOwned.size());
        MedicalSupply medToRemove = medicalSuppliesOwned.get(itemIndex);
        spaceOutPost.removeMedicalSupply(medToRemove);
    }

    /**
     * Does the space plague random event
     */
    public void spacePlague() {
        Random random = new Random();

        if (crew.hasMembers()) {
            ArrayList<CrewMember> allNonInfectedMembers = crew.getAllNonSickMembers();

            if (allNonInfectedMembers.size() > 0) {
                int count = random.nextInt(allNonInfectedMembers.size());
                if (count == 0) {
                    count = 1;
                }

                for (int i = 0; i < count; i++) {
                    ArrayList<CrewMember> allNonInfectedMembersNew = crew.getAllNonSickMembers();
                    int itemIndex = random.nextInt(allNonInfectedMembersNew.size());
                    CrewMember infectedMember = allNonInfectedMembersNew.get(itemIndex);

                    if (!infectedMember.isSick()) {
                        infectedMember.makeSick();
                        if (infectedMember.decrementCurrentHealthForSpacePlague()) {
                            infectedMember.kill();
                        }
                    }
                }
            }
        }
    }

    /**
     * Determines the chances of getting an asteroid belt 20%
     * @return boolean True if asteroid belt False otherwise
     */
    public boolean doAsteroidBelt() {
        Random random = new Random();
        double randomNumber = random.nextDouble();

        boolean returnBool = false;
        if (randomNumber > 0.7) {
            asteroidBelt();
            returnBool = true;
        }
        return returnBool;
    }

    /**
     * Asteroid belt
     * Decreases shield health by 50
     */
    public void asteroidBelt() {
        spaceShip.decreaseShieldLevel(50);
        int shieldLevel = spaceShip.getShieldHealth();
    }
    
    /**
     * Goes to next day if possible
     * Decreases members tiredness, hunger and health by decrement
     * Decreases member health more if they are sick
     * Removes member from array list if no health left.
     */
    public void goToNextDay() {
        currentDay++;
        for (CrewMember member: crew.getMembers()) {
            if (member.isAlive()) {
                if (member.getTiredness() > member.getDecrement()) {
                    member.decrementTiredness(member.getDecrement());
                } else {
                    member.setTiredness(0);
                }

                if (member.getHungerLevel() > member.getDecrement()) {
                    member.decrementHungerLevel(member.getDecrement());
                } else {
                    member.setHungerLevel(0);
                }

                if (member.getCurrentHealth() > member.getDecrement()) {
                    member.decrementCurrentHealth(member.getDecrement());
                } else {
                    member.kill();
                }

                member.resetActions();
                if (member.isSick()) {   
                    if (member.decrementCurrentHealthForSpacePlague()) {
                        member.kill();
                    }
                }
            }
        }
    }

    /**
     * Produces the score
     * @param isDefeated
     * @return score The score as an integer
     */
    public int getScore(boolean isDefeated) {
        int score = (getNumDays() - getCurrentDay()) * 10;
        if (!isDefeated) {
            score += 100;
        }
        score += getGoldFound();
        return score;
    }

    /**
     * Checks if there are days left
     * @return boolean
     */
    public boolean hasDaysLeft() {
        if (currentDay == numDays) {
            return false;
        }
        return true;
    }
    
    /**
     * Gets the current planet
     * @return currentPlanet
     */
    public Planet getCurrentPlanet() {
    	return currentPlanet;
    }
    
    /**
     * Gets planet object
     * @return planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * Changes current planet
     * @param planet New planet to change to
     */
    public void changeCurrentPlanet(Planet planet) {
        this.currentPlanet = planet;
    }

    /**
     * Gets current day
     * @param currentDay The current day
     */
    public int getCurrentDay() {
    	return currentDay;
    }
    
    /**
     * Gets number of days
     * @param numDays The number of day
     */
    public int getNumDays() {
    	return numDays;
    }
    
    /**
     * Initalises space ship
     * @param spaceShip The space ship object.
     */
    public void setSpaceShip(SpaceShip spaceShip) {
    	this.spaceShip = spaceShip;
    }
    
    /**
     * Gets the space ship
     * @return spaceShip
     */
    public SpaceShip getSpaceShip() {
    	return spaceShip;
    }
    
    /**
     * Gets the space out post
     * @return spaceOutPost
     */
    public SpaceOutPost getSpaceOutPost() {
    	return spaceOutPost;
    }
    
    /**
     * Gets the crew
     * @return crew
     */
    public Crew getCrew() {
    	return this.crew;
    }

    /**
     * Returns gold found
     * @return goldFound
     */
    public int getGoldFound() {
        return goldFound;
    }
}
