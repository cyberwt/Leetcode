package array.hashmap;

import java.util.HashMap;

/**
   Error:
 1. hsahmap need a initialization for map.put(0,0) for  non-exist level

 2. 每次更新的是下一个level, 所以有
 map.put(level+1, map.get(level)+cut.length()-level+1)
 3. 如果遇到了文件底，就算出来
 为什么会成立，因为res可以比较一下，然后被替代
 map.put(level+1, map.get(level)+cut.length()-level+1)  去掉所有/t -> 算一个字符，只留一个连字符/
 最后一次统计，并不需要连字符了：   res = Math.max(res, map.get(level)+cut.length()-level);

 怎么优雅的统计字符串
 T:O(N) S:O(N) in the map

 * 4/20/21.
 */
public class _388_longest_absolute_file_path {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        int res =0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,0);
        for(String cut: input.split("\n")){
            int level = cut.lastIndexOf("\t") + 1;
            // get rid of if "\t" not exist
            if(cut.contains(".")){
                //map.put(level, map.get(level) + cut.length()-level-1);
                res = Math.max(res, map.get(level)+cut.length()-level);
            }else{
                map.put(level+1, map.get(level)+cut.length()-level+1);
            }
        }
        return res;
    }
}
