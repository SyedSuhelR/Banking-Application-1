package Bank;

public class InvalidOldPinException extends Exception {

	public String getMessage() {
		return "You have entered the wrong old pin" ;
	}

}
