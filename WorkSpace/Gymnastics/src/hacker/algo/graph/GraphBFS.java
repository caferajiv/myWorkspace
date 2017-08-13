package hacker.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList;

public class GraphBFS {
	
	static class Graph {
		Node[] vertices;
		int verticesCount;
		int edgeCount;
	
	}
	
	static class Node {
		String name;
		boolean visited;
		Set<Integer> adjacencySet = new HashSet<Integer>();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 for(int i=0;i<testcases;i++){
			 Graph g = new Graph();
			 g.verticesCount=in.nextInt();
			 g.edgeCount=in.nextInt();
			 g.vertices = new Node[g.verticesCount];
			 
			 for(int k=0;k<g.verticesCount;k++){
				 g.vertices[k] = new Node();
			 }
			 
			 for(int j=0;j<g.edgeCount;j++){
				 int fromNode = in.nextInt();
				 int toNode = in.nextInt();
				 g.vertices[fromNode-1].adjacencySet.add(toNode-1);
				 g.vertices[toNode-1].adjacencySet.add(fromNode-1);
			 }
			 int startNode = in.nextInt();
			 
			 for(int k=0;k<g.verticesCount;k++){
				 Map<Integer, Integer> pathMap= new HashMap<Integer, Integer>();
				 if(k==startNode-1){
					 continue;
				 }
				 int pathLength=searchBFS(g,startNode-1,k);
				 if(pathLength!=0){
				 if(pathMap.containsKey(k)){
					 if(pathMap.get(k)>pathLength){
						 pathMap.put(k, pathLength);
					 }
				 }else{
					 pathMap.put(k, pathLength);
				 }
				 }else {
					 pathMap.put(k, -1);
				 }
				 
				 System.out.print(pathMap.get(k)+" ");
				 
			 }
			 System.out.println();
		 }
		 
	}
	
	
	private static int searchBFS(Graph g, int startNode, int searchNode) {
		for(int k=0;k<g.verticesCount;k++){
			 g.vertices[k].visited=false;
		 }
		int path = 0;
		if(g.vertices[startNode].adjacencySet.isEmpty()){
			return 0;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startNode);
		while(!q.isEmpty()){
			int vertex = q.poll();
				
			if(g.vertices[vertex].visited==true){
				continue;
			}
			g.vertices[vertex].visited=true;
			
				if(g.vertices[vertex].adjacencySet!=null && !g.vertices[vertex].adjacencySet.isEmpty()){
					boolean found = true;
					path = path +6;
					for(int v: g.vertices[vertex].adjacencySet ){
						//if(!g.vertices[v].visited){
							if(v==searchNode) return path;
							found = false;
							q.add(v);
							
						//}
						
					}
					
					if(found==false){
						path=0;
					}
					
				}
				
			}
		
		return path;
	}

}
