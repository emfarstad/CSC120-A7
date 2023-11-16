/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a cafe with the Building super constructor parameters and sets the values int nCoffeeOunces, int nSugarPackets, int nCreams, and int nCups
     * @param name String name of the cafe  
     * @param address String address of the cafe
     * @param nFloors int number of floors in the cafe
     * @param nCoffeeOunces int ounces of coffee in stock
     * @param nSugarPackets int number of sugar packets in stock
     * @param nCreams int number of creams in stock
     * @param nCups int number of coffee cups in stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded constructor that constructs a basic cafe usin the Building super constructor with a name, address, one floor, and a hard-coded amount of stocked products
     * @param name String name of the cafe
     * @param address String address of the cafe
     */
    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = 120;
        this.nSugarPackets = 20;
        this.nCreams = 20;
        this.nCups = 30;
    }

    /**
     * Restocks the amounts for nCoffeeOunces, nSugarPackes, nCreams, and nCups 
     * @param nCoffeeOunces int ounces of coffee added to the nCoffeeOunces stock
     * @param nSugarPackets int number of sugar packets added to the nSugarPackes stock
     * @param nCreams int number of creams added to the nCreams stock
     * @param nCups int number of cups added to the nCups stock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Decreases the stock of nCoffeeOUnces nSugarPackets, and nCreams by the amounts stated in the parameters, decreases nCups by one, and restocks the supply of all items if any of the values are less than 0
     * @param size int ounces of coffee decreased from nCoffeeOunces
     * @param nSugarPackets int number of sugar packets decreased from nSugarPackets
     * @param nCreams int number of creams decreased from nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(size <= 0 || nSugarPackets < 0 || nCreams < 0) {
            throw new RuntimeException("The values entered are less than zero, this order cannot be completed.");
        }
        
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            this.restock(100, 20, 20, 20);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;
    }

    /**
     * Overloaded sellCoffee() method that sells a "typical" coffee, decreasing the stock  of nCoffeeOUnces by 12, nSugarPackets by 1, and nCreams by 1
     */
    public void sellCoffee() {
        this.sellCoffee(12, 1, 1);
    }

    /**
     * Prints the current values for nCoffeeOunces, nSugarPackets, nCreams, and nSugars
     */
    public void printStock() {
        System.out.println("Ounces of coffee: " + this.nCoffeeOunces + "\nSugar packes: " + nSugarPackets + "\nCreams: " + nCreams + "\nCups: " + nCups);
    }

    /**
     * Prints an overridden showOptions() method containing the methods of the Building class and the public methods of the Cafe class 
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("\n + sellCoffee(size, sugarPackets, creams) \n + sellCoffee() \n + printStock()");
    }
    
    /**
     * An overridden goToFloor(int floorNum) method that does not allow the user to move up or down from the first floor
     */
    public void goToFloor(int floorNum) {
        if(floorNum == this.activeFloor) {
            super.goToFloor(floorNum);
        }
        throw new RuntimeException("This floor is not accessible to customers.");
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", null, 3, 100, 30, 20, 7);
        campusCenter.printStock();
        campusCenter.sellCoffee(20, 2, 1);
        System.out.println(campusCenter);
        campusCenter.printStock();
        campusCenter.sellCoffee(90, 0, 0);
        campusCenter.printStock();
        campusCenter.enter();
        //campusCenter.goUp();
        campusCenter.goToFloor(1);
       //campusCenter.showOptions();
    }
    
}
