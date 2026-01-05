package model;

public class Officer extends User {
	public Officer(String fullName, String password, String email) {
		super(fullName, password, email, Role.OFFICER, null);
	}
	@Override
	public String[] getMenuOptions() {
		return new String[]{
			"Add Violation by License",
			"Add Violation by Plate Number",
			"Search Violations",
			"Delete Violation",
			"Logout"
		};
	}
	@Override
	public void displayMenu() {
		System.out.println("\n=== Officer Menu ===");
		String[] options = getMenuOptions();
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
	}
}
