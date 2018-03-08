package hacker.crackingcodinginterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFSSearch {
	 public static class Graph {
	        int size;
	        List<List<Integer>> adjacencyList = new ArrayList<>();
	        
	        public Graph(int size) {
	            this.size = size;
	            while(size>0) {
	            	adjacencyList.add(new ArrayList<>());
	            	size--;
	            }
	        }

	        public void addEdge(int first, int second) {
	        	
	        	adjacencyList.get(first).add(second);
	        	adjacencyList.get(second).add(first);
	        	
	        }
	        
	        public int[] shortestReach(int startId) { // 0 indexed
	            int[] distances = new int[size];
	            Arrays.fill(distances, -1);
	            distances[startId] = 0;
	            
	            Queue<Integer> queue = new LinkedList<>();
	            Set<Integer> nodesVisited = new HashSet<>();
	            nodesVisited.add(startId);
	            queue.add(startId);
	            while(!queue.isEmpty()) {
	            	int curr = queue.poll();
	            	for(int node : adjacencyList.get(curr)) {
	            		if(!nodesVisited.contains(node)) {
		            		nodesVisited.add(node);
		            		queue.offer(node);
		            		distances[node] = distances[curr] + 6;
		            	}
            			
            		}
	            	
	            }
	            
	            return distances;
	        }
	    }
	 
	 	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	      
	        int queries = scanner.nextInt();
	        
	        for (int t = 0; t < queries; t++) {
	            
	            // Create a graph of size n where each edge weight is 6:
	            Graph graph = new Graph(scanner.nextInt());
	            int m = scanner.nextInt();
	            
	            // read and set edges
	            for (int i = 0; i < m; i++) {
	                int u = scanner.nextInt() - 1;
	                int v = scanner.nextInt() - 1;
	                
	                // add each edge to the graph
	                graph.addEdge(u, v);
	            }
	            
	            // Find shortest reach from node s
	            int startId = scanner.nextInt() - 1;
	            int[] distances = graph.shortestReach(startId);
	 
	            for (int i = 0; i < distances.length; i++) {
	                if (i != startId) {
	                    System.out.print(distances[i]);
	                    System.out.print(" ");
	                }
	            }
	            System.out.println();            
	        }
	        
	        scanner.close();
	    }

}
