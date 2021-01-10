package tree.tire;

/**
 *
 * class TireNode{
 *     public TireNode() {};
 *     public TireNode[] children = new TireNode[26];
 *     public boolean isWord;
 * }
 *
 * 其他根据Tire的性质，来写, 怎么初始化 TireNode 和 Tire
 *
 * delete 的话，直接 node.children[c-'a'] = null
 *
 *
 * 10/18/20.
 */
public class _208_implement_trie {
    class TrieNode{
        public TrieNode() {};
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

    }
    /** Initialize your data structure here. */
    private TrieNode root;
    class Trie{
         TrieNode root;
         public Trie(){
             root = new TrieNode();
         }

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] ==null){
                node.children[c-'a'] = new TrieNode();
            }

            node = node.children[c-'a'];
        }
        node.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a']!=null){
                node = node.children[c-'a'];
            }else{
                return false;
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a']!=null){
                node = node.children[c-'a'];
            }else{
                return false;
            }
        }
        return true;
    }
}
