public class Vehicle {

    private String type, engineType;
    private float fuelCapacity;
    private int crew;
    private int passengerCapacity;
    private int range;
    private boolean manned;

    public Vehicle(String type, String engineType, float fuelCapacity, boolean manned, int crew, int passengerCapacity, int range) {
        this.type = type;
        this.engineType = engineType;
        this.fuelCapacity = fuelCapacity;
        this.manned = manned;
        this.crew = manned ? crew : 0;
        this.passengerCapacity = passengerCapacity;
        this.range = range > 0 ? range : 1;
    }

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

    public void calculateEfficiency() {
        float eff = fuelCapacity / range;
        System.out.println("One liter of fuel is enough to travel " + Float.toString(eff) + "kilometers.");
    }

    public void autonomize() {
        this.crew = 0;
        this.manned = false;
    }

    public void ratio() {
        if (manned) {
            float ratio = (float)this.passengerCapacity / this.crew;
            System.out.println("For every crew member there are " + Float.toString(ratio) + " passengers.");
            return;
        }
        System.out.println("This is an unmanned vehicle, hence there are only passengers.");

    }

    public boolean isManned() {
        return manned;
    }

    public void setManned(boolean manned) {
        this.manned = manned;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}