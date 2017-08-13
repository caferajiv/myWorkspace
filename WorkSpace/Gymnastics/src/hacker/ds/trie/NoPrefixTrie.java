package hacker.ds.trie;

import java.util.Scanner;


public class NoPrefixTrie {

	
	 private static	boolean addWord(TrieNode root, String word){
		 	TrieNode[] children = root.children;
			TrieNode node = null;
			//if(!children.isEmpty()){
				for(int i=0;i<word.length();i++){
					char c =word.charAt(i);
					int index = c-'a';
					if(children[index]!=null){
						node = children[index];
						if(node.isWord){
							return true;
						}
						
						if(i==word.length()-1){
							node.isWord=true;
							return true;
						}
						
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
			return false;
		}
		
	 
		static class TrieNode {
			char c;
			TrieNode[] children  = new TrieNode[10];
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
			 boolean isBad = false;
			 for(int i=0;i<testcases;i++){
				 String word = in.next();
				 isBad = addWord(root, word);
				 if(isBad){
					 System.out.println("BAD SET");
					 System.out.println(word);
					 break;
				 } 
			 }
			 if(!isBad){
				 System.out.println("GOOD SET");
			 }
						
		}			

}
