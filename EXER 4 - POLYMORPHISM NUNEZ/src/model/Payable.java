package model;

public interface Payable {
	void processPayment() throws IllegalStateException;
	boolean isPaid();
	double getAmount();
}
