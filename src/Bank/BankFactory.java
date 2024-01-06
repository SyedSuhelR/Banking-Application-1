
package Bank;

public class BankFactory {
	
	public BankInterface createInstance()
	{
		return new BankImplementation();
	}


}
