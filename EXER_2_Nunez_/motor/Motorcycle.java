public class Motorcycle {
    private String brand;
    private String model;
    private String color;
    private double engineSize;
    private String fuelType;
    private double price;
    private String type; // e.g., Cruiser, Sport, Touring
    private int year;

    // Default constructor
    public Motorcycle() {
        this.brand = "Unknown Brand";
        this.model = "Unknown Model";
        this.color = "Unknown Color";
        this.engineSize = 0.0;
        this.fuelType = "Unknown Fuel Type";
        this.price = 0.0;
        this.type = "Unknown Type";
        this.year = 0;
    }

    // Parameterized constructor
    public Motorcycle(String brand, String model, String color, double engineSize, String fuelType, double price, String type, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.price = price;
        this.type = type;
        this.year = year;
    }

    // Method to display motorcycle details
    public String displayDetails() {
        String details = "";
        details += "Motorcycle Brand: " + brand + "\n";
        details += "Motorcycle Model: " + model + "\n";
        details += "Motorcycle Color: " + color + "\n";
        details += "Engine Size: " + engineSize + "L\n";
        details += "Fuel Type: " + fuelType + "\n";
        details += "Price: $" + price + "\n";
        details += "Motorcycle Type: " + type + "\n";
        details += "Manufacturing Year: " + year + "\n";
        System.out.println(details);
        return details;
    }
}
