/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
public class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        private TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        int i = 0;
        while (i<word.length()) {
            if (node.children[word.charAt(i)-'a']==null) 
            node.children[word.charAt(i)-'a']=new TrieNode();
            node = node.children[word.charAt(i)-'a'];
            i++;
        }
        node.isWord=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root,word,0);
    }
    public boolean search(TrieNode node, String word, int i ) {
        if (node==null) return false;
        if (i==word.length()) return node.isWord;
        char c = word.charAt(i);
        if ((c-'.')!=0) 
            return search(node.children[c-'a'],word,i+1);
        
         for (int k = 0; k<26; k++) {
               if (search(node.children[k], word, i+1)==true) return true;
        }
                
        return false;
    
    }
    
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        wordDictionary.addWord("w");
        wordDictionary.addWord("w");
        wordDictionary.addWord("a");
        wordDictionary.addWord("aa");
        //wordDictionary.search("pattern");

        System.out.println(wordDictionary.search(".ab"));
        
    }
}

// Your WordDictionary object will be instantiated and called as such:

    

