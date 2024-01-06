package Bank;

public class InvalidAccException extends Exception {

	public String getMessage() {
		return "The Account Number entered is invalid";
	}

}


