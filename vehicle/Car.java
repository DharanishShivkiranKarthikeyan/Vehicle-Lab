package vehicle;

import java.util.List;

public abstract class Car{
    public double OdometerValue;
    public final String model;
    public final String make;
    
    /** Creates a car with starting total miles on the odometer.
    @throws IllegalArgumentException if startingOdometerValue is
negative*/
    public Car(String make, String model, double startingOdometerValue){
        if(startingOdometerValue < 0){
            throw new IllegalArgumentException();
        }
        else{
            this.OdometerValue = startingOdometerValue;
            this.model = model;
            this.make = make;
        }
    }
    /** Defaults startingOdometerValue to 0. */
        public Car(String make, String model){
            this.make = make;
            this.model = model;   
            this.OdometerValue = 0;
        }
    /** If able to drive the full given number of miles, returns true. If
    not, returns false. (Determination is based upon how far the car can
    drive given the remaining fuel/energy reserves.)
    @throws IllegalArgumentException if miles is negative.*/
    public boolean canDrive(double miles){
        if(miles < 0){
            throw new IllegalArgumentException("miles is negative");
        }
       return getRemainingRange()>miles; //Bro how am i supposed to know how much fuel this jit has and his mileage. I feel like its supposed to be abstract
    }
    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative or if miles is
    too high given the current fuel. */
    public abstract void drive(double miles);
    /** Gives String representation of Car as
    "<make and model> (<miles> mi)"
    Odometer miles should be rounded to 1 decimal place. If miles is a
    whole number, ".0" should still display. */
    public String toString(){
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), OdometerValue);
    }
    /** Returns how many miles have been driven so far (odometer). */
    public double getOdometerMiles(){
        return this.OdometerValue;
    }
    /** Returns the make of the car. */
    public String getMake(){
        return this.make;
    }
    /** Returns the model of the car. */
    public String getModel(){
        return this.model;
    }
    /** Returns how many more miles the car can currently go given the
    remaining fuel/energy reserves. */
    public abstract double getRemainingRange();
    /** Adds miles to the odometer.
    @throws IllegalArgumentException if miles is negative. */
    protected void addMiles(double miles){
        this.OdometerValue += miles;
    }
    /** The car attempts to drive, in order, each of the daily number of
    miles in the list milesEachDay. Once the car cannot drive one of the
    day’s distance, no more days are attempted. Returns the number of
    days successfully driven.
    @throws IllegalArgumentException if miles is negative for any of the
    attempted days. The exception check should occur prior to any driving
    is attempted. */
    public int roadTrip(List<Double> milesEachDay){
        int d = 0;
        double total = 0;
        double range = getRemainingRange();
        for(double i:milesEachDay){
            if (i<0){throw new IllegalArgumentException();}
            if(range-i<0){this.OdometerValue +=total;return d;}
            range -= i;
            total +=i;
            d++;       
        }
        this.OdometerValue+=total;
        return d;
    }
}