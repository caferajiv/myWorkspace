package pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Trie {

	public static void main(String[] args) {


        Trie trie = new Trie();
        
      /*  Scanner in = new Scanner(System.in);
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
         }*/ 
         

        trie.add("all");
        trie.add("allout");
        System.out.println(trie.find("a"));
        trie.add("allin");
        System.out.println(trie.find("a"));
        System.out.println("testing");

    
	}


	static class TrieNode {
		Map<Character, TrieNode> child = new HashMap<>();
		boolean isWord = false;
	}

	TrieNode root;

	public TrieNode getRoot ()
	{
		return root;
	}



	public void add(String word ) {
		
		if(root == null) {
			root = new TrieNode();
		}

		char[] chars = word.toCharArray();
		TrieNode temp = root;
		int count=0;
		for(char c: chars) {
			TrieNode node = temp.child.get(c);
			if(node==null) {
				TrieNode nodeToAdd =  new TrieNode();
				if(count==chars.length-1) {
					nodeToAdd.isWord = true;
				}
				temp.child.put(c, nodeToAdd);
				temp = nodeToAdd;
			}else {
				temp = node;
			}
			count++;
		}
	}
	
	

	public int find(String s) {
		
		return -1;

	}

	public int searchWord(String s) {

		return -1;
	}


	

}
