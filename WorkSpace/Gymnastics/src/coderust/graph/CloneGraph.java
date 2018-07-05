package coderust.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloneGraph {


	public static void main(String[] args) {
		Node root = new Node(2);
		System.out.println(clone(root));

	}


	 public static Node clone(Node root) {
	     
		 Map<Node, Node> map = new HashMap<>();
		 
		 if(root == null) return null;
			
				Node newNode = new Node(root.data);
				map.put(root, newNode);
				
				Iterator<Map.Entry<Node,Node>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()) {
					Map.Entry<Node,Node> entry = iterator.next();
				    Node node = entry.getKey();
					for(Node neigbourNode : node.neighbors) {
						Node newNode1 = new Node(neigbourNode.data);
						map.put(neigbourNode, newNode1);
					}
				}
				
			for(Map.Entry<Node ,Node> entry : map.entrySet()) {
				Node key = entry.getKey();
				Node value = entry.getValue();
				
				List<Node>  neighbourNodes = new ArrayList<>();
				for(Node node : key.neighbors) {
					neighbourNodes.add(map.get(node));
				}
				
				value.neighbors = neighbourNodes;
			}
			
			return map.get(root);
	      
	  }


	static class Node {
		public int data;
		public List<Node> neighbors = new ArrayList<Node>();
		public Node(int d) {data = d;}
	}
}



	
