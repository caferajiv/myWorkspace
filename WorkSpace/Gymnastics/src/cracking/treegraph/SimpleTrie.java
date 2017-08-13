package cracking.treegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SimpleTrie {
			
 private static	void addWord(TrieNode root, String word){
		Map<Character, TrieNode> children = root.children;
		TrieNode node = null;
		//if(!children.isEmpty()){
			for(int i=0;i<word.length();i++){
				char c =word.charAt(i);
				if(children.containsKey(c)){
					node = children.get(c);
					
				}else{
					node = new TrieNode(c);
					children.put(c, node);
				}
				children = node.children;
				if(i==word.length()-1){
					node.isWord=true;
				}
			}
		//}
		
	}
	
 private static boolean searchWord(TrieNode root, String word){
		
		TrieNode node = searchNode(root, word);
		if(node != null && node.isWord){
			return true;
		}
		return false;
		
	}
	
	private static TrieNode searchNode(TrieNode root, String word){
	
		Map<Character, TrieNode> children = root.children;
		
		TrieNode node = null;
		for(int i = 0 ; i<word.length();i++){
			char c = word.charAt(i);
			if(children.containsKey(c)){
				node = children.get(c);
				children = node.children;
			}else {
				return null;
			}
		}
		
		return node;
		
	}
	
	private static int searchPartial(TrieNode root, String prefix){
		
		TrieNode node = searchNode(root, prefix);
		List<String> startsWith = new ArrayList<String>();
		if(node!=null){
			
			if(node.isWord){
				startsWith.add(prefix);
			}
			startsWith = appendToList(startsWith,node, prefix);
			}
			
		return startsWith.size();
	}
	
	
	private static List<String> appendToList(List<String> startsWith, TrieNode node, String prefix) {
		Map<Character, TrieNode> children = node.children;
		if(children!=null && !children.isEmpty()){
			Set<Map.Entry<Character, TrieNode>> entrySet = children.entrySet();
			for(Map.Entry<Character, TrieNode> entry : entrySet) {
				char key = entry.getKey();
				TrieNode newNode = entry.getValue();
				String prefixBranch = prefix + key;
				if(newNode.isWord){
					startsWith.add(prefixBranch);
				}
				appendToList(startsWith,newNode, prefixBranch);
				
			}
			
		}
		
		return startsWith;
		
	}


	static class TrieNode {
		char c;
		Map<Character,TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isWord;
		
		TrieNode(){
			
		}
		TrieNode(char c){
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) {
		//test();
		TrieNode root= new TrieNode();
		
		 Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 
		 for(int i=0;i<testcases;i++){
			 String command = in.next();
			 if(command.equals("add")){
				 String item = in.next();
				 addWord(root,item);

			 }else if(command.equals("find")){
				 String item = in.next();
				int count = searchPartial(root,item);
				System.out.println(count);

			 }
		 }
		
		
	}
		
	
	

	private static void test() {
		TrieNode root= new TrieNode();
		addWord(root,"string");
		addWord(root,"stream");
		addWord(root, "apple");
		
		//System.out.println(trie.searchWord("man"));
		//System.out.println(trie.searchWord("stream"));
		System.out.println(searchPartial(root,"ap"));
		}
	
	
	

}
