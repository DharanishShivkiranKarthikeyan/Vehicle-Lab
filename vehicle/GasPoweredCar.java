package vehicle;

public class GasPoweredCar extends Car{
   /** Note: Start with a full tank of gas
@throws IllegalArgumentException if mpg or fuelCapacityGallons are
non-positive. */
public GasPoweredCar(String make, String model, double
startingOdometerValue, double mpg, double fuelCapacityGallons)
/** Defaults startingOdometerValue to 0.
@throws IllegalArgumentException if mpg or fuelCapacityGallons are
non-positive. */
public GasPoweredCar (String make, String model, double mpg, double
fuelCapacityGallons)
/** Drives the full given number of miles.
@throws IllegalArgumentException if miles is negative.
@throws IllegalArgumentException if miles is too high given the
current fuel.*/
public void drive(double miles)
/** Returns how many miles can be driven on one gallon of gas. */
public double getMPG()
/** Returns how many gallons of fuel are currently in the car. */
public double getFuelLevel()
/** Returns how many gallons of fuel the car can hold at max. */
public double getFuelCapacity()
/** Refuels the car to max fuel capacity. */
public void refillTank()
/** Returns how many more miles the car can currently go without
refueling. */
public double getRemainingRange()
/** Attempt to refuel the car with additional gallons.
@throws IllegalArgumentException if gallons is negative OR gallons
would overfill the tank. */
public void refillTank(double gallons)
/** Decreases the amount of fuel in the gas tank based upon
mpg and the number of miles passed as an argument. */
protected void decreaseFuelLevel(double miles); 
}
