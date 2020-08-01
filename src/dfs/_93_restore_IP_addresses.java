package dfs;

import java.util.LinkedList;
import java.util.List;

/**
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
            if(val.charAt(0) == '0' && val.length() > 1) return;
            if(Integer.parseInt(val)>255) return;
            dfs(list,ip,tem+val+ (count == 3 ? "":"."), index+i,count+1);
        }
    }

}
