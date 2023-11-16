/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building{
  /**A list of the residents represented as an ArrayList of Strings*/
  private ArrayList<String> residents;
  /**A boolean of whether or not the house has a dining room */
  private boolean hasDiningRoom;
  /**A boolean of whether or not the house has an elevator */
  private boolean hasElevator;

  /**
   * Constructs a house using the Building super constructor parameters and boolean hasDiningRoom, and initializes the residents ArrayList
   * @param name String name of the house
   * @param address String address of the house
   * @param nFloors int number of floors in the hosue
   * @param hasDiningRoom Boolean if the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * An overloaded constructor creating a house of a specified name, address, and number of floors using the super constructor that has an elevator, and no dining room
   * @param name String name of the house
   * @param address String house's address
   * @param nFloors int number of floors in the house
   */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.hasDiningRoom = false;
    this.hasElevator = true;
    this.residents = new ArrayList<>();
    System.out.println("You have converted a building to a house: 🏠");
  }

  /**
   * An overloaded constructor that creates a house with a given name and nFloors, a null address, a dining room, and an elevator
   * @param name String assigned name of the house
   * @param nFloors int number of floors the house will have
   */
  public House(String name, int nFloors) {
    super(name, null, nFloors);
    this.hasDiningRoom = true;
    this.hasElevator = true;
    this.residents = new ArrayList<>();
    System.out.println("You have created the blueprint for a new house. Construction will start soon!");
  }

  /**
   * Returns true or false depending on if the house has a dining room
   * @return boolean true/false if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the int number of residents
   * @return int number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds the String name to the residents ArrayList for the house
   * @param name String name added to the residents ArrayList
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**
   * Removes the String name resident from the residents ArrayList for the house if the String name is in the residents ArrayList
   * @param name String name removed from the residents ArrayList
   * @return a message saying that the String name has been removed from the house
   */
  public String moveOut(String name) {
    if(!residents.contains(name)) {
      throw new RuntimeException(name + " does not live in this house.");
    }
    residents.remove(name);
    return "Resident " + name + " has moved out of " + this.getName() + ".";
  } // return the name of the person who moved out

  /**
   * Returns true or false depending on if String person is a resident of the house
   * @param person String name checked to see if it is contained in the residents ArrayList  
   * @return Boolean true/false if the String person is a resident of the house 
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * Modified toString() method specifying the number of residents in the house and if there is a dining room
   * @return String message about the house's name, adress, number of floors, number of residents, and if there is a dining room
   */
  public String toString() {
    String diningRoom = "does not have";
    if(this.hasDiningRoom()) {
      diningRoom = "has";
    }
    return super.toString() + " that " + diningRoom + " a dining room and " + nResidents() + " residents.";
  }

  /**
   * Prints an overridden showOptions() method containing the methods of the Building class and the methods of the House class 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut()\n + isResident()");
  }

  /**
   * An overridden goToFloor(int floorNum) method that checks if the house has an elevator and whether the floorNum input is valid before running 
   */
  public void goToFloor(int floorNum) {
    if(this.hasElevator) {
      super.goToFloor(floorNum);
    } else {
      if (floorNum > this.activeFloor+1 || floorNum < this.activeFloor-1 ) {
          throw new RuntimeException(this.name + " has no elevator. You can only go up or down one floor at a time.");
      }
      super.goToFloor(floorNum);
    }
  }

  public static void main(String[] args) {
    House baldwin = new House("Baldwin", "15 Bedford Terrace Drive", 5, true, false);
    System.out.println(baldwin);
    System.out.println(baldwin.hasDiningRoom());
    System.out.println(baldwin.nResidents());
    baldwin.moveIn("Jordan");
    System.out.println(baldwin);
    System.out.println(baldwin.nResidents());
    System.out.println(baldwin.isResident("Jordan"));
    System.out.println(baldwin.isResident("Johanna"));
    System.out.println(baldwin.moveOut("Jordan"));
    baldwin.showOptions();
    baldwin.enter();
    //baldwin.goUp();
    baldwin.goToFloor(2);
    //baldwin.exit();
    baldwin.goToFloor(1);
    baldwin.exit();

  }

}