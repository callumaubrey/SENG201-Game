import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class GameEnvironmentTest {
    @Test
    final void nextDay() {
        GameEnvironment environment = new GameEnvironment("team", 2, 3, "ship");
        
        // Add some members
        // Has decrement of 15 and a max health of 80 and rest are set to 100
        environment.getCrew().addCrewMember("Barter", "mybarter");
        
        environment.goToNextDay();
        
        CrewMember barter = environment.getCrew().getMembers().get(0);
        
        assertEquals(85, barter.getTiredness());
        assertEquals(65, barter.getCurrentHealth());
        assertEquals(85, barter.getHungerLevel());

        // Now test if next day kills him
        for (int i = 0; i < 5; i++) {
            environment.goToNextDay();
        }

        assertEquals(0, environment.getCrew().getMembers().size());
    }
    
    @Test
    final void spacePlague() {
        GameEnvironment environment = new GameEnvironment("team", 2, 3, "ship");

        environment.getCrew().addCrewMember("Barter", "mybarter");
        environment.spacePlague();
        
        CrewMember barter = environment.getCrew().getMembers().get(0);
        assertEquals(true, barter.isSick());
        assertEquals(70, barter.getCurrentHealth());
    }
    
    @Test
    final void alienPirates() {
    	GameEnvironment environment = new GameEnvironment("team", 2, 3, "ship");
    	
    	SpaceOutPost outpost = environment.getSpaceOutPost();
    	
    	Food steak = new Steak();
    	outpost.purchaseFood(steak);
    	
    	environment.alienPirates();
    	
    	assertEquals(true, outpost.isInventoryEmpty());
    	assertEquals(false, outpost.foodExists("Steak"));
    	
    	Bandage bandage = new Bandage();
    	outpost.purchaseMedicalSupply(bandage);
    	
    	environment.alienPirates();
    	assertEquals(true, outpost.isInventoryEmpty());
    	assertEquals(false, outpost.medicalSupplyExists("Bandage"));
    }

    @Test
    final void asteroidBelt() {
        GameEnvironment environment = new GameEnvironment("team", 2, 3, "ship");
        
        SpaceShip spaceShip = environment.getSpaceShip();
    
        environment.asteroidBelt();
        assertEquals(50, spaceShip.getShieldHealth());

        environment.asteroidBelt();
        assertEquals(0, spaceShip.getShieldHealth());

        environment.asteroidBelt();
        assertEquals(0, spaceShip.getShieldHealth());
    }

    @Test
    final void shipPieces() {
        GameEnvironment environment = new GameEnvironment("team", 2, 3, "ship");
        
        SpaceShip spaceShip = environment.getSpaceShip();

        spaceShip.addPeice();
        assertEquals(false, spaceShip.allPartsFound());

        spaceShip.addPeice();
        assertEquals(true, spaceShip.allPartsFound());
        
        spaceShip.addPeice();
        assertEquals(2, spaceShip.getPiecesFound());
    }
}