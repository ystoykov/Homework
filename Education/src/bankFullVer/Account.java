package bankFullVer;


public class Account {
	
	private static long counter = 151000000;
	private long accountID;
	
	private int cashAccount = 0;
		
	public Account(){
		Account.counter++;
		accountID=counter;	
	}
	
	public void setCash(int cash){
		this.cashAccount = cash;
	}
	public int getCash(){
		return cashAccount;
	}
	public long getId(){
		return accountID;
	}
}




