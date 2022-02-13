 package com.example.trie;

public class TriePrefixCount {
	
	static class TrieNode{
		char data;
		int prefixCount;
		TrieNode[] child;
	}
	
	TrieNode root;
	
	void init() {
		root = new TrieNode();
		root.data = '/';
		root.child  = new TrieNode[26]; 
	}
	static TrieNode getNode(char c) {
		TrieNode temp = new TrieNode();
		temp.data =c;
		temp.child = new TrieNode[26];
		temp.prefixCount =1;
		return temp;
	}
	
	public void insert(String s) {
		
		TrieNode currNode = root;
		int index;
		for(int i=0;i<s.length();i++) {
			index = s.charAt(i)-'a';
			if(currNode.child[index]==null) {
				TrieNode temp = getNode(s.charAt(i));
				currNode.child[index] = temp;
			}else {
				currNode.child[index].prefixCount +=1;
			}
			currNode = currNode.child[index];
		}
		
		
	}
	
	public int  getCountPrefix(String prefix) {
		TrieNode currNode = root;
		int index;
		
		for(int i =0;i<prefix.length();i++) {
			index = prefix.charAt(i)-'a';
			if(currNode.child[index]==null) {
				return 0;
			}
			currNode = currNode.child[index];
		}
		
		return currNode.prefixCount;
	}
	
	

	public static void main(String[] args) {
		TriePrefixCount triePrefixCount = new TriePrefixCount();
		triePrefixCount.init();
		triePrefixCount.insert("aba");
		triePrefixCount.insert("abc");
		triePrefixCount.insert("ab");
		triePrefixCount.insert("bab");
		System.out.println(triePrefixCount.getCountPrefix("ab"));

	}

}
