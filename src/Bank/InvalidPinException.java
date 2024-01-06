package Bank;

public class InvalidPinException extends Exception {
	public String getMessage() {
		return " You have entered wrong pin try-again ";
	}

}
