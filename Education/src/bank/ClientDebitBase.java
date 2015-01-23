package bank;


import java.util.Hashtable;
import java.util.Map;


public class ClientDebitBase {
	protected static long allClientsDebit = 0;
	public static void main(String[] args) {
		
	Map<Long, Integer> clientDebitBase = new Hashtable<Long, Integer>();
	for(int i = 0; i < 10; i++){
		ClientOfBank client = new ClientOfBank((int)(Math.random()*10000));
		clientDebitBase.put(ClientOfBank.clientID, client.clientDebitAccount);
		ClientDebitBase.allClientsDebit += clientDebitBase.get(ClientOfBank.clientID);
	
	}
	System.out.println("Дебеторская задолженность банка составляет " + ClientDebitBase.allClientsDebit + "грн");
	}
}
