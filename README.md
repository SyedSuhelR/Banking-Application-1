# Banking-Application-1
package Bank;

public class Bank {

	
	
	private long accnumber;
	private int pin=1234;
	private String accname;
	private int balance=0;
	
	
	public Bank(long accnumber, String accname) {
		
		this.accnumber = accnumber;
		this.accname = accname;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public long getAccnumber() {
		return accnumber;
	}


	public void setAccnumber(long accnumber) {
		this.accnumber = accnumber;
	}


	public String getAccname() {
		return accname;
	}


	public void setAccname(String accname) {
		this.accname = accname;
	}
	

}


package Bank;

public class BankFactory {
	
	public BankInterface createInstance()
	{
		return new BankImplementation();
	}


}

package Bank;

import java.util.Scanner;

public class BankImplementation implements BankInterface{ 
	

	Scanner sc=new Scanner(System.in);

	@Override
	public void choice(Bank B) {

		System.out.println("Select Your Choice");
		
		/*System.out.println("1:Deposit");
		
		System.out.println("2:Withdraw");
		
		System.out.println("3:Check Balance ");
		
		System.out.println("4:Update Pin");
		
		System.out.println("5:exit");*/
		System.out.println("Select your Choice\n1:Deposite\n2:Withdraw\n3:Check Balance\n4:Update ");
	}



	@Override
	public void deposit(Bank B) {
		System.out.println("Enter the amt to be depsited");
		int amt=sc.nextInt();
		try
		{
			if (amt<100)
			{
				throw new MinimumDepositException();
			}else if(amt >20000)
			{
				throw new MaxDepositException();
			}
			else
			
				amt=amt+B.getBalance();
				B.setBalance(amt);
				
		}
		catch(MinimumDepositException e)
		{
			System.out.println(e.getMessage());
		}
		catch(MaxDepositException e)
		{
			System.out.println(e.getMessage());
		}
		
	}



	@Override
	public void withdraw(Bank B) {
		System.out.println("Enter the amount to be withdrawn");
		int amt=sc.nextInt();
		
		try {
			if(amt<500)
			{
				throw new MinimumWithdrawalException();
			}
			else if(amt>B.getBalance())
			{
				throw new InvalidAmountException();
			}
			else
			{
				amt=B.getBalance()-amt;
				B.setBalance(amt);
			}
		}
		catch(MinimumWithdrawalException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidAmountException e)
		{
			System.out.println(e.getMessage());
		}
	}



	@Override
	public void checkBalance(Bank B) {
	System.out.println("Name: "+B.getAccname());
	System.out.println("Accnum: "+B.getAccnumber());
	System.out.println("Balance :="+B.getBalance());
	
	}



	@Override
	public boolean updatePin(Bank B) {
		System.out.println("Enter the acc number");
		Long accnum=sc.nextLong();
		try {
			if(accnum==B.getAccnumber())
			{
				System.out.println("Enter the old pin:");
				int Opin=sc.nextInt();
				
				if(Opin==B.getPin())
				{
					System.out.println("Enter the new Pin");
					
					int newpin=sc.nextInt();
					B.setPin(newpin);
					return this.validate(B);
				}
				else 
				{
					throw new InvalidOldPinException();
			    }
				
			}
				else
				{
					throw new InvalidAccException();
				}
		}
			catch(InvalidAccException e)
			{
				System.out.println(e.getMessage());
			}
			catch(InvalidOldPinException e)
			{
				System.out.println(e.getMessage());
			}
			
		
		return true;
	}



	@Override
	public boolean validate(Bank B) {
		
		boolean x=false;
		
		int count=3;
		while (count>0)
		{
			System.out.println("Enter the pin");
			int pin=sc.nextInt();
			
			if(pin==B.getPin())
			{
				x=true;
				break;
			}
			else {
				try {
					count --;
					throw new InvalidPinException();
				}
				catch(InvalidPinException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		return x;
	}
	}

 package Bank;

public interface BankInterface {

	void deposit(Bank B);
	void withdraw(Bank B);
	void checkBalance(Bank B);
	boolean updatePin(Bank B);
	boolean validate(Bank B);
	void choice(Bank B);	
	
}

package Bank;

public class InvalidAccException extends Exception {

	public String getMessage() {
		return "The Account Number entered is invalid";
	}

}


package Bank;

public class InvalidAmountException extends Exception {
    public String getMessage()
   {
	return "The Amount Entered for Withdrawal is greater then then the balance";
   }

}

package Bank;

public class InvalidOldPinException extends Exception {

	public String getMessage() {
		return "You have entered the wrong old pin" ;
	}

}


package Bank;

public class InvalidPinException extends Exception {
	public String getMessage() {
		return " You have entered wrong pin try-again ";
	}

}


package Bank;

public class MaxDepositException extends Exception {

	public String getMessage()

	{
		return "The Deposit Amount cannot be more then 20000";
	}
}



package Bank;

import java.util.Scanner;

public class BankClient {
	public static void main(String[] args) 
	{
       Scanner sc=new Scanner(System.in);
       
       System.out.println("Welcome to the Bank PRATHIBE");
       
       System.out.println("==========================================================");
       
       System.out.println("Enter the new acc number to be created ");
       
       long num=sc.nextLong();
    
       System.out.println("Enter the name");
       
       String name=sc.next();
       
       Bank b1=new Bank(num,name);
       
       BankFactory bf=new BankFactory();
       
       BankInterface bi=bf.createInstance();
       
       boolean b=bi.validate(b1);
       
       int ch=0;
       
       while(b)
       {
    	   while(ch<=4&&b==true)
    	   {
    		   bi.choice(b1);
    		   ch=sc.nextInt();
    		   switch(ch)
    		   {
    		   case 1:bi.deposit(b1);
    		   
    		          break;
    		   case 2:bi.withdraw(b1);
    		   
    		          break;
    		          
    		   case 3:bi.checkBalance(b1);
    		   
    		           break;
    		           
    		   case 4:b=bi.updatePin(b1);
    				   
    		           break;
    		   
    		   }
    	   }
    	   break;
       }
       
       if(false)
       {
    	   System.out.println("Contact the bank");
       }
       
       System.out.println("============Thank you visit again===================");
       
       sc.close();
	}


}
