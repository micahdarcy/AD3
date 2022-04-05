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
	
	public Value get(String key) { //returnd the value associated with the given key 
		 if (key == null) {
	            throw new IllegalArgumentException("calls get() with null argument");
	        }
	        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
	        Node<Value> x = get(root, key, 0);
	        if (x == null) return null;
	        return x.val;
	    
		
	}

}
