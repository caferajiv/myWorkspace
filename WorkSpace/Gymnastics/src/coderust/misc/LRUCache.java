package coderust.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class LRUCache {
	  int capacity;
	  
	  //LinkedListNode holds key and value pairs
	  HashMap<Integer,LinkedListNode> cache; 
	  LinkedList<LinkedListNode> cache_vals;
	  
	  public LRUCache(int capacity) {
	    this.capacity = capacity;
	    cache = new HashMap<Integer,LinkedListNode>(capacity);
	    cache_vals = new LinkedList<LinkedListNode>();
	  }


	  int get(int key) {
		  LinkedListNode node = null;
	    if(cache.containsKey(key)) {
	    	node = cache.get(key);
	    	cache_vals.remove(node);
	    	cache_vals.addLast(node);
	    	
	    }
	    if(node!=null)
	    return node.data;
	    
	    return -1;
	  }
	  
	 

	  void set(int key, int value) {
		  LinkedListNode node = null;
		  if(cache.containsKey(key)) {
			  node = cache.get(key);
			  node.data = value;
			  cache_vals.remove(node);
			  cache_vals.addLast(node);
		  }
		  else {
			  if(capacity <= cache_vals.size()) {
				  LinkedListNode deleteNode = cache_vals.remove(0);
				  cache.remove(deleteNode.key);
			  }
			  node  = new LinkedListNode(key, value);
			  cache.put(key, node);
			  cache_vals.addLast(node);
		  }
		  
	  }

	  String print() {
	    String result = "";
	    ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
	    while(iterator.hasNext()){
	      LinkedListNode node = iterator.next();
	      result += "("+node.key + ":" +node.data+")" + ",";  
	    }
	   return result;
	  }
	  
	  static class LinkedListNode {
		  
		  int key;
		  int data;
		  
		  LinkedListNode(int key, int data){
			  this.key  = key ;
			  this.data = data;
		  }
		  		  
	  }
	}  