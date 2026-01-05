package model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
	private final String fullName;
	private final String password;
	private final String email;
	private final Role role;
	private String licenseId;
	private final List<String> plateNumbers;

	protected User(String fullName, String password, String email, Role role, String licenseId) {
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.licenseId = licenseId;
		this.plateNumbers = new ArrayList<>();
	}

	public String getFullName() { return fullName; }
	public String getPassword() { return password; }
	public Role getRole() { return role; }
	public String getEmail() { return email; }
	public String getLicenseId() { return licenseId; }
	public List<String> getPlateNumbers() { return new ArrayList<>(plateNumbers); }
	public void setLicenseId(String licenseId) { this.licenseId = licenseId; }
	public void addPlateNumber(String plateNumber) { this.plateNumbers.add(plateNumber); }
	public void removePlateNumber(String plateNumber) { this.plateNumbers.remove(plateNumber); }

	public abstract String[] getMenuOptions();
	public abstract void displayMenu();

	public String toCSV() {
		return String.format("%s,%s,%s,%s,%s,%s",
			fullName, password, email, role,
			licenseId != null ? licenseId : "",
			String.join(";", plateNumbers));
	}

	public static User fromCSV(String line) {
		String[] parts = line.split(",");
		if (parts.length < 4) {
			throw new IllegalArgumentException("Invalid user data format");
		}
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();
		}
		Role role = Role.valueOf(parts[3].toUpperCase());
		String licenseId = parts.length > 4 ? parts[4] : null;
		User user = switch (role) {
			case ADMIN -> new Admin(parts[0], parts[1], parts[2]);
			case OFFICER -> new Officer(parts[0], parts[1], parts[2]);
			case DRIVER -> new Driver(parts[0], parts[1], parts[2], licenseId);
		};
		if (parts.length > 5 && !parts[5].isEmpty()) {
			String[] plates = parts[5].split(";");
			for (String plate : plates) {
				if (!plate.isEmpty()) {
					user.addPlateNumber(plate.trim());
				}
			}
		}
		return user;
	}
}
