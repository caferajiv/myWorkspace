package tgipl.test;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TollTax {

	public static void main(String[] args) {
		String vertexes = "{A,B,C,D,E,F}";
		int edges = 7;
		String pathCost = "{(A,B,4),(B,C,2),(C,D,3),(B,D,6),(B,E,9),(D,F,5),(E,F,4)}";
		String route = "{A,F}";
		System.out.println(min_path(vertexes, edges, pathCost, route));
	}

	public static int min_path(String vertexes, int edges, String pathCost,
			String route) 
	{
		String[] vertexArr=getVertexCount(vertexes);
		Graph graph= new Graph(vertexArr.length);
		for(String label: vertexArr)
		{
			graph.addVertex(label.charAt(0));
		}
		String[] pathArr=getPathsWithCost(pathCost);
		for(String path: pathArr)
		{
			String [] arr= path.split(",");
			int start = graph.vertexList.indexOf(new Vertex(arr[0].charAt(0)));
			int end = graph.vertexList.indexOf(new Vertex(arr[1].charAt(0)));
			int cost = Integer.parseInt(arr[2]);
			graph.addEdge(start, end, cost);
		}
		String []routeArr=getStartEndFromRoute(route);
		int start=graph.vertexList.indexOf(new Vertex(routeArr[0].charAt(0)));
		int end=graph.vertexList.indexOf(new Vertex(routeArr[1].charAt(0)));
				
		return graph.BreadthFirstSearch(start,end);
		
	}
	
	
	
	private static String[] getStartEndFromRoute(String route) {
		route = route.replace("{", "");
		route = route.replace("}", "");
		String[] arr = route.split(",");
		return arr;
	}

	private static String[] getPathsWithCost(String pathCost) {
		
		pathCost = pathCost.replace("{", "");
		pathCost = pathCost.replace("}", "");
		pathCost = pathCost.replace("(", "");
		String newpathCost = pathCost.substring(0,pathCost.length()-1);
		String [] arr =  newpathCost.split("\\)");
		for(int i=0; i<arr.length;i++)
		{
			if(arr[i].startsWith(","))
			{
				arr[i]=arr[i].substring(1);
			}
		}
		
		return arr;
	}

	private static String[] getVertexCount(String vertexes) {
		vertexes = vertexes.replace("{", "");
		vertexes = vertexes.replace("}", "");
		String [] arr =  vertexes.split(",");
		return arr;
	}

	static class Vertex
	{
		public char label;
		
		public boolean visited;
		
		public Vertex(char label)
		{
			this.label=label;
			visited = false;
		}
		
		@Override
		public int hashCode() {
			
			return label;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Vertex)
			{
				return label==((Vertex)obj).label;
			}
			return false;
		}
		@Override
		public String toString() {
			
			return label+"";
		}
	}
	
	static class Graph {
		private int vertexCount;
		private List<Vertex> vertexList;
		private int [][] adjMatrix;
		@SuppressWarnings("rawtypes")
		private Stack<Integer> stack;
		
		private Queue<Integer> queue;
		
		@SuppressWarnings("rawtypes")
		public Graph(int vertexCount)
		{
			this.vertexCount=vertexCount;
			adjMatrix= new int [vertexCount][vertexCount];
			vertexList = new ArrayList<Vertex>();
			stack = new Stack<Integer>();
			queue = new LinkedList<Integer>();
		}
		
		public void addVertex(char label)
		{
			vertexList.add(new Vertex(label));
		}
		
		public void addEdge(int start, int end, int cost)
		{
			adjMatrix[start][end]=cost;
		}
		
		public void displayVertex(int index)
		{
			//System.out.println(vertexList.get(index));
		}
		
		public int BreadthFirstSearch(int start, int end)
		{
			int cost=0;
			if(vertexList!=null && vertexList.size()!=0)
			{
				vertexList.get(0).visited=true;
				displayVertex(0);
				queue.offer(0);
			}
			
			while(!queue.isEmpty())
			{
				/*int v1=queue.poll();
				//getUnvisited vertex with lowest cost adjacent to stack top
				while( (v = getAdjLowCostUnvisitedVertex(v1))!=-1)
				{
					vertexList.get(v).visited=true;
					displayVertex(v);
					queue.offer(v);
				}*/
				
				int[] v = getAdjLowCostUnvisitedVertex(queue.poll());
				if(v[0]!=-1)
				{

					vertexList.get(v[0]).visited=true;
					displayVertex(v[0]);
					cost=cost+v[1];
					queue.offer(v[0]);
				}
				
			}
			//reset all visited flags
			for(Vertex vertex: vertexList)
			{
				vertex.visited=false;
			}
			
			return cost;
		}
		
		/*public void DepthFirstSearch()
		{
			if(vertexList!=null && vertexList.size()!=0)
			{
				vertexList.get(0).visited=true;
				displayVertex(0);
				stack.push(0);
			}
			
			while(!stack.isEmpty())
			{
				//getUnvisited vertex with lowest cost adjacent to stack top
				int[] v = getAdjLowCostUnvisitedVertex(stack.peek());
				if(v[0]==-1)
				{
					stack.pop();
				}
				else
				{
					vertexList.get(v[0]).visited=true;
					displayVertex(v[0]);
					stack.push(v[0]);
				}
			}
			//reset all visited flags
			for(Vertex v: vertexList)
			{
				v.visited=false;
			}
		}*/

		private int[] getAdjLowCostUnvisitedVertex(int v) {
			int minCost=999;
			int minIndex=-1;
			int[] arrreturn= new int [2];
			for(int i=0; i<vertexCount;i++)
			{
				if(adjMatrix[v][i]>0 && vertexList.get(i).visited==false)
				{
					if(adjMatrix[v][i]<minCost)
					{
						minCost=adjMatrix[v][i];
						minIndex=i;
					}
				}
			}
			if(minCost<999)
			{
				arrreturn[0]=minIndex;
				arrreturn[1]=minCost;
			}
			else
			{
				arrreturn[0]=-1;
				arrreturn[1]=minCost;
			}
				
			return arrreturn;
		}

	}

}
