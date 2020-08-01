package array.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * M2:
 *
 * 巧妙的转化为 只在curList进行运算，
 *
 * 所以要注意，边界能取到么，怎么进行 到底 取等还是不等 的边界判断
 *
 *
 * 7/29/20.
 */
public class _119_pascals_triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new LinkedList<Integer>();
        List<Integer> curList = new LinkedList<Integer>();


        for(int i=0; i<=rowIndex; i++){
            curList = new LinkedList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j == i){
                    curList.add(1);
                }else{
                    int tem = preList.get(j-1) + preList.get(j);
                    curList.add(tem);
                }
            }
            preList =curList;

        }
        return preList;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> curList = new LinkedList<Integer>();
        curList.add(1);
        int pre = 1;
        for(int i=1; i<=rowIndex; i++){
            for(int j=1; j<i; j++){
                int temp = curList.get(j);
                curList.set(j, pre + curList.get(j));
                pre = temp;
            }
            curList.add(1);
        }
        return curList;
    }
}
