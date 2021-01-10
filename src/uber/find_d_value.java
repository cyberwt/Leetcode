package uber;

import java.util.TreeSet;

/**  https://leetcode.com/discuss/interview-question/490610/Uber-or-OA
 * 完全符合数学公式:
 *
 *  |y-x| <= d
 *  x-d <= y <= x +d
 *
 *
 *
 *
 * 10/24/20.
 */
public class find_d_value {
    public static int find_it(int[] a, int[] b, int d){
        if(a==null || b == null || a.length ==0 || b.length == 0){
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        int res=0;
        for(int valb:b){
            set.add(valb);
        }

        for(int vala:a){
            int min = vala-d;
            Integer findVal = set.ceiling(min);
            if(findVal == null || findVal > vala+d){
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int []A ={2,9,19, 20};
        int []B ={16, 13,8};
        int c = find_it(A, B, 3);
        System.out.println("count: "+c);
        String tester = 4 + " " + 6;
        int[][] pos= {{1,-1},{1,1},{-1,1},{-1,-1}};
        System.out.println(tester);
    }


}
