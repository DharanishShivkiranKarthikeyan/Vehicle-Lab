package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingOdometerValue) {
        super("Ford", "Frivolous", startingOdometerValue, 23.6, 20);
    }

    /** Defaults startingOdometerValue to 0. */
    public FordFrivolous() {
        this(0);
    }

    /** Autonomous driving works like Tesla’s – but it uses twice the
    amount of the gas in comparison to regular driving. Whoops!
    @throws IllegalArgumentException if miles is negative. */
    public void driveAutonomously(double miles) {
        if(miles < 0) {
            throw new IllegalArgumentException();
        }
        if(miles <= getRemainingRange() / 2) {
            OdometerValue += miles;
            decreaseFuelLevel(miles * 2);
        }
        else {
            OdometerValue += getRemainingRange() / 2;
            decreaseFuelLevel(getRemainingRange());
        }
    }

    /** Same as for Chevrolet Bird. */
    public boolean canFly(double miles) {
        if(miles < 0) {
            throw new IllegalArgumentException();
        }
        return getRemainingRange() / 3 >= miles;
    }

    /** Same as for Chevrolet Bird except the Ford Frivolous doesn’t need
    wings to fly! But, flying uses triple the amount of gas as driving,
    per mile traveled. Ouch! */
    public void fly(double miles) {
        if(miles < 0 || miles > getRemainingRange() / 3) {
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(miles);
    }
}
