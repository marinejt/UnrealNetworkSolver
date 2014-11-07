package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class PathParser implements Parser<Object> {

	@Override
	public Object parse(String filename) {
		
		String filePath = this.getClass().getClassLoader().getResource("").getPath() + filename;
		int nbSummit = 0;
		int infiniteValue;
		int startingSummit;
		int [][] fileMatrix = new int[2][2];

		try {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	        String line;

	        int i = 0;
	        while ((line = br.readLine()) != null) {

	        	if(i == 0)
	        	{
	        		nbSummit = Integer.parseInt(line.toString().trim());
	        		fileMatrix = new int[nbSummit + 1][nbSummit + 1];
	        		System.out.println(nbSummit);
	        	}
	        	else if(i == 1){
	        		infiniteValue = Integer.parseInt(line.toString().trim());
	        	}
	        	else if(i == 2){
	        		startingSummit = Integer.parseInt(line.toString().trim());
	        	}
	        	//else if(line.toString().trim() == "$"){
	        	//	br.close(); 
	        	//}
	        	else{
	        		String[] lineElements = line.split("\t", 3);
	        		fileMatrix[Integer.parseInt(lineElements[0])][Integer.parseInt(lineElements[1])] = Integer.parseInt(lineElements[2]);
	        	}
	            i++;
	        }
	    
	    } catch(Exception e) {
	    	
	    }
		showMatrix(fileMatrix);
		return fileMatrix;
	}
	
	private void showMatrix(int[][] matrix){
		
		for(int i = 1; i < matrix.length; i++){
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 1; i < matrix.length; i++){
			System.out.print(i + ": ");
			for(int j = 1; j < matrix.length; j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
