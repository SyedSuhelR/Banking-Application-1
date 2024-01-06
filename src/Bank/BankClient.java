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
