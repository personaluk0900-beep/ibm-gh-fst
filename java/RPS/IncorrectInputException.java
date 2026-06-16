package gameActivity;

public class IncorrectInputException extends Exception {
	
	String message;
	public IncorrectInputException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
