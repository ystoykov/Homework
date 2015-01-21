
public class Star {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tad tad = new Tad();
		Thread[] tgr = new Thread[10];
		for (int j = 0; j < 10; j++)
			{
		Thread t = new Thread(tad);
		tgr[j] = t;
		t.start();
			}
		
		for (Thread ad: tgr){
			try {
				ad.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		
		System.out.println(tad.count);
		

	}

}
