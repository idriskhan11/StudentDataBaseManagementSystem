package p1;

class StudentNotFoundException extends RuntimeException {
	private String message;

	public StudentNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
