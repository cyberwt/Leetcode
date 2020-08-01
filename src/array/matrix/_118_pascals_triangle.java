package array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 理解 Iterative
 *  vs recursive
 * Error:
 * 1. index 的取得要注意 0 or 1
 *
 * 7/29/20.
 */
public class _118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for(int j=0; j< numRows; j++){
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<= j; i++){
                System.out.println("i: " + i + " j:" +j);
                if(i == 0 || i == j || j==0){
                    list.add(1);
                }else{
                    int tem = res.get(j-1).get(i-1) + res.get(j-1).get(i);
                    list.add(tem);
                }

            }
            res.add(list);
        }

        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        generate(list, numRows);
        return list;

    }

    public void generate(List<List<Integer>> list, int numRows) {
        if (numRows == 1) list.add(Arrays.asList(1));
        else if (numRows > 1) {
            generate(list, numRows -1);
            List<Integer> previousList = list.get(numRows -2);
            List<Integer> thisList = new ArrayList<>();
            for (int i = 0; i < previousList.size(); i++) {
                if (i == 0) thisList.add(1);
                if (i > 0) thisList.add(previousList.get(i) + previousList.get(i-1));
                if (i == previousList.size() -1) thisList.add(1);
            }
            list.add(thisList);
        }
    }


}
