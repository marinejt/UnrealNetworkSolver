package gti310.tp3.parser;

import gti310.tp3.GraphInfos;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class PathParser implements Parser<Object> {

	@Override
	public GraphInfos parse(String filename) {
		
		String filePath = this.getClass().getClassLoader().getResource("").getPath() + filename;
		int nbSummit = 0;
		int infiniteValue = 0;
		int startingSummit = 0;
		int [][] graphMatrix = new int[2][2];

		try {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	        String line;

	        int i = 0;
	        while ((line = br.readLine()) != null) {

	        	if(i == 0)
	        	{
	        		nbSummit = Integer.parseInt(line.toString().trim());
	        		graphMatrix = new int[nbSummit + 1][nbSummit + 1];
	        		System.out.println("Nombre de sommets :" + nbSummit);
	        	}
	        	else if(i == 1){
	        		infiniteValue = Integer.parseInt(line.toString().trim());
	        		System.out.println("Valeur de l'infinie :" + infiniteValue);
	        	}
	        	else if(i == 2){
	        		startingSummit = Integer.parseInt(line.toString().trim());
	        		System.out.println("Sommet de départ :" + startingSummit);
	        	}
	        	else if(line.toString().trim() == "$"){
	        		br.close(); 
	        	}
	        	else{
	        		String[] lineElements = line.split("\t", 3);
	        		graphMatrix[Integer.parseInt(lineElements[0])][Integer.parseInt(lineElements[1])] = Integer.parseInt(lineElements[2]);
	        	}
	            i++;
	            
	        }
	        
	    } catch(Exception e) {
	    	
	    }
		showMatrix(graphMatrix);
		return new GraphInfos(nbSummit, infiniteValue, startingSummit, graphMatrix);
	}
	
	private void showMatrix(int[][] matrix){
		
		System.out.println("MATRICE D'ADJACENCE : ");
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
