package bankFullVer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Operator {
	
	Bank bank = new Bank();
	
	public void fillClientBase(){
		for(int i = 0; i < 100; i++){
			bank.createAccount((int)(Math.random()*100000));
		}
	}
	
	public void execute(){
		Set<Callable<String>> setOfCallable = new HashSet<Callable<String>>();
			for(int i = 0; i < 50; i++){
				setOfCallable.add(new Callable<String>(){
					public String call(){
						Long aPayer = (long)(Math.random()*100+151000001);
						Long aPayee = (long)(Math.random()*100+151000001);
						Integer amount = (int)(Math.random()*100000);
								if (aPayer == aPayee) 
									aPayee++;	
								String result = bank.transferMoney(aPayer, aPayee, amount);
								return result;
						}
				});
			}
		
		ExecutorService exServ = Executors.newFixedThreadPool(20);
		List<Future<String>> future = null;
		try {
			future = exServ.invokeAll(setOfCallable);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(Future<String> f : future){
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		exServ.shutdown();
		try{
			if(!exServ.awaitTermination(60, TimeUnit.SECONDS)){
				exServ.shutdownNow();
				if(!exServ.awaitTermination(60, TimeUnit.SECONDS)){
					System.out.println("Thread pool didn't terminate.");
				}
			}
		}
		catch (InterruptedException e) {
			exServ.shutdownNow();
			Thread.currentThread().interrupt();
		}		
	}
}
