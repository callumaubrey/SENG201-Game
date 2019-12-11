import java.util.ArrayList;

/**
 * The Crew object handles all the crew members and the actions they can do
 * Only one instance of Crew is used during the game and that is in 
 * the GameEnvironment object.
 *
 */
public class Crew {

    /**
     * A string representation of the name of the crew
     */
    private String name;
    
    /**
     * An integer representation of the number of crew members
     */
    private int numMembers;

    /**
     * An array list of CrewMember instances
     */
    private ArrayList<CrewMember> members = new ArrayList<CrewMember>();

    /**
     * Crew constructor
     * @param name A string representation of the crew name
     * @param numMembers A integer representation of the number of members wanted
     */
    Crew(String name, int numMembers) {
        this.name = name;
        this.numMembers = numMembers;
    }

    /**
     * Adds a crew member to the array list
     * @param type A string representation of the type that calls the relevant subclass
     * @param name A string representation of the name of the crew member
     */
    public void addCrewMember(String type, String name) {
        switch (type) {
            case "Barter":
                members.add(new Barter(name));
            break;
            case "Mechanic":
                members.add(new Mechanic(name));
            break;
            case "Nerd":
                members.add(new Nerd(name));
            break;
            case "Scout":
                members.add(new Scout(name));
            break;
            case "Soldier":
                members.add(new Soldier(name));
            break;
            case "Medic":
                members.add(new Medic(name));
            break;
            default:
                throw new RuntimeException("Invalid member type");
        }
    }

    /**
     * Makes a crew member sick
     * @param member The crew member
     */
    public void makeMemberSick(CrewMember member) {
        member.makeSick();
    }

    /**
     * Makes a crew member sleep.
     * @param member The crew member
     */    
    public void makeMemberSleep(CrewMember member) {
        member.sleep();
        member.removeAction();
    }

    /**
     * Kills a crew member.
     * @param member The crew member
     */    
    public void killMember(CrewMember member) {
        member.kill();
    }

    /**
     * Checks if there are at least one member that is still alive
     * @return boolean
     */
    public boolean hasMembers() {
        boolean hasMembers = false;
        for (CrewMember member: getMembers()) {
            if (member.isAlive()) {
                hasMembers = true;
            }
        }
        return hasMembers;
    }

    /**
     * Gets an array list of all non sick crew members
     * @return allNonInfectedMembers A CrewMember array list of all non sick members
     */
    public ArrayList<CrewMember> getAllNonSickMembers() {
        ArrayList<CrewMember> allNonInfectedMembers = new ArrayList<CrewMember>();
        for (CrewMember member: getMembers()) {
            if (member.isAlive() && !member.isSick()) {
                allNonInfectedMembers.add(member);
            }
        }
        return allNonInfectedMembers;
    }

    /**
     * Makes all crew members tired - used for a random event
     */
    public void makeAllMembersTired() {
        for (CrewMember member: getMembers()) {
            member.decrementTiredness(10);
        }
    }

    /**
     * Checks if number of members specified earlier in the game is within valid parameters
     * @return boolean
     */
    public boolean isValidNumMembers() {
        if (numMembers >= 2 && numMembers <= 4) {
            return true;
        }
        return false;
    }

    /**
     * Gets crew members
     * @return members array list of current members in the game
     */
    public ArrayList<CrewMember> getMembers() {
        ArrayList<CrewMember> nonSickMembers = new ArrayList<CrewMember>();
        for (CrewMember member: members) {
            if (member.isAlive()) {
                nonSickMembers.add(member);
            }
        }
        return nonSickMembers;
    }
    
    /**
     * Gets members by name specified
     * @param name A string of the name to match match crew member
     * @return emptyCrewMember | member An empty instance of Crew Member or 
     *                          the crew member that matches the name given
     */
    public CrewMember getMemberByName(String name) {
    	CrewMember emptyCrewMember = new CrewMember();
    	for (CrewMember member: getMembers()) {
    		if (member.isAlive() && name.equals(member.getName())) {
    			return member;
    		}
    	}
    	return emptyCrewMember;
    }
    
    /**
     * Gets number of members
     * @return numMembers An integer of number of members
     */
    public int getNumMembers() {
    	return numMembers;
    }
}