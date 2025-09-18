public class WaterTransportation extends Transportation {
    double displacement; // in tons
    double maxRange; // in km
    String hullMaterial;

    public WaterTransportation(String name, int capacity, double speed,
                               double displacement, double maxRange, String hullMaterial) {
        super(name, capacity, speed);
        this.displacement = displacement;
        this.maxRange = maxRange;
        this.hullMaterial = hullMaterial;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Name: " + name +
            ", Capacity: " + capacity +
            ", Speed: " + speed + " km/h" +
            ", Displacement: " + displacement + " t" +
            ", MaxRange: " + maxRange + " km" +
            ", Hull: " + hullMaterial
        );
    }
}


