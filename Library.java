/* This is a stub for the Library class */
import java.util.Scanner;
import java.util.Hashtable;

public class Library extends Building{
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * Constructs a library using the Building super constructor and initializes the collection Hashtable
   * @param name String name of the library
   * @param address String address of the library
   * @param nFloors int number of floors in the library
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean> ();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }
  
  /**
   * Overloaded constructor creating a basic library with an unknown name and address, one floor, and no elevator
   */
  public Library() {
    super();
    this.collection = new Hashtable<String, Boolean> ();
    this.hasElevator = false;
  }

  /**
   * Adds a title to the collection Hashtable with an availability value set to true
   * @param title String name of the book being added to the collections Hashtable
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Overloaded addTitle() method that allows the user to enter the desired title to be added after the method is called, and only adds the title if it is not in the collection
   */
  public void addTitle() {
    Scanner input = new Scanner(System.in);
    System.out.print("Input the title would you like to add to " + this.name + " library: ");
    String title = input.nextLine();
    if(!this.containsTitle(title)) {
      this.addTitle(title);
    }
    else {
      System.out.println("This title already belongs to the library and cannot be added again.");
    }
    input.close();
  }
 
  /**
   * Removes a book from the collection Hashtable if that book exists in the collection and returns a message that the book has been removed
   * @param title String name of the book being removed from the collection Hashtable
   * @return String message that the book has been removed from the library's collection
   */
  public String removeTitle(String title) {
    if (!this.containsTitle(title)){
      throw new RuntimeException("This book is not in the library's collection.");
    }
    this.collection.remove(title);
    return title + " has been removed from the " + this.getName() + " library collection.";
  }

  /**
   * Sets the availability value for the book with String title to false if the book is available
   * @param title String name of the book being modified in availability to false
   */
  public void checkOut(String title){
    if(!this.isAvailable(title)) {
      throw new RuntimeException("This book is already checked out.");
    }
    this.collection.replace(title, false);
    System.out.println("You have successfully checked out the book " + title + ".");
  }

  /**
   * Sets the availability value for the book with String title to true if the book is not already available
   * @param title String name of the book being modified in availability to true
   */
  public void returnBook(String title) {
    if(this.isAvailable(title)) {
      throw new RuntimeException("This book is not checked out.");
    }
    this.collection.replace(title, true);
    System.out.println("You have successfully returned the book " + title + ".");
  }

  /**
   * Returns true/false if the title exists in the collection Hashtable
   * @param title String being checked in the collection Hashtable
   * @return true/false if the title is contained in the collection Hashtable
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Returns true/false if the book is available if it exists in the collection Hashtable
   * @param title String title of the book whose collection Hashtable value is being checked
   * @return the boolean availabiility of the title
   */
  public boolean isAvailable(String title) {
    if(!this.containsTitle(title)) {
      throw new RuntimeException("This book is not in the library's collection.");
    }
    return this.collection.get(title);
  }
  
  /**
   * Prints the collection Hashtable with the names of the books and their current availability
   */
  public void printCollection() {
    System.out.println(this.collection);
  }

  /**
   * Prints an overridden showOptions() method containing the methods of the Building class and the methods of the Library class 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("\n + addTitle(title) \n + addTitle() \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + printCollection() \n + isAvailable(title) \n + containsTitle(title)");
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
    Library neilson = new Library("Neilson", null, 4, true);
    System.out.println(neilson);
    neilson.addTitle("Curious George");
    neilson.addTitle();
    neilson.addTitle("The Great Gatsby");
    neilson.printCollection();
    neilson.checkOut("Curious George");
    neilson.printCollection();
    neilson.returnBook("Curious George");
    //neilson.returnBook("Curious George");
    System.out.println(neilson.removeTitle("Curious George"));
    neilson.printCollection();
    //neilson.showOptions();
  }
  
  }