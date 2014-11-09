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
	
	public int searchLastSummitWithChoices(int[] path, Arete[][] AreteMatrix){
		
		int i = path.length - 1;
		
		//while()
		
			
			
		return i;
	}
	
	//Algo permettant de trouver un chemin en prenant le sommet avec l'indice le plus petit.
	public int[] algoTest(GraphInfos input){
		
		Arete[][] areteMatrix = areteMatrixConstructor(input);
		int[] path = new int[nbArete(areteMatrix) + 1];
		
		path[0] = input.getStartingSummit();
		for(int i = 1; i < path.length -1; i++){
			
			int j=1;
			
			while((areteMatrix[path[i-1]][j] == null || areteMatrix[path[i-1]][j].getIsTraveled() 
					|| areteMatrix[path[i-1]][j].getDestinationSummit() == input.getStartingSummit()) 
						&& j < input.getNbSummit()){
				
					j++;
					
			}
			//System.out.println("j:" + j + "\t" + "i:" + i);
			path[i] = j;
			
			if(areteMatrix[path[i-1]][j] != null){
			
				areteMatrix[path[i-1]][j].isTraveled();
			
			}
			
			else{
				
				//TODO searchLastSummitWithChoices
				
			}
		}
		path[path.length - 1] = input.getStartingSummit();
		
		System.out.println("Algo de test :");
		
		for(int i = 0; i < path.length; i++){
			
			System.out.print(path[i]+ "\t");
			
		}
		
		return path;
	}

}
