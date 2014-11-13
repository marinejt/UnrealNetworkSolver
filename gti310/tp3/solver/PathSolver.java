package gti310.tp3.solver;

import gti310.tp3.GraphInfos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class PathSolver implements Solver<Object, Object> {
	
	//Méthode principale servant à générer toutes les solutions possibles grâce au SolutionGenerator.
	//Retourne une liste contenant l'ensemble des solutions.
	@Override
	public Object solve(Object input) {
		
		GraphInfos grapheInfos = (GraphInfos) input; 
		int[] path;
		ArrayList<int[]> pathList = new ArrayList<int[]>();
		Arete[][] areteMatrix = areteMatrixConstructor(grapheInfos);
		
		path = solutionGenerator(grapheInfos, areteMatrix, null);
		
		int i = 1;
		
		//Les solutions sont générées et stockées tour à tour.
		while(path != null){
			
			i++;
			System.out.println();
			System.out.println();
			System.out.println("Solution " + i);
			System.out.println();
			
			pathList.add(path);
			path = solutionGenerator(grapheInfos, areteMatrix, path);
			
		}
		
		System.out.println("pas de solutions supplementaires!");
		System.out.println("Nombre de solutions: " + pathList.size());
		return pathList;
	}
	
	
	//Méthode qui construit la matrice des arrêtes à partir de la matrice d'adjacence construite dans GraphInfos
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
	
	//Méthode qui retourne le nombre d'arrête dans une matrice d'arrêtes
	public int nbArete (Arete[][] areteMatrix){
		
		int count = 0;
		
		for(int i = 1; i < areteMatrix.length; i++){
			
			for(int j = 1; j < areteMatrix.length; j++){
				
				if(areteMatrix[i][j] != null){
					
					count++;
					
				}
				
			}
		}
			
		return count;
	}
	
	//Méthode qui cherche parmis les sommets déjà visités, celui sur lequel il peut faire un choix différent.
	public int searchLastSummitWithChoices(int[] path, Arete[][] areteMatrix){
		
		int i = path.length - 2;
		boolean indexFound = false;
		boolean arrayIndexIsOutOfBounds = false;
		
		//On saute les zéros
		while(path[i] == 0){
			
			i--;
			
		}
		
		//On trouve le bon indice relié au sommet recherché
		while(!indexFound){
			
			int j = path[i+1] + 1;
			
			arrayIndexIsOutOfBounds = false;
			
			if(j == areteMatrix.length){
				
				arrayIndexIsOutOfBounds = true;
				j=0;
				
			}
			
			//Pour l'élément i du tableau, on regarde s'il y d'autres options pas encore explorées 
			while((areteMatrix[path[i]][j] == null || areteMatrix[path[i]][j].getIsTraveled() 
					|| areteMatrix[path[i]][j].getDestinationSummit() == path[0]) &&  !arrayIndexIsOutOfBounds){
	
				if(j < areteMatrix.length){
					
					j++;
					
				}
				
				if(j == areteMatrix.length){
					
					arrayIndexIsOutOfBounds = true;
					j=0;
					
				}
							
			}
			
			//Si ce n'est pas le bon indice
			if(arrayIndexIsOutOfBounds){
			
				if(i == 0){
					
					i--;
					
				}
				//Cas spécial relié au fait qu'aucun indice n'a été trouvé
				if(i == -1){
					
					indexFound = true;
					
				}
				
				//Tant que ce n'est pas le bon indice on défait le chemin entrepris.
				else{
					
					areteMatrix[path[i-1]][path[i]].isUntraveled();
					i--;
				
				}
				
			}
			
			//L'indice a été trouvé
			else{
						
				indexFound = true;
				
			}
			
		}
		
		return i;
	}
	
	//Méthode permettant de trouver un chemin en prenant le sommet avec l'indice le plus petit et en considérant la dernière solution trouvée.
	public int[] solutionGenerator(GraphInfos input ,Arete[][] areteMatrix, int[] precedentSolutionPath){
		
		
		int[] path = new int[nbArete(areteMatrix) + 1];
		boolean matrixIndexIsOutOfBounds = false;
		boolean pathIndexIsOutOfBounds = false;
		boolean searchedLastSummitWithChoices = false;
		int j = 1;
		int i = 1;
				
		//Si une solution précédante existe
		if(precedentSolutionPath != null){
			
			path = Arrays.copyOf(precedentSolutionPath, precedentSolutionPath.length);
			
		}
		
		//Premier élément du tableau de solution est le point de départ.
		path[0] = input.getStartingSummit();
		
		//On remplit le tableau d'une solution
		while(i < path.length - 1 && !pathIndexIsOutOfBounds){
			
			if(!searchedLastSummitWithChoices){
				
				j = 1;
				
			}
			
			matrixIndexIsOutOfBounds = false;
			
			//Si une solution précédente existe
			if(precedentSolutionPath != null && Arrays.equals(path, precedentSolutionPath)){
				
				//On trouve le dernier sommet où l'on peut faire un choix différent
				i = searchLastSummitWithChoices(path, areteMatrix) + 1;
				
				if(i == 0){
					
					pathIndexIsOutOfBounds = true;
					
				}
				
				for(int u = i + 1; u < path.length; u++){
					
					path[u] = 0;
					
				}
				
				j = path[i+1] + 1;
				
			}
			
			//On cherche l'arrête avec le sommet destination le plus petit et pas encore traversé
			while((areteMatrix[path[i-1]][j] == null || areteMatrix[path[i-1]][j].getIsTraveled() 
					|| areteMatrix[path[i-1]][j].getDestinationSummit() == input.getStartingSummit() || j == path[i]) 
						&& !matrixIndexIsOutOfBounds){
					
				if(j < areteMatrix.length){
					
					j++;
					
				}
				
				if(j == areteMatrix.length){
					
					matrixIndexIsOutOfBounds = true;
					j=0;
					
				}
			
					
			}
			
			//Si une arrête avec un sommet destination est trouvé
			if(areteMatrix[path[i-1]][j] != null && j != 0){
				
				path[i] = j;
				areteMatrix[path[i-1]][j].isTraveled();
				i++;
				searchedLastSummitWithChoices = false;
				
			}
			
			//Sinon, on cherche le dernier sommet où l'on peut faire un choix différent
			else{
				
				i = searchLastSummitWithChoices(path, areteMatrix) + 1;
				
				//Si on trouve pas de sommet avec des choix différents
				if(i == 0){
					
					pathIndexIsOutOfBounds = true;
					
				}
				
				//On remplace les anciennes valeurs du tableau par des 0 pour plus de clarté
				for(int u = i + 1; u < path.length; u++){
					
					path[u] = 0;
					
				}
				
				j = path[i] + 1;
		
				searchedLastSummitWithChoices = true;
				
			}
			
		}
		
		//Si la solution générale est trouvé et que le dernier élément est en mesure d'avoir le sommet de départ comme sommet de destination,
		if(i == path.length - 1 && areteMatrix[path[i-1]][input.getStartingSummit()] != null){
			
			//on met le sommet de destination à la fin du tableau.
			path[i] = input.getStartingSummit();
			
		}
		
		//Affichage de la solution trouvée
		if(path != null){
			
			System.out.println("Algo de test :");
			
			for(int u = 0; u < path.length; u++){
				
				System.out.print(path[u]+ "  ");
				
			}
			
		}
		
		//Si aucune solution n'est trouvée
		if(pathIndexIsOutOfBounds){
			
			path = null;
			
		}
		
		return path;
		
	}
	
}
