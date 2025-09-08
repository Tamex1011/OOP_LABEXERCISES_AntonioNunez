public class CarTester {
    public static void main(String[] args) {
        Car c1 = new Car("Blue", "XYZ789", "CHS123", "ENG001", "Petrol", 2020);

        Car c2 = new Car("Yellow", "XYZ790", "BANIT123", "ENG002", "Diesel", 2021);

        c1.displayInfo();
        c2.displayInfo();
    }
}