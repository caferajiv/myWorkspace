package hacker.crackingcodinginterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TrieNode {
	char c;
	TrieNode[] nodes = new TrieNode[26];
	boolean isWord;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(c);
	}

}
public class Solution {
	
	TrieNode root;
	
	public TrieNode getRoot() {
		return root;
	}
	
	public void add(String s) {
		if (root == null)
			root = new TrieNode();

		int intValueOfa = 'a';
		char[] chars = s.toCharArray();
		TrieNode temp = root;
		for (int i = 0; i < chars.length; i++) {
			int intValue = chars[i];
			TrieNode node = findNodeToInsert(chars[i], temp);
			if(node==null) {
				temp = temp.nodes[intValue - intValueOfa];
				continue;
			}
			
			TrieNode nodeToAdd = new TrieNode();
			nodeToAdd.c = chars[i];
			if (i == chars.length - 1) {
				nodeToAdd.isWord = true;
			}
			node.nodes[intValue - intValueOfa] = nodeToAdd;
			temp = nodeToAdd;
		}

	}
	
	private TrieNode findNodeToInsert(char c, TrieNode node) {
		int intValue = c;
		int intValueOfa = 'a';
		if(node.nodes[intValue-intValueOfa] == null) {
			return node;
		}else {
			return null;
		}
		
	}

	public int find (String s){
		if (root == null)
			return 0;
		
		int intValueOfa = 'a';
		char[] chars = s.toCharArray();
		TrieNode temp = root;
		
		for (int i = 0; i < chars.length; i++) {
			int intValue = chars[i];
			TrieNode node = findNodeWithChar(chars[i], temp);
			if(i==chars.length-1) {
				if(node!=null) {
					return countOfNodes(node);
				}else {
					return 0;
				}
			}else {
				temp = node;
			}
			
		}
		
	return 0;	
	}
	
	private int countOfNodes(TrieNode node) {
		int count = 0;
		List<TrieNode> nods = findTheNonNullNodes(node);
		Queue<TrieNode> queue = new LinkedList<>();
		for(TrieNode nod: nods) {
			queue.offer(nod);
		}
		while(!queue.isEmpty()) {
			TrieNode nod = queue.poll();
			if(nod.isWord) {
				count++;
			}
			List<TrieNode> nodes = findTheNonNullNodes(nod);
			for(TrieNode nod1: nodes) {
				queue.offer(nod1);
			}
		}		
		return count;
	}

	private List<TrieNode> findTheNonNullNodes(TrieNode node) {
		List<TrieNode> nodes = new ArrayList<>();
		for (TrieNode nod : node.nodes) {
			if(nod!=null) {
				nodes.add(nod);
			} 
		}
		return nodes;
	}

	private TrieNode findNodeWithChar(char c, TrieNode node) {

		int intValue = c;
		int intValueOfa = 'a';
		if(node.nodes[intValue-intValueOfa] != null) {
			return node.nodes[intValue-intValueOfa];
		}else {
			return null;
		}
	}

	public static void main(String[] args) {
		Solution trie = new Solution();
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ops = new String[n];
        String[] contacts = new String[n];
        for(int a0 = 0; a0 < n; a0++){
           ops[a0] = in.next();
           contacts[a0] = in.next();
        }
        
        for(int i = 0; i < n; i++){
        	 if(ops[i].equalsIgnoreCase("add")) {
             	trie.add(contacts[i]);
             }else if (ops[i].equalsIgnoreCase("find")) {
             	System.out.println(trie.find(contacts[i]));
 				
 			}
         }
           
        }
		
		
		
		
	}


