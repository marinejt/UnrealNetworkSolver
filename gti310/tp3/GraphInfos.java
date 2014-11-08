package gti310.tp3;

public class GraphInfos {
	
	private int nbSummit;
	private int infiniteValue;
	private int startingSummit;
	private int [][] graphMatrix;
	
	public GraphInfos(int nbSummit,int infiniteValue,int startingSummit,int[][] graphMatrix){
		
		this.nbSummit = nbSummit;
		this.infiniteValue = infiniteValue;
		this.startingSummit = startingSummit;
		this.graphMatrix = graphMatrix;
		
	}
	
	public int getNbSummit(){
		
		return nbSummit;
		
	}
	
	public int getInfiniteValue(){
		
		return infiniteValue;
		
	}
	
	public int getStartingSummit(){
		
		return startingSummit;
		
	}
	
	public int[][] getGraphMatrix(){
		
		return graphMatrix;
		
	}
	
}
