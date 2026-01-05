package model;

public enum ViolationType {
	NO_LICENSE(3000, "Driving without a valid license"),
	SUSPENDED_LICENSE(3000, "Driving with a suspended/revoked or improper license"),
	NO_LICENSE_OR_CR(1000, "Failure to carry driver's license, OR/CR while driving"),
	NO_PLATE(2000, "Driving without a valid plate number"),
	RECKLESS_DRIVING_1ST(2000, "Reckless driving - 1st offense"),
	RECKLESS_DRIVING_2ND(3000, "Reckless driving - 2nd offense"),
	RECKLESS_DRIVING_3RD(10000, "Reckless driving - 3rd offense"),
	DUI(50000, "Driving under the influence of alcohol/drugs"),
	NO_SEATBELT_1ST(1000, "Not wearing a seatbelt - 1st offense"),
	NO_SEATBELT_2ND(2000, "Not wearing a seatbelt - 2nd offense"),
	NO_SEATBELT_3RD(5000, "Not wearing a seatbelt - 3rd offense"),
	PUV_NO_SEATBELT(3000, "Failure to require passengers to wear seatbelts (PUVs)"),
	NO_HELMET_1ST(1500, "Not wearing a standard motorcycle helmet - 1st offense"),
	NO_HELMET_2ND(3000, "Not wearing a standard motorcycle helmet - 2nd offense"),
	NO_HELMET_3RD(5000, "Not wearing a standard motorcycle helmet - 3rd offense"),
	NO_HELMET_4TH(10000, "Not wearing a standard motorcycle helmet - 4th offense"),
	SUBSTANDARD_HELMET_1ST(3000, "Wearing substandard helmet or without ICC sticker - 1st offense"),
	SUBSTANDARD_HELMET_2ND(5000, "Wearing substandard helmet or without ICC sticker - 2nd offense");

	private final double baseFine;
	private final String description;

	ViolationType(double baseFine, String description) {
		this.baseFine = baseFine;
		this.description = description;
	}
	public double getBaseFine() { return baseFine; }
	public String getDescription() { return description; }
	@Override
	public String toString() {
		return description + " (₱" + String.format("%,.2f", baseFine) + ")";
	}
}
