package gti310.tp3.writer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class PathWriter implements Writer<Object> {

	@SuppressWarnings("unchecked")
	public void write(String filename, Object output) {
		ArrayList<int[]> sol = new ArrayList<int[]>();
		sol = (ArrayList<int[]>) output;
		
		try {
			PrintStream fileStream = new PrintStream(new File(filename));
			
			for (int[] item : sol) {   
				for (int j = 0; j < item.length; j++){
					fileStream.print(item[j] + " ");
				}
				fileStream.print("\n");
			}
		   fileStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}