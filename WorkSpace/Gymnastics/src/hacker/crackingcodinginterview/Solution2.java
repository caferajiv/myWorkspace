package hacker.crackingcodinginterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution2
{

    class TrieNode
    {

        Map<Character, TrieNode> nodes = new HashMap<Character, TrieNode>();
        boolean isWord;
        int count;

    }

    TrieNode root;

    public TrieNode getRoot ()
    {
        return root;
    }

    public void add (String s)
    {
        if (root == null)
            root = new TrieNode();

        char[] chars = s.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {

            TrieNode node = findNodeToInsert(chars[i], temp);
            if (node == null) {
                //if(temp.isWord)
                temp.count = temp.count++;
                temp = temp.nodes.get(chars[i]);
                
                continue;
            }

            TrieNode nodeToAdd = new TrieNode();
            nodeToAdd.count=1;
            if (i == chars.length - 1) {
                nodeToAdd.isWord = true;
            }
           // if(node.isWord)
            node.count = node.count++;
            node.nodes.put(chars[i], nodeToAdd);
            temp = nodeToAdd;
        }

    }

    private TrieNode findNodeToInsert (char c, TrieNode node)
    {
        if (node.nodes.get(c) == null) {
            return node;
        }
        else {
            return null;
        }

    }

    public int find (String s)
    {
        if (root == null)
            return 0;

        char[] chars = s.toCharArray();
        TrieNode temp = root;

        for (int i = 0; i < chars.length; i++) {

            TrieNode node = findNodeWithChar(chars[i], temp);
            if(node!=null){
                if (i == chars.length - 1) {
                    return node.count;
                }else {
                    temp = node; 
                }
            }else {
                return 0; 
            }

        }

        return 0;
    }

    private int countOfNodes (TrieNode node)
    {
        int count = 0;
        List<TrieNode> nods = findTheNonNullNodes(node);
        Queue<TrieNode> queue = new LinkedList<>();
        for (TrieNode nod : nods) {
            queue.offer(nod);
        }
        while (!queue.isEmpty()) {
            TrieNode nod = queue.poll();
            if (nod.isWord) {
                count++;
            }
            List<TrieNode> nodes = findTheNonNullNodes(nod);
            for (TrieNode nod1 : nodes) {
                queue.offer(nod1);
            }
        }
        return count;
    }

    private List<TrieNode> findTheNonNullNodes (TrieNode node)
    {
        List<TrieNode> nodes = new ArrayList<>();
        for (Map.Entry<Character, TrieNode>  nod : node.nodes.entrySet()) {
            if (nod.getValue() != null) {
                nodes.add(nod.getValue());
            }
        }
        return nodes;
    }

    private TrieNode findNodeWithChar (char c, TrieNode node)
    {
        if (node.nodes.get(c) != null) {
            return node.nodes.get(c);
        }
        else {
            return null;
        }
    }

    public static void main (String[] args)
    {
        Solution2 trie = new Solution2();
        
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
         

       // trie.add("all");
       // trie.add("allout");
        //System.out.println(trie.find("a"));
        //trie.add("allin");
        //System.out.println(trie.find("a"));
        //System.out.println("testing");

    }

}