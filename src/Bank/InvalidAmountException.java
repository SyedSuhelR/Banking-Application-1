package Bank;

public class InvalidAmountException extends Exception {
    public String getMessage()
   {
	return "The Amount Entered for Withdrawal is greater then then the balance";
   }

}
