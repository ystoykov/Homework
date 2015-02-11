package iostream;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestCopyFile {

	@Test
	public void test() throws IOException {
		CopyFile cf = new CopyFile();
		String forRead = "/home/stoykovyakov/pattern.txt";
		String forWrite = "/home/stoykovyakov/copier.txt";
		cf.copyFile(forRead , forWrite );
		File rf = new File(forRead);
		File wf = new File(forWrite);
		assertEquals(rf.length(), wf.length());
	}

}
