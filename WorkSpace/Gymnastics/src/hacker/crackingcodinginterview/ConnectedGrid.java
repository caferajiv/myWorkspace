package hacker.crackingcodinginterview;

import java.util.List;
import java.util.Scanner;

public class ConnectedGrid {
	
	static class Graph {
		Vertex[] vertices;
	}
	
	static class Vertex{
		Position position;
		boolean visited;
		boolean filled;
		List<Vertex> adjacencyList;
		Vertex (Position pos, boolean visited, boolean filled){
			position = pos;
			this.visited = visited;
			this.filled = filled;
		}
		
	}
	static class Position {
		int x, y;
		Position(int i, int j){
			x=i;
			y=j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		Graph gf = new Graph();
		gf.vertices = new Vertex[rows+cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Position pos = new Position(i,j);
				gf.vertices[i+j] = new Vertex(pos, false, sc.nextInt()==1);
			}
		}
	}

}
