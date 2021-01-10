package array.slidingWindow;

/**
 *
 *     // 2 points
 //days[bulbs[i]-1] = i+1; why it's based on day index from +1


 // for 里的condition没有做好, 什么时候继续，什么时候跳出
 *
 *
 * 暗藏玄机
 *
 * 1/
 * bulbs[i]  means i+1 day open position at bulbs[i]
 * days[bulbs[i]-1] = i+1   means at position bulbs[i]-1, open at day i+1 // position 全部向左移了一位
 *
 * 2/ left =i, right = i+K+1
 * 是要求中间有k朵花，不是中间临近位置，所以用k+1
 *
 * 3/ res要设全局比较值,return 时还要判断一下
 *
 * res = Math.min(res, Math.max(day[left],days[right]))
 *
 * 4/ for循环里放 for(int i=0; right<len;i++)
 *
 * 防止越界
 *
 *
 * 5/ 判断的是 days[i] position i's open day should later than, later is big
 * if(days[i]> days[left] && days[i] > days[right])
 *
 *
 * 11/02/20
 *
 * 首先，他反向转换数组，用位置-> 正向iterate，
 *
 * 构建days的数组 days[bulbs[i] -1] = i+1
 *
 *
 * 看天，天数不合题意，则替换掉left, right,重新来过
 *
 * T:O(N)
 * S:O(N)
 *
 *
 * 10/20/20.
 */
public class _683_K_empty_slots {
    public int kEmptySlots(int[] bulbs, int K) {
        // Corner Case check
        if(bulbs == null || bulbs.length == 0){
            return -1;
        }
        int[] days = new int[bulbs.length];
        int left = 0, right = K+1;
        for(int i=0; i<bulbs.length; i++){
            // ?这个关系是如何确定的
            // 天数是从1,2,3开始的
            // 而位置我需要，再变换成0开始，
            // 之后的bulbs 不重要了，换成 days进行运算
            days[bulbs[i]-1] = i+1;
        }
        int res = Integer.MAX_VALUE;
        // i 和 days[left] , days[right] 的关系
        for(int i=0; right<bulbs.length; i++){

            // 一次只开一盏灯，没有等号
            if(days[i]> days[left] && days[i] > days[right]){
                continue;
            }

            if(i == right){
                res = Math.min(res, Math.max(days[left],days[right]));
            }
            left = i;
            right = i+K+1;

        }
        return res == Integer.MAX_VALUE? -1: res;
    }

    public static void main(String[] args){
        _683_K_empty_slots solution = new _683_K_empty_slots();
        int[] arr = {1,2,3};
        int[][] teser = {{1,2,3},{1,34,5}};
        int res = solution.kEmptySlots(arr,1);
        System.out.println(teser);
    }

}
