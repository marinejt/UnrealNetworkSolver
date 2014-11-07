package gti310.tp3.writer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PathWriter implements Writer {

	public void write(String filename, Object output) {
		try {
	         // create a new file with an ObjectOutputStream
	         FileOutputStream fos = new FileOutputStream(filename);
	         ObjectOutputStream oos = new ObjectOutputStream(fos);

	         // write something in the file
	         oos.writeObject(output);

	         // close the stream
	         oos.close();

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }

	}

}
