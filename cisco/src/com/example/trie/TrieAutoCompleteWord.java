package com.example.trie;

public class TrieAutoCompleteWord {

	static class TrieNode {
		char data;
		int wordEnd;
		TrieNode child[];
	}

	TrieNode root;

	void init() {
		root = new TrieNode();
		root.data = '/';
		root.child = new TrieNode[26];

	}

	static TrieNode getNode(char ch) {
		TrieNode temp = new TrieNode();
		temp.wordEnd = 0;
		temp.child = new TrieNode[26];
		temp.data = ch;
		return temp;

	}

	public void insert(String s) {
		TrieNode currNode = root;
		int index;

		for (int i = 0; i < s.length(); i++) {
			index = s.charAt(i) - 'a';
			if (currNode.child[index] == null) {
				TrieNode temp = getNode(s.charAt(i));
				currNode.child[index] = temp;
			}
			currNode = currNode.child[index];
		}
		currNode.wordEnd += 1;
	}
	
	public void autoComplete(String typedWord) {
		TrieNode currNode = root;
		int index;
		
		for(int i=0;i<typedWord.length();i++) {
			index = typedWord.charAt(i) -'a';
			if(currNode.child[index]==null) {
				
			}
		}
	}

	public static void main(String[] args) {

	}

}
