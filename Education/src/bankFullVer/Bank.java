package bankFullVer;


import java.util.Hashtable;
import java.util.Map;

public class Bank {
	private Map<Long, Account> base = new Hashtable<Long, Account>();
	
	public void createAccount(){
		Account newAccount = new Account();
		long id = newAccount.getId();
		base.put(id, newAccount);
	}
	
	public void createAccount(int cash){
		Account newAccount = new Account();
		newAccount.setCash(cash);
		long id = newAccount.getId();
		base.put(id, newAccount);
	}

	public String transferMoney(long idPayerAccount, long idPayeeAccount, int amountOfTransfer){
		synchronized(base.get(idPayerAccount)){
			synchronized (base.get(idPayeeAccount)) {
				String fine = Transaction.transfer(base.get(idPayerAccount), base.get(idPayeeAccount), amountOfTransfer);
				return fine;
			}
		}
	}
	public long amountOfCurrentAccounts(){
		long sum = 0;
		for (Long id : base.keySet()){
			long temp = base.get(id).getCash();
			sum += temp;
		}
		return sum;
	}
}
	
