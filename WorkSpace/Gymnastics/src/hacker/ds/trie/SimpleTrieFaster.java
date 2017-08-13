package hacker.ds.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SimpleTrieFaster {
			
 private static	void addWord(TrieNode root, String word){
	 	TrieNode[] children = root.children;
		TrieNode node = null;
		//if(!children.isEmpty()){
			for(int i=0;i<word.length();i++){
				char c =word.charAt(i);
				int index = c-'a';
				if(children[index]!=null){
					node = children[index];
					
				}else{
					node = new TrieNode(c);
					children[index]=node;
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
	
		TrieNode[] children = root.children;
		
		TrieNode node = null;
		for(int i = 0 ; i<word.length();i++){
			char c = word.charAt(i);
			int index = c-'a';
			if(children[index]!=null){
				node = children[index];
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
		TrieNode[] children = node.children;
		    for (int i=0;i<children.length;i++){
		    	if(children[i]!=null){
		    		char val = (char)(i+'a');
		    		String prefixBranch = prefix + val;
					if(children[i].isWord){
						startsWith.add(prefixBranch);
					}
					appendToList(startsWith,children[i], prefixBranch);
		    	}
		    }
		return startsWith;
		
	}


	static class TrieNode {
		char c;
		TrieNode[] children  = new TrieNode[26];
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
		 Map<String, Integer> countMap = new HashMap<String, Integer>();
		 for(int i=0;i<testcases;i++){
			 String command = in.next();
			 if(command.equals("add")){
				 String item = in.next();
				 addWord(root,item);

			 }else if(command.equals("find")){
				 String item = in.next();
				 if(countMap.containsKey(item)){
					 System.out.println(countMap.get(item));
					 continue;
				 }
				int count = searchPartial(root,item);
				countMap.put(item, count);
				System.out.println(count);

			 }
		 }
		
		
	}
			

}
