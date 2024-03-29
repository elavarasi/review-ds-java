package com.review.DataStructureAlgorithm.educativeio.DataStructure.Tries;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public int getIndex(char t) {
        return t - 'a';
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String key) {
        if (key == null) {
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }

        currentNode.markAsLeaf();
    }




}
