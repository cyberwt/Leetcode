package dfs.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * compute 做的是6次操作(+,-,-,*,/,/)
 *
 *
 * dfs的条件
 * size == 1
 * for + for 两个操作数
 * 然后构建 newList 继续dfs
 *
 *8/26/20.
 */
public class _679_24_Game {
    public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length  == 0){
            return false;
        }
        LinkedList<Double> list = new LinkedList<Double>();
        for(int val: nums){
            list.add((double)val);
        }
        return dfs(list);
    }

    public boolean dfs(LinkedList<Double> list){
        if(list.size() ==1 ){
            if(Math.abs(list.get(0) - 24) < 0.001){
                return true;
            }
            return false;
        }

        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){

                for(double val: compute((double)list.get(i), (double)list.get(j))){
                    LinkedList<Double> newList = new LinkedList<Double>();
                    newList.add(val);
                    for(int m=0; m<list.size(); m++){
                        if(m!=i && m!=j){
                            newList.add(list.get(m));
                        }
                    }
                    if(dfs(newList)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public List<Double> compute(double x, double y){
        List<Double> res = Arrays.asList(x+y, x-y, y-x,y*x, x/y,y/x);
        return res;
    }
}
