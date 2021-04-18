import java.util.Objects;

/**
 * Base class that represents vehicles.
 * @author Stibel, Kalin
 *
 */
public class Vehicle {
    private String type, engineType;
    private float fuelCapacity;
    private int crew;
    private int passengerCapacity;
    private int range;
    private boolean manned;
    /**
     * Message of an Exception thrown when invalid values where given to the constructor.
     * Created for test purpose.
     */
    public static final String constructorExceptionMessage = "Vehicle arguments must be >= 0";

    /**
     * Creates an Vehicle and sets it's private members to given arguments
     * @param type Type of the vehicle
     * @param engineType Type of the engine
     * @param fuelCapacity Capacity of the fuel
     * @param manned Manned by human
     * @param crew Number of crewman
     * @param passengerCapacity Number of possible passengers
     * @param range Number describing how far the vehicle can go
     */
    public Vehicle(String type, String engineType, float fuelCapacity, boolean manned, int crew, int passengerCapacity, int range) {
        if(crew < 0 || fuelCapacity <= 0 || passengerCapacity < 0 || range <= 0)
            throw new IllegalArgumentException(constructorExceptionMessage);

        this.type = type;
        this.engineType = engineType;
        this.fuelCapacity = fuelCapacity;
        this.manned = manned;
        this.crew = manned ? crew : 0;
        this.passengerCapacity = passengerCapacity;
        this.range = range;
    }

    /**
     * Checks if given object is equal to this one.
     * @param o Object to compare
     * @return True when values matches false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Float.compare(vehicle.getFuelCapacity(), getFuelCapacity()) == 0 && getCrew() == vehicle.getCrew() && getPassengerCapacity() == vehicle.getPassengerCapacity() && getRange() == vehicle.getRange() && isManned() == vehicle.isManned() && getType().equals(vehicle.getType()) && getEngineType().equals(vehicle.getEngineType());
    }

    /**
     * Counts the has for the object
     * @return Hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getEngineType(), getFuelCapacity(), getCrew(), getPassengerCapacity(), getRange(), isManned());
    }


    /**
     * Converts object to human-readable text
     * @return Human-readable text
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("This is " + (manned ? "a manned " : "an unmanned ") + type +
                ". Driven by a " + engineType + " engine. ");

        if (manned) {
            sb.append("It is operated by a crew of ").append(crew).append('.');
        }
        sb.append(" It carries ").append(passengerCapacity).append(" people. With a full tank (")
                .append(fuelCapacity).append(" litres) it can travel up to ").append(range).append(" kilometers.");
        return sb.toString();
    }

    /**
     * Calculates how efficient the vehicle is.
     * @return Fuel by kilometer
     */
    public float calculateEfficiency() {
        float eff = fuelCapacity / range;
        System.out.println("One liter of fuel is enough to travel " + Float.toString(eff) + " kilometers.");
        return eff;
    }

    /**
     * Enable the self-drive mode
     */
    public void autonomize() {
        this.setCrew(0);
        this.setManned(false);
    }

    /**
     * Calculates how many passengers are for each crewman.
     */
    public void ratio() {
        if (manned) {
            float ratio = (float)this.passengerCapacity / this.crew;
            System.out.println("For every crew member there are " + Float.toString(ratio) + " passengers.");
            return;
        }
        System.out.println("This is an unmanned vehicle, hence there are only passengers.");

    }

    /**
     * Returns information about how vehicle is manned.
     * @return True when crew-manned, false otherwise
     */
    public boolean isManned() {
        return manned;
    }

    /**
     * Sets manned to given value
     * @param manned True for crew, false otherwise
     */
    public void setManned(boolean manned) {
        this.manned = manned;
    }

    /**
     * Returns information about the passenger capacity.
     * @return Number of possible passengers
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Sets passenger capacity to given value
     * @param passengerCapacity Number greater or equal to 0
     */
    public void setPassengerCapacity(int passengerCapacity) {
        if(passengerCapacity < 0)
            throw new IllegalArgumentException("Passenger capacity must be >= 0");
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Returns information about crew number
     * @return Number of the crewman
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Sets number of crew to given.
     * @param crew Number greater or equal to 0.
     */
    public void setCrew(int crew) {
        if(crew < 0)
            throw new IllegalArgumentException("Crew must be >= 0");
        this.crew = crew;
    }

    /**
     * Returns information about the range that vehicle can travel.
     * @return Range value.
     */
    public int getRange() {
        return range;
    }

    /**
     * Sets range to given value.
     * @param range Number greater than 0.
     */
    public void setRange(int range) {
        if(range <= 0)
            throw new IllegalArgumentException("Range must be > 0");
        this.range = range;
    }

    /**
     * Returns the information about the engine type.
     * @return String describing engine type.
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Sets engine type to given value
     * @param engineType Type of the engine
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Returns the capacity of the fuel.
     * @return Number of the fuel capacity
     */
    public float getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the fuel capacity to given value.
     * @param fuelCapacity Number greater than 0.
     */
    public void setFuelCapacity(float fuelCapacity) {
        if(fuelCapacity <= 0)
            throw new IllegalArgumentException("Fuel capacity must be > 0");
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * Returns the type of the vehicle.
     * @return String describing vehicle type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the vehicle to given.
     * @param type String describing vehicle type.
     */
    public void setType(String type) {
        this.type = type;
    }
}