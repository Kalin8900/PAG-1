public class Plane extends Vehicle{
    private String name, purpose;
    private float wingSpan, height, length, mass;
    private int maxAltitude;

    public Plane(String type, String engineType, float fuelCapacity, boolean manned, int crew, int passengerCapacity, int range,
                 String name, String purpose, float wingSpan, float height, float length, float mass, int maxAltitude) {
        super(type, engineType, fuelCapacity, manned, crew, passengerCapacity, range);
        this.name = name;
        this.purpose = purpose;
        this.wingSpan = wingSpan;
        this.height = height;
        this.length = length;
        this.mass = mass;
        this.maxAltitude = maxAltitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public float getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(float wingSpan) {
        this.wingSpan = wingSpan;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }
}
