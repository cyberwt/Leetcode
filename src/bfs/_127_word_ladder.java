package bfs;

import java.util.*;

/**
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
        // 很巧妙的转化成set, 去每一次的loop,观察结果
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++){
                char[] arr = queue.poll().toCharArray();
                int len = arr.length;
                for(int j=0; j<len; j++){
                    char tem = arr[j];
                    for(char chr='a'; chr<='z'; chr++){
                        arr[j] = chr;
                        String newStr = new String(arr);
                        if(set.contains(newStr)){
                            if(newStr.equals(endWord)){
                                return level;
                            }
                            queue.add(newStr);
                            set.remove(newStr);
                        }
                    }
                    arr[j] = tem;
                }
            }

        }
        return 0;
    }
}
