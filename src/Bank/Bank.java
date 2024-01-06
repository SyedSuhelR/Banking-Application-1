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
