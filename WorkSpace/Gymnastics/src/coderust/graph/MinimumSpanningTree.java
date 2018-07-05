package coderust.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumSpanningTree {
	
	static class vertex {

		int id;
		boolean visited;
		public vertex(int i, boolean b) {
			id = i;
			visited = b;
		}

		public int getId() {
			// TODO Auto-generated method stub
			return id;
		}
		
	}
	
    static class edge {

    	int weight;
    	boolean visited;
    	vertex src;
    	vertex dest;
    	
		public edge(int w, boolean b, vertex s, vertex d) {
			weight = w;
			visited = b;
			src = s;
			dest = d;
		}

		public vertex getSrc() {
			return src;
		}

		public vertex getDest() {
			return dest;
		}

		public int getWeight() {
			return weight;
		}

		public boolean isVisited() {
			return visited;
		}
		
	}
	static class graph {
		  private List<vertex> g;   //vertices
		  private List<edge> e;     //edges

		  int find_min_spanning_tree() {
		    //TODO: Write - Your - Code
		    return -1;
		  }
		  
		  public graph(List<vertex> g, List<edge> e) {
		    super();
		    this.g = g;
		    this.e = e;
		  }

		  public List<vertex> getG() {
		    return g;
		  }

		  public void setG(List<vertex> g) {
		    this.g = g;
		  }

		  public List<edge> getE() {
		    return e;
		  }

		  public void setE(List<edge> e) {
		    this.e = e;
		  }

		  // This method returns the vertex with a given id if it
		  // already exists in the graph, returns NULL otherwise
		  vertex vertex_exists(int id) {
		    for (int i = 0; i < g.size(); i++) {
		      if (g.get(i).getId() == id) {
		        return g.get(i);
		      }
		    }
		    return null;
		  }

		  // This method generates the graph with v vertices
		  // and e edges
		  void generate_graph(int vertices,
		      List<ArrayList<Integer>> edges) {
		    // create vertices
		    for (int i = 0; i < vertices; i++) {
		      vertex v = new vertex(i + 1, false);
		      g.add(v);
		    }

		    // create edges
		    for (int i = 0; i < edges.size(); i++) {
		      vertex src = vertex_exists(edges.get(i).get(1));
		      vertex dest = vertex_exists(edges.get(i).get(2));
		      edge e = new edge(edges.get(i).get(0), false, src,
		          dest);
		      getE().add(e);
		    }
		  }
		  String print_graph() {
		    String result = "";

		    for (int i = 0; i < e.size(); i++) {
		     result += e.get(i).getSrc().getId() + "->"
		          + e.get(i).getDest().getId() + "["
		          + e.get(i).getWeight() + ", "
		          + e.get(i).isVisited() + "]  ";
		    }
		    return result;
		  }

		  void print_mst(int w) {
		    System.out.println("MST");
		    for (int i = 0; i < e.size(); i++) {
		      if (e.get(i).isVisited() == true) {
		        System.out.println(e.get(i).getSrc().getId() + "->"
		            + e.get(i).getDest().getId());
		      }
		    }
		    System.out.println("weight: " + w);
		    System.out.println();
		  }
		};

}
