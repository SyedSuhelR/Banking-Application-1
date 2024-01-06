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
