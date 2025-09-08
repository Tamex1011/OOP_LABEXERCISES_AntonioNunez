public class MotorcycleTester {
    public static void main(String[] args) {
        // Create Motorcycle objects using the parameterized constructor
        Motorcycle motorcycle1 = new Motorcycle("Yamaha", "MT-09", "Blue", 0.847, "Petrol", 8499.99, "Sport", 2022);
        Motorcycle motorcycle2 = new Motorcycle("Honda", "CBR600RR", "Red", 0.599, "Petrol", 11999.99, "Sport", 2021);

        // Display details for both motorcycles
        motorcycle1.displayDetails();
        motorcycle2.displayDetails();
    }
}
