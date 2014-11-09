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
	
	//Algo permettant de trouver un chemin en prenant le sommet avec l'indice le plus petit.
	public int[] algoTest(GraphInfos input){
		
		areteMatrixConstructor(input);
		
		int[][] graph = input.getGraphMatrix();
		int[] path = new int[input.getNbSummit()];
		
		path[0] = input.getStartingSummit();
		for(int i = 1; i < path.length -1; i++){
			
			int j=1;
			
			while(graph[path[i-1]][j] == 0){
				
				j++;
			}
			
			if(j == input.getStartingSummit()){
				
				j++;
				
				while(graph[path[i-1]][j] == 0){
					
					j++;
				}
				
			}
			
			path[i] = j;
		}
		path[path.length - 1] = input.getStartingSummit();
		
		System.out.println("Algo de test :");
		
		for(int i = 0; i < path.length; i++){
			
			System.out.print(path[i]+ "\t");
			
		}
		
		return path;
	}

}
