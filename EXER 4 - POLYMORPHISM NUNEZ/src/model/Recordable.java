package model;

public interface Recordable {
	String toCSV();
	static Recordable fromCSV(String line) throws IllegalArgumentException {
		throw new UnsupportedOperationException("Must be implemented by subclasses");
	}
}
