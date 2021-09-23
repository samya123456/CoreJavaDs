package com.example.trie;

public class TrieExample {

	static class TrieNode {
		char data;
		int wordEnd;
		TrieNode[] child = new TrieNode[26];
	}

	TrieNode root;

	void init() {

		root = new TrieNode();
		root.data = '/';
		root.child = new TrieNode[26];
	}

	static TrieNode getNode(char c) {
		TrieNode temp = new TrieNode();
		temp.data = c;
		temp.child = new TrieNode[26];
		temp.wordEnd =0;
		return temp;
	}
	
	void insert(String s) {
		TrieNode currNode = root;
		int index;
		
		for(int i =0;i<s.length();i++) {
			index = s.charAt(i)-'a';
			if(currNode.child[index]==null) {
				TrieNode temp = getNode( s.charAt(i));
				currNode.child[index] =temp;
			}
			
			currNode = currNode.child[index];
		}
		currNode.wordEnd +=1;
	}
	
	void delete(String s) {
		TrieNode currNode = root;
		int index;
		
		for(int i=0 ;i<s.length();i++) {
			index = s.charAt(i)-'a';
			if(currNode.child[index].data==s.charAt(i)) {
				
			}else {
				System.out.println("word not found");
				return;
			}
			currNode = currNode.child[index];
		}
		if(currNode.wordEnd>0) {
			currNode.wordEnd =0;
			System.out.println("word deleted");
			
		}else {
			System.out.println("word not found");
		}
	}
	
	public boolean search(String s) {
		TrieNode currNode = root;
		int index;
		
		for(int i=0;i<s.length();i++) {
			index = s.charAt(i)-'a';
			if(currNode.child[index]==null){
				return false;
			}
			currNode = currNode.child[index];
		}
		
		if(currNode.wordEnd==0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		TrieExample trieExample = new TrieExample();
		trieExample.init();
		trieExample.insert("aba");
		trieExample.insert("abc");
		trieExample.insert("ab");
		trieExample.insert("bab");
		
		System.out.println(trieExample.search("ab"));
		trieExample.delete("ab");
		System.out.println(trieExample.search("ab"));
		

	}

}
