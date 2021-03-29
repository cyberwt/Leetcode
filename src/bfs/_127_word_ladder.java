package bfs;

import java.util.*;

/**
 *
 *  E1: 这里set是反着的, 取得一个，我移除一个, 不是做重复标记来用了
 *  E2: 拿出的数要再变回去！  strBuff[j] = tem;
 *
 *
 *  2/27/21
 *
 * 很巧妙的题
 * 1/ 先把wordList放到 hashset 里
 * 2/ 在每个word 的char 中，换字母，不同的是，let's remove when it's necessary:
      if(set.contains(newStr)){
         if(newStr.equals(endWord)){ // 得到了
         return level;
      }
         queue.add(newStr); // 继续找
         set.remove(newStr); //这个我用过了，且是最小距离，remove掉
      }

 *
 *
 * 1/20/21.
 */
public class _127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // CC: what should pay attention

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<String>();
        int level = 0;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(endWord)){
                    return level;
                }
                char[] strBuff = str.toCharArray();
                for(int j=0; j<str.length(); j++){
                    char tem = strBuff[j];
                    for(char k='a'; k<='z'; k++){
                        if(strBuff[j]  != k){
                            strBuff[j] = k;
                            String curStr = new String(strBuff);
                            if(set.contains(curStr)){
                                queue.add(curStr);
                                set.remove(curStr);
                            }
                            // 还原原数组
                            strBuff[j] = tem;
                        }
                    }
                }

            }
        }
        return 0;
    }
}
