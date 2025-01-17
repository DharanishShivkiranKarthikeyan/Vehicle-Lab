package vehicle;

public abstract class ElectricCar extends Car{
   
    public double milesOnMaxCharge;
    public double currentMiles;
   
    /** Note: Car begins with a full charge (and thus range).
@throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/

public ElectricCar(String make, String model, double startingOdometerValue, double milesOnMaxCharge){
    
    super(make, model, startingOdometerValue);
    
    this.milesOnMaxCharge = milesOnMaxCharge; 
    currentMiles = milesOnMaxCharge;

    if(milesOnMaxCharge < 0) {
        throw new IllegalArgumentException("milesOnMaxCharge must be positive ");
    }
}
/** Defaults startingOdometerValue to 0.
@throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
public ElectricCar (String make, String model, double
milesOnMaxCharge){
    super(make, model);
    this.milesOnMaxCharge = milesOnMaxCharge; 
    OdometerValue = 0;
    if(milesOnMaxCharge < 0) {
        throw new IllegalArgumentException("milesOnMaxCharge must be positive ");
    }

}
/** Drives the full given number of miles.
@throws IllegalArgumentException if miles is negative.
@throws IllegalArgumentException if miles is too high given the
current charge.*/
public void drive(double miles){
    currentMiles  = currentMiles - miles;
    OdometerValue+=miles;
}
/** Returns how many more miles the car can currently go without
recharging. */
public double getRemainingRange(){
    return currentMiles;
}
/** Returns how many miles the car could go on a full charge. */
public double getMaxRange(){
    return milesOnMaxCharge;
}
/** Recharges the car to max range capability. */
public void recharge(){
    currentMiles = milesOnMaxCharge;
}
/** Decreases the amount of energy in the battery based by the number
of miles passed as an argument. */
protected void decreaseCharge(double miles){
    milesOnMaxCharge = milesOnMaxCharge - miles;
}


}