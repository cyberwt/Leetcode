package stack.string;

import java.util.HashMap;

/**
 *
 * 因为是一次从头扫到尾，所以每个level是会覆盖掉上一次取的值的， 理解这个，max是在这个基础上得来的
 * 是一组一组算的，后一组会覆盖前一组的值，用res记录局部最大值
 *
 * 0/ level = s.lastIndexOf("\t") + 1 // 此时level，从0开始的，即 map.put(0,0)
 * 理解好，level+1 表示我这层其实用的是level +1 来计算, 本层是level. 为了下一层，我 put.level+1
 * 触底了就用level
 *
 * 1/ ! 初始先给我一个 hashMap.put(0, 0); 表示第一层
 * 2/ hashMap.put(level + 1, hashMap.get(level) + len + 1 -level);  覆盖掉这个值
 * 3/ hashMap.get(level) + len + -level + 1,  +1 means add "," to the result
 *
 *
 * T:O(N)
 * S:O(N) worst
 *
 * 11/1/20. 12/17/20  3/15/21
 */
public class _388_longest_absolute_file_path {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() ==0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,0);
        int res=0;
        for(String s: input.split("\n")){
            int level = s.lastIndexOf("\t")+1;
            if(s.contains(".")){
                res = Math.max(res, map.get(level)+ s.length()-level);
            }else{
                // +1 means concatenate '/'
                map.put(level+1, map.get(level) + s.length()-level+1);
            }
        }

        return res;
    }

    public static void main(String[] args){
        _388_longest_absolute_file_path solution = new _388_longest_absolute_file_path();
        int val = solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println(val);
        //String s = "\t\t1234567";
        //System.out.println(s.lastIndexOf("\t"));
    }
}
