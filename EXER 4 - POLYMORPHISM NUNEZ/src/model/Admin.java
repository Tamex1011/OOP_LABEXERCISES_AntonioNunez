package model;

public class Admin extends User {
	public Admin(String fullName, String password, String email) {
		super(fullName, password, email, Role.ADMIN, null);
	}
	@Override
	public String[] getMenuOptions() {
		return new String[]{
			"View All Users",
			"Search Users",
			"Remove Driver Violation",
			"Add New Officer",
			"Logout"
		};
	}
	@Override
	public void displayMenu() {
		System.out.println("\n=== Admin Menu ===");
		String[] options = getMenuOptions();
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
	}
}
