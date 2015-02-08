package bankFullVer;

import junit.framework.TestCase;

public class OperatorTest extends TestCase {
	public void testOperator(){
		for(int i = 0; i < 100; i++){
			long beforeTransfer = 0;
			long afterTransfer = 0;
			Operator operator = new Operator();
			operator.fillClientBase();
			beforeTransfer = operator.bank.amountOfCurrentAccounts();
			operator.execute();
			afterTransfer = operator.bank.amountOfCurrentAccounts();
			assertEquals(beforeTransfer, afterTransfer);
		}
	}

}
