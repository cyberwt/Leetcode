package tree.tire;

/**
 * backtrack 的方法，一次往上加，然后不断dfs
 *
 *
 * Time Complexity:
   addWord() - O(n), n = length of the new word
   search() - Worst case: O(m), m = the total number of characters in the Trie, word case upper bound O(26^N)
 *
 * 10/18/20.
 *
 */


public class _211_design_add_and_search_words_data_sructure {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word.toCharArray(), 0, root);
    }

    public boolean find(char[] word, int k, TrieNode node){
        if(word.length  == k){
            return node.isWord;
        }

        if(word[k] == '.'){
            for(TrieNode child: node.children){
                if(child!=null && find(word,k+1,child)){
                    return true;
                }
            }
        }else{
            return node.children[word[k] - 'a'] != null && find(word, k + 1, node.children[word[k] - 'a']);
        }
        return false;

    }
}