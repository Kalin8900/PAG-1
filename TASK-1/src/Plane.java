import java.util.Objects;

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

    //overloaded constructor to make testing easier
    public Plane(String[] args) {
        super(args[0], args[1], Float.parseFloat(args[2]), Boolean.parseBoolean(args[3]), Integer.parseInt(args[4]),
                Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        this.name = args[7];
        this.purpose = args[8];
        this.wingSpan = Float.parseFloat(args[9]);
        this.height = Float.parseFloat(args[10]);
        this.length = Float.parseFloat(args[11]);
        this.mass = Float.parseFloat(args[12]);
        this.maxAltitude = Integer.parseInt(args[13]);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Float.compare(plane.getWingSpan(), getWingSpan()) == 0 && Float.compare(plane.getHeight(), getHeight()) == 0 && Float.compare(plane.getLength(), getLength()) == 0 && Float.compare(plane.getMass(), getMass()) == 0 && getMaxAltitude() == plane.getMaxAltitude() && getName().equals(plane.getName()) && getPurpose().equals(plane.getPurpose());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getPurpose(), getWingSpan(), getHeight(), getLength(), getMass(), getMaxAltitude());
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
