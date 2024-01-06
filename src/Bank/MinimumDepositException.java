package Bank;

public class MinimumDepositException extends Exception {
	public String getMessage()
	{
		return "The Deposit Amount cannot be less then 100";
	}

}
