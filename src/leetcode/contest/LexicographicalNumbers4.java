package leetcode.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tools.P;

public class LexicographicalNumbers4 {

	public static void main(String[] args) {
		int n = 500000;
		P.lnrint(new LexicographicalNumbers4().lexicalOrder(n));

	}

	public List<Integer> lexicalOrder(int n) {

		List<Integer> list = new ArrayList<Integer>(n);
		Trie trie = new Trie();
		long time01 = System.currentTimeMillis();

		for (int i = 1; i <= n; i++)
			trie.insert(String.valueOf(i));
		// while (true) {
		// StringBuilder sb = new StringBuilder();
		// Stack<String> stack = new Stack<String>();
		// break;
		//
		// }

		long time02 = System.currentTimeMillis();
		P.lnrint(time02 - time01);
		return list;
	}

	class TrieNode {
		TrieNode[] arr;
		boolean isEnd;

		// Initialize your data structure here.
		public TrieNode() {
			this.arr = new TrieNode[10];
		}
	}

	class Trie {
		private TrieNode root;

		public TrieNode getRoot() {
			return root;
		}

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode p = root;
			for (int i = 0; i < word.length(); i++) {
				p.isEnd = false;
				char c = word.charAt(i);
				int index = c - '0';
				if (p.arr[index] == null) {
					TrieNode temp = new TrieNode();
					p.arr[index] = temp;
					p = temp;
				} else {
					p = p.arr[index];
				}

			}
			p.isEnd = true;
		}

		public void traverse() {
			TrieNode root = getRoot();
		}

	}

}
