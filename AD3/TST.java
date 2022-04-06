import java.util.*;

//from: https://algs4.cs.princeton.edu/52trie/TST.java.html

public class TST<Value>{ // represents a symbol table of key-value pairs with string keys and generic values 
	
	private int size; //size of Ternary Search Tree (TST)
	private Node<Value> root; // root of TST
	
	private static class Node<Value>
	{
		private char c;
		 private Node<Value> left, mid, right; //left, mid and right subtries
		 private Value value;
	}
	
	public TST()
	{
		// returns the number of key-value pairs from the symbol table
	}
	public int size() 
	{
		return size;
	}
	public boolean contains(String key) { //checking does the symbol table contain the given key and returning an exception if not
		if(key==null) 
		{
			throw new IllegalArgumentException("");
		}
		return get(key) !=null;
		//to do: write get method 
	}
	
	public Value get(String key) { //returns the value associated with the given key 
		 if (key == null) {
	            throw new IllegalArgumentException("calls get() with null argument");
	        }
	        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
	        Node<Value> x = get(root, key, 0);
	        if (x == null) return null;
	        return x.value;
	 
	}
	  private Node<Value> get(Node<Value> x, String key, int d) { // returning subtrie corresponding to given key 
	        
		  if (x == null) {
			  return null;
		  }
	        if (key.length() == 0) {
	        	throw new IllegalArgumentException("key must have length >= 1");
	        }
	        char c = key.charAt(d);
	        if      (c < x.c) {
	        	return get(x.left,  key, d);
	        }
	        else if (c > x.c)  {
	        	return get(x.right, key, d);
	        }
	        else if (d < key.length() - 1) {
	        	return get(x.mid,   key, d+1);
	        }
	        else{
	        	return x;
	        }
	    }
	  public void put(String key, Value val) {
	        if (key == null) {
	            throw new IllegalArgumentException("calls put() with null key");
	        }
	        if (!contains(key)) size++;
	        else if(val == null) size--;       // delete existing key
	        root = put(root, key, val, 0);
	    }

	    private Node<Value> put(Node<Value> x, String key, Value val, int d) {
	        char c = key.charAt(d);
	        if (x == null) {
	            x = new Node<Value>();
	            x.c = c;
	        }
	        if      (c < x.c)               x.left  = put(x.left,  key, val, d);
	        else if (c > x.c)               x.right = put(x.right, key, val, d);
	        else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
	        else                            x.value   = val;
	        return x;
	    }
	    public Iterable<String> keysWithPrefix(String prefix) { //iteartes over all of the keys in the symbol table after returning keys as an iterable
	        if (prefix == null) {
	            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
	        }
	        Queue<String> queue = new Queue<String>();
	        Node<Value> x = get(root, prefix, 0);
	        if (x == null) return queue;
	        if (x.value != null) queue.enqueue(prefix);
	        collect(x.mid, new StringBuilder(prefix), queue);
	        return queue;
	    }

	    private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
	        if (x == null) return;
	        collect(x.left,  prefix, queue);
	        if (x.value != null) queue.enqueue(prefix.toString() + x.c);
	        collect(x.mid,   prefix.append(x.c), queue);
	        prefix.deleteCharAt(prefix.length() - 1);
	        collect(x.right, prefix, queue);
	    }
	  
	  
	  

}
