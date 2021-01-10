package backtracking.permutaions;

import java.util.*;

/**
 * -> 直接把string 分解， charAt, charAt
 * -> 然后4个loop, 放进所有有效地输入
 *
 * ERROR:  char 相加的时候，要 +"" +, 不然是char + char = char
 *
 * LinkedList.addAll(set)
 * Collections.sort(list)
 *
 *
 * 11/4/20.
 */
public class _681_next_closest_time {
    public String nextClosestTime(String time) {
        //几百种情况做个permutation 然后一一比较么
        // 结合时间的比较，有什么itative的方式么
        //how to cut the time slot
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);

        Set<String> set = new HashSet<String>();
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for(int k=0;k<4; k++){
                    for(int l=0;l<4;l++){
                        String candidate = "" + digits[i]+ ""+digits[j] + ":" + digits[k] + ""+digits[l];
                        if(isValid(candidate))set.add(candidate);
                    }
                }
            }
        }
        List<String> timelist = new ArrayList<>();
        timelist.addAll(set);
        Collections.sort(timelist);
        int index = timelist.indexOf(time);
        return index == timelist.size()-1 ? timelist.get(0): timelist.get(index+1);
    }

    public boolean isValid(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        return hour>=0 && hour<=23 && min>=0 && min<=59;
    }
}
