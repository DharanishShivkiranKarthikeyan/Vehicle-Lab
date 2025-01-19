package vehicle;

public abstract class ElectricCar extends Car{
   
    public double milesOnMaxCharge;
    public double currentMiles;
   
    /** Note: Car begins with a full charge (and thus range).
@throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/

public ElectricCar(String make, String model, double startingOdometerValue, double milesOnMaxCharge){
    
    super(make, model, startingOdometerValue);
    if(startingOdometerValue < 0){
        throw new IllegalArgumentException("odometer must be positive ");
    }

    if(milesOnMaxCharge <= 0) {
        throw new IllegalArgumentException("milesOnMaxCharge must be positive ");
    }
    this.milesOnMaxCharge = milesOnMaxCharge; 
    currentMiles = milesOnMaxCharge;
}
/** Defaults startingOdometerValue to 0.
@throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
public ElectricCar (String make, String model, double milesOnMaxCharge){
    super(make, model);
    if(milesOnMaxCharge <= 0) {
        throw new IllegalArgumentException("milesOnMaxCharge must be positive ");
    }
    this.milesOnMaxCharge = milesOnMaxCharge; 
    this.currentMiles = milesOnMaxCharge;

}
/** Drives the full given number of miles.
@throws IllegalArgumentException if miles is negative.
@throws IllegalArgumentException if miles is too high given the
current charge.*/
public void drive(double miles){

    if(miles < 0){
        throw new IllegalArgumentException("miles is negative ");
    }
    if(!super.canDrive(miles)){
        throw new IllegalArgumentException("out of range");
    }
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
    if (miles < 0) {
        throw new IllegalArgumentException("Miles cannot be negative");
    }
    currentMiles -= miles;
    if (currentMiles < 0) {
        throw new IllegalArgumentException("Not enough charge");
    }
}


}