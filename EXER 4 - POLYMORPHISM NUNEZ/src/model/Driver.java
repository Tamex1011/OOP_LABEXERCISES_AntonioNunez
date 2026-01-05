package model;

public class Driver extends User {
	public Driver(String fullName, String password, String email, String licenseId) {
		super(fullName, password, email, Role.DRIVER, licenseId);
	}
	@Override
	public String[] getMenuOptions() {
		return new String[]{
			"View My Violations",
			"Manage Vehicle Plates",
			"Pay Fine",
			"Logout"
		};
	}
	@Override
	public void displayMenu() {
		System.out.println("\n=== Driver Menu ===");
		String[] options = getMenuOptions();
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
	}
}
