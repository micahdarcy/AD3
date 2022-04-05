import java.util.*;

//from: https://algs4.cs.princeton.edu/52trie/TST.java.html

public class TST<Value>{ // represents a symbol table of key-value pairs 
	
	private int n; //size of Ternary Search Tree (TST)
	private Node<Value> root; // root of TST
	
	private static class Node<Value>
	{
		private char c;
		 private Node<Value> left, mid,right;
		 private Value val;
	}

}
