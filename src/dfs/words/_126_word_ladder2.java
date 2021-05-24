package dfs.words;

import java.util.*;

/**
 *
 * 为什么这么做，每层我们hash下去
 *
 * 4/11/21.
 */
public class _126_word_ladder2 {
    List<List<String>> ans=new ArrayList();
    List<String> used=new ArrayList();
    Set<String> dict=new HashSet();
    Map<String,Set<String>> map=new HashMap();
    boolean found=false;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        dict=new HashSet(wordList);
        if(dict.contains(beginWord))
            dict.remove(beginWord);
        if(!dict.contains(endWord))
            return ans;
        Set<String> set=new HashSet();
        set.add(beginWord);
        while(!set.isEmpty()) {
            Set<String> temp=new HashSet();
            for(String s:set) {//对于每一层的Set做BFS
                if(!map.containsKey(s))
                    map.put(s, new HashSet<String>());
                char[] array=s.toCharArray();
                for(int i=0;i<array.length;i++) {
                    char cur=array[i];
                    for(char c='a';c<='z';c++) {
                        if(c==cur)
                            continue;
                        array[i]=c;
                        String str=new String(array);
                        if(str.equals(endWord))
                            found=true;
                        if(dict.contains(str)) {
                            map.get(s).add(str);
                            temp.add(str);
                            used.add(str);//记录一下当前层出现过的字符串。
                        }
                    }
                    array[i]=cur;
                }
            }
            dict.removeAll(used);//防止重复使用，同时避免丢失路径。
            used.clear();
            set=temp;//更新下一层的set
        }
        if(!found)
            return ans;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(list,beginWord,endWord);
        return ans;
    }
    public void dfs(List<String> list,String cur,String endWord) {
        if(endWord.equals(cur)) {
            ans.add(new ArrayList(list));
            return;
        }
        for(String str:map.get(cur)){
            list.add(str);
            dfs(list,str,endWord);
            list.remove(list.size()-1);
        }
    }
}
