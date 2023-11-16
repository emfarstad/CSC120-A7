import java.util.ArrayList;
//import java.util.Scanner;

public class CampusMap {

    /** An ArrayList of the buildings on the campus map */
    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "1 Chapin Way Northampton, MA 01063"));
        myMap.addBuilding(new Library ("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 5, true));
        myMap.addBuilding(new House("Baldwin", "15 Bedford Terrace Northampton, MA 01063", 5, false, false));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm St Northampton, MA 01063", 3, true));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green St Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Ziskind", "1 Henshaw Ave Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063"));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Smith College Museum of Art", "20 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("The Botanic Garden of Smith College", "16 College Ln Northampton, MA 01063", 2));
        myMap.addBuilding(new House("Wilson", "16 Kensington Ave Northampton, MA 01063", 4, true, false));
        System.out.println(myMap);
    }

    /* Below is an idea I am tinkering with to make this class interactive:
    public void navigateCampus() {
        Scanner input = new Scanner(System.in);
        System.out.println("You have entered campus.");
        System.out.print("Would you like to look at a map? (y/n): ");
        String answer = input.next();
        if(answer.equals("y")) {
            System.out.println("Printing map now...");
            System.out.println(this);
        }
        System.out.print("Would you like to explore campus? (y/n): ");
        String loopAnswer = input.next();
        while(loopAnswer.equals("y")) {
            System.out.print("Enter the directory number of the building you would like to explore: ");
            int directoryNum = input.nextInt();
            Building exploreBuilding = this.buildings.get(directoryNum-1);
            System.out.println("You are now exploring " + exploreBuilding.getName() + ".");
            System.out.println("Here are the options for exploring this building...");
            exploreBuilding.showOptions();
            System.out.print("Would you like to explore this building? (y/n): ");
            String explore = input.next();
            while(explore.equals("y")) {
                System.out.print("Enter the option you would like to take: ");
                explore = "n";
            }

            loopAnswer = "n";
            input.close();

        }
    }
    */
    
}
