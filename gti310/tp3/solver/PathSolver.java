package gti310.tp3.solver;

import gti310.tp3.GraphInfos;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class PathSolver implements Solver<Object, Object> {

	@Override
	public Object solve(Object input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Arete[][] areteMatrixConstructor(GraphInfos input){
		
		int[][] graphe = input.getGraphMatrix();
		Arete[][] areteMatrix = new Arete[input.getNbSummit()+1][input.getNbSummit()+1];
		
		for(int i = 1; i <= input.getNbSummit(); i++){
			
			for(int j = 1; j <= input.getNbSummit(); j++){
				
				if(graphe[i][j] != 0){
					
					areteMatrix[i][j] = new Arete(i, j, graphe[i][j]);
					
				}
				
			}
		}	
		
		return areteMatrix;	
	
	}
	
	public int nbArete (Arete[][] areteMatrix){
		
		int count = 0;
		
		for(int i = 1; i < areteMatrix.length; i++){
			
			for(int j = 1; j < areteMatrix.length; j++){
				
				if(areteMatrix[i][j] != null){
					
					count++;
					
				}
				
			}
		}
			
		System.out.println("Nombre d'aretes: " + count);
		return count;
	}
	
	public int searchLastSummitWithChoices(int[] path, Arete[][] areteMatrix){
		
		int i = path.length - 1;
		boolean indexFound = false;
		boolean arrayIndexIsOutOfBounds = false;
		
		while(path[i] == 0){
			
			i--;
			
		}
		
		while(!indexFound){
			
			int j=1;
			arrayIndexIsOutOfBounds = false;
			
			while((areteMatrix[path[i]][j] == null || areteMatrix[path[i]][j].getIsTraveled() 
					|| areteMatrix[path[i]][j].getDestinationSummit() == path[0] || j == path[i+1]) 
						&&  !arrayIndexIsOutOfBounds){
	
				
				
				if(j == areteMatrix.length - 1){
					
					j= 0;
					arrayIndexIsOutOfBounds = true;
					
				}
				
				else{
					
					j++;
					
				}
				
						
			}
			//System.out.println("j:" + j + "   i:" + i + " ");
			if(arrayIndexIsOutOfBounds){
				//for(int u = 0; u < path.length; u++){
					
					//System.out.print(path[u]+ "  ");
					
				//}
				//System.out.println((i-1) + ":" + path[i-1] + "    " + i + ":" + path[i]);
				try{
					areteMatrix[path[i]][path[i-1]].isUntraveled();
				}catch(Exception e){
					areteMatrix[path[i-1]][path[i]].isUntraveled();
				}
				
			
				i--;
				
				
			}
			
			else{
			
				indexFound = true;
				
			}
			
		}
		
		//System.out.println("return i:" + i);
		
			
		return i;
	}
	
	//Algo permettant de trouver un chemin en prenant le sommet avec l'indice le plus petit.
	public int[] algoTest(GraphInfos input){
		
		Arete[][] areteMatrix = areteMatrixConstructor(input);
		int[] path = new int[nbArete(areteMatrix) + 1];
		boolean arrayIndexIsOutOfBounds = false;
		
		path[0] = input.getStartingSummit();
		
		int i = 1;
		
		while(i < path.length - 1){
			
			System.out.println("i:" + i);
			
			int j=1;
			arrayIndexIsOutOfBounds = false;
			
			/*try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}*/
			
			
			
			while((areteMatrix[path[i-1]][j] == null || areteMatrix[path[i-1]][j].getIsTraveled() 
					|| areteMatrix[path[i-1]][j].getDestinationSummit() == input.getStartingSummit() || j == path[i]) 
						&& !arrayIndexIsOutOfBounds){
					
				
				if(j == areteMatrix.length - 1){
					
					j= 0;
					arrayIndexIsOutOfBounds = true;
					
				}
				
				else{
					
					j++;
					
				}
			
					
			}
			
			
			
			System.out.println("path[i-1]:" + path[i-1] + "\t" + "j:" + j);
			
			
			if(areteMatrix[path[i-1]][j] != null && j != 0){
				
				path[i] = j;
				areteMatrix[path[i-1]][j].isTraveled();
				
				System.out.println("Algo de test :");
				for(int u = 0; u < path.length; u++){
					
					System.out.print(path[u]+ "  ");
					
				}
				
				i++;
			}
			
			else{
				
				//TODO searchLastSummitWithChoices
				i = searchLastSummitWithChoices(path, areteMatrix) + 1;
				//path[i] = j;
				
			}
			
			
		}
		
		if(i == path.length - 1 && areteMatrix[path[i-1]][input.getStartingSummit()] != null){
			
			path[i] = input.getStartingSummit();
			
		}
		
		System.out.println("Algo de test :");
		
		for(int u = 0; u < path.length; u++){
			
			System.out.print(path[u]+ "  ");
			
		}
		
		return path;
	}

}
