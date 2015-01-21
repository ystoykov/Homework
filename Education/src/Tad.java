

public class Tad implements Runnable{
	int count=0;
	@Override
	public void run() {
		
		for (int i = 0; i < 10000000; i++){
			increment();
		}

	}
	
	public synchronized void increment(){
		count++;
	}

}
