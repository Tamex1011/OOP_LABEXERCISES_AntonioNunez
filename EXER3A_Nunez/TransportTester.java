public class Tester {
    public static void main(String[] args) {
        LandTransportation suv = new SUV("Family SUV", 7, 200.0, 4, "Gasoline", "Road", "Toyota", "Fortuner", "4x4");
        LandTransportation truck = new Truck("Hauler", 3, 140.0, 6, "Diesel", "Road", 12.0, "Volvo", 3);
        LandTransportation motorcycle = new Motorcycle("Sport Bike", 2, 220.0, 2, "Gasoline", "Road", "600cc", "Sport", "Yamaha");
        LandTransportation tricycle = new Tricycle("Commuter Trike", 3, 60.0, 3, "Gasoline", "Road", true, "Red");
        LandTransportation kariton = new Kariton("Wooden Kariton", 1, 10.0, 2, "Human", "Road", "Wood", 25.0, "Rubber");

        AirTransportation airplane = new Airplane("Boeing 737", 180, 850.0, 12000.0, "JetA1", 35.8, "AirCo", 2);
        AirTransportation helicopter = new Helicopter("Rescue Heli", 6, 260.0, 3000.0, "Avgas", 14.6, "MainRotor", 5);

        WaterTransportation ship = new Ship("Cargo Ship", 30, 40.0, 50000.0, 15000.0, "Steel", "Container", 25);
        WaterTransportation submarine = new Submarine("Deep Explorer", 20, 50.0, 8000.0, 10000.0, "Titanium", 600.0, 12, "Nuclear-X");

        suv.displayInfo();
        truck.displayInfo();
        motorcycle.displayInfo();
        tricycle.displayInfo();
        kariton.displayInfo();
        airplane.displayInfo();
        helicopter.displayInfo();
        ship.displayInfo();
        submarine.displayInfo();
    }
}


