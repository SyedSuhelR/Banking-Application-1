package Bank;

public class MinimumWithdrawalException extends Exception{
	public String getMessage()
	{
		return "The Withdrawal Amount cannot be less then 500";
	}

}
