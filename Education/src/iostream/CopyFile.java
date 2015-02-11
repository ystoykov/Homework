package iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyFile {
	
	String fileForRead = "/home/stoykovyakov/pattern.txt";
	String fileForWrite = "/home/stoykovyakov/copier.txt";
	private FileInputStream in;
	private FileOutputStream out;
	public void copyFile(String forRead, String forWrite) throws IOException {
		this.fileForRead = forRead;
		this.fileForWrite = forWrite;		
		in = new FileInputStream(fileForRead);
		int data = in.read();
		File toWrite = new File(fileForWrite);
		out = new FileOutputStream(toWrite);
		while(data != -1){
			out.write(data);
			data = in.read();
		}
	}
	
	public String getFileForRead(){
		return fileForRead;
	}
	
	public String getFileForWrite(){
		return fileForWrite;
	}
}
