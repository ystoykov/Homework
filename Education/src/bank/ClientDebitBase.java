package bank;

import java.util.Hashtable;
import java.util.Map;

public class ClientDebitBase {
	
	protected static long allClientsDebit = 0;
	protected static long paramIdGiv = (long)(Math.random()*10+151000001);
	protected static long paramIdAccept = (long)(Math.random()*10+151000001);
	
	static Map<Long, Integer> clientDebitBase = new Hashtable<Long, Integer>();
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++){
			ClientOfBank client = new ClientOfBank((int)(Math.random()*10000));
			clientDebitBase.put(ClientOfBank.clientID, client.clientDebitAccount);
			ClientDebitBase.allClientsDebit += clientDebitBase.get(ClientOfBank.clientID);
		}
	
		for(int i = 0; i < 5; i++){
			Thread t = new Thread(new Transaction(paramIdGiv,paramIdAccept, 100));
			t.start();
		}
	}
	
	public static Map<Long, Integer> getClientDebitBase(){
		return clientDebitBase;
	}
	
	public static void changeAmountOfClient(long idClient, int newAmountValue){
		clientDebitBase.put(idClient, newAmountValue);
	}
}
