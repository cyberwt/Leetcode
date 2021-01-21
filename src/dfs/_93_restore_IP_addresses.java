package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 理解了一下
 * 构造了新数组之后，先判断，是否符合题意
 * 1.构建条件的判断
 * // 两个条件，都是得到的值不成立
   if(val.charAt(0) == '0' && val.length() > 1) return;
   if(Integer.parseInt(val)>255) return;
 * 2.构建函数的修饰
 * dfs(list,ip,tem+val+ (count == 3 ? "":"."), index+i,count+1);
 * 3.substring 的取值2个错
 *  a.if(index + i >ip.length()) return;
 *  index + i == ip.length()是符合题意的
 *  b.String val = ip.substring(index, index+i); // i should start from 1
 *
 * 复杂度，怎么理解
 *
 * What we are trying to do here is to partition the input string into 4 parts with 3 cuts.
 * There are C(n, 3) ways to cut the string into 4 parts.
 * In that sense, the time complexity is O(n^3).
 * On second thought, however, because we are doing backtracking and removing lots of unnecessary checking,
 * we are only checking three possibilities for each part (it has to be [0,255]),
 * it becomes 3^4, which is just a constant, so it becomes O(1).
 * This is why solution like this exists: https://leetcode.com/problems/restore-ip-addresses/discuss/30972/WHO-CAN-BEAT-THIS-CODE .
 * The space complexity is O(1) too as the depth of the recursion tree is 4.
 *
 * 1/21/21
 *
 * 一直往下 dfs求解，设有变量:
 * list<String>, 原ip, tem string, 走到第几(3,也是结束条件)位，目前我index的位置
 *
 * dfs 里剔除不合题意的条件：
 *  if(index + i >ip.length()) return;
    if(val.charAt(0) == '0' && val.length() > 1) return;
    if(Integer.parseInt(val)>255) return;
 *
 * 继续加上值，往下走：
 *  dfs(list,ip,tem+val+ (count == 3 ? "":"."), index+i,count+1);
 *
 *
 *
 * 7/15/20.
 */
public class _93_restore_IP_addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s == null || s.length()==0 || s.length() >12){
            return res;
        }
        dfs(res,s,"",0,0);
        return res;
    }

    public void dfs(List<String> list, String ip, String tem, int index, int count){
        if(count >4) return;
        if(count == 4 && index == ip.length()){
            list.add(tem);
            return;
        }
        for(int i=1; i<4; i++){
            if(index + i >ip.length()) return;
            String val = ip.substring(index, index+i);
            // 两个条件，都是得到的值不成立
            if(val.charAt(0) == '0' && val.length() > 1) return;
            if(Integer.parseInt(val)>255) return;
            // 继续向下一层遍历
            dfs(list,ip,tem+val+ (count == 3 ? "":"."), index+i,count+1);
        }
    }

}
