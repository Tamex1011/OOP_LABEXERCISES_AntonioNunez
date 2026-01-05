package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriversLicense implements Recordable {
	private final String licenseNumber;
	private final String fullName;
	private final String address;
	private final Date birthDate;
	private final List<Violation> violations;
	private double totalUnpaidFines;

	public DriversLicense(String licenseNumber, String fullName, String address, Date birthDate) {
		this.licenseNumber = licenseNumber;
		this.fullName = fullName;
		this.address = address;
		this.birthDate = birthDate;
		this.violations = new ArrayList<>();
		this.totalUnpaidFines = 0;
	}

	public void addViolation(Violation violation) {
		violations.add(violation);
		if (!violation.isPaid()) {
			totalUnpaidFines += violation.getFine();
		}
	}

	public String getLicenseNumber() { return licenseNumber; }
	public String getFullName() { return fullName; }
	public String getAddress() { return address; }
	public Date getBirthDate() { return new Date(birthDate.getTime()); }
	public List<Violation> getViolations() { return new ArrayList<>(violations); }
	public double getTotalUnpaidFines() { return totalUnpaidFines; }

	@Override
	public String toCSV() {
		return String.format("%s,%s,%s,%d",
			licenseNumber, fullName, address, birthDate.getTime());
	}

	public static DriversLicense fromCSV(String line) {
		String[] parts = line.split(",");
		if (parts.length < 4) {
			throw new IllegalArgumentException("Invalid license data format");
		}
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();
		}
		return new DriversLicense(
			parts[0],
			parts[1],
			parts[2],
			new Date(Long.parseLong(parts[3]))
		);
	}
}
