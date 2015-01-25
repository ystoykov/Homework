package bank;

public class Transaction implements Runnable {
	public int amountMoneyTransfer = 100;
	
	public long idGiving = 151000001;
	
	public long idAccepting = 151000002;
	
    Transaction(long aIdGivingint, long aIdAccepting, int aAmountMoneyTransfer) { 
    	this.amountMoneyTransfer = aAmountMoneyTransfer;
    	this.idAccepting = aIdAccepting;
    	this.idGiving = aIdGivingint;
    }
    
    public void run() {
    	doingTransaction();
    }

    public synchronized void doingTransaction(){
    	if(amountMoneyTransfer < ClientDebitBase.getClientDebitBase().get(idGiving)){
      	 
       	System.out.println("Клиент " + idGiving + " перечислил клиенту " + idAccepting + " сумму равную " + amountMoneyTransfer + "грн");
       	System.out.println("До операции на счету первого клиента было " + ClientDebitBase.getClientDebitBase().get(idGiving) + "грн");
       	System.out.println("До операции на счету первого клиента было " + ClientDebitBase.getClientDebitBase().get(idAccepting) + "грн");
       	 
       	int tempGive = ClientDebitBase.getClientDebitBase().get(idGiving);
       	tempGive =  ClientDebitBase.getClientDebitBase().get(idGiving)- amountMoneyTransfer;
       	ClientDebitBase.changeAmountOfClient(idGiving, tempGive);
       	 
       	int tempAccept =  ClientDebitBase.getClientDebitBase().get(idAccepting)+ amountMoneyTransfer;
       	ClientDebitBase.changeAmountOfClient(idAccepting, tempAccept);
        System.out.println("После операции на счету первого клиента " + ClientDebitBase.getClientDebitBase().get(idGiving) + "грн");
       	System.out.println("После операции на счету второго клиента " + ClientDebitBase.getClientDebitBase().get(idAccepting) + "грн");
       	System.out.println();
       	}
    }
}
