package bankFullVer;

public class Transaction {
	
	public static String transfer(Account payer, Account payee, int amount){
		if(check(payer, amount))
			return "Your account is not enough money.";
		payer.setCash(payer.getCash() - amount);
		payee.setCash(payee.getCash()+amount);
		return "Transfer money committed successfully.";
	}
	public String putCash(Account account, int amount){
		int firstSum = account.getCash();
		firstSum += amount;
		account.setCash(firstSum);
		return "Your account is complete.";
	}
	public String withdrawCash(Account account, int amount){

			int temp = account.getCash() - amount;
			account.setCash(temp);
			String infoYes = "Your account has been removed " + amount + " UAH";
			return infoYes;
	}
	
 	private static boolean check(Account payer, int amount){
		
		if(amount > payer.getCash()){
			return true;
		}
		return false;
	}
}
