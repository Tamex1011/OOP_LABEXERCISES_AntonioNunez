public class Submarine extends WaterTransportation {
    double maxDepth; // meters
    int torpedoCount;
    String nuclearBrand; // from diagram note

    public Submarine(String name, int capacity, double speed,
                     double displacement, double maxRange, String hullMaterial,
                     double maxDepth, int torpedoCount, String nuclearBrand) {
        super(name, capacity, speed, displacement, maxRange, hullMaterial);
        this.maxDepth = maxDepth;
        this.torpedoCount = torpedoCount;
        this.nuclearBrand = nuclearBrand;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  MaxDepth: " + maxDepth + " m, Torpedoes: " + torpedoCount + ", NuclearBrand: " + nuclearBrand);
    }
}


