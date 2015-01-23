package bank;

public class ClientOfBank {
	
//	protected String name = null;
//	
//	protected String middleName = null;
//	
//	protected String surName = null;
	
	protected static long clientID = 151000000;
	
	protected int clientDebitAccount = 0;
	
	protected int clientCreditAccount = 0;
	
	public ClientOfBank(int debit){
		this.clientDebitAccount = debit;
		
		ClientOfBank.clientID++;
		
	}
	
}
