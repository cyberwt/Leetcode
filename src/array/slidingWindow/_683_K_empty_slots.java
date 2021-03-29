package array.slidingWindow;

/**
 *
 *
 * 有一些错误：
 Error:
 1。left =1, right = k+1+1; 因为left,right得进去且不能参与运算!
 2。 不要再for里面算计了，
 放一个if(right > len) break;更好理解
 3.  res = Math.min(res, Math.max(pos[left], pos[right]) +1);
 要+1, 因为是第二天！
 4. if(pos[i]> pos[left] && pos[i] > pos[right]) 需要是这个结局

 *
 *
 * 3/26/21
 *
 * Let's end this finally
 *
 *
 *  1. Switch the distance arr to days arr
   Observe in those positions, if there a pos that fits
   days[left] <   days[index] && days[right] <   days

   2. 符合题意就 continue,
    else 重新计算i, j

   3. 有一个Corner Case for:
    i+k+2 (right) < len
 *
 *
 * T:O(N) S:O(N)
 *
 *
 * 3/16/21
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
    public int kEmptySlots(int[] bulbs, int k) {
        if(bulbs == null || bulbs.length == 0){
            return -1;
        }
        // 就是因为distance 多起跳一格
        int len = bulbs.length;
        int[] days = new int[len+1];
        for(int i=0; i<len;i++){
            // 天数， 位置上
            days[bulbs[i]] = i;
        }

        int res = Integer.MAX_VALUE;
        int left =1, right = k+1+1;
        for(int i=1; i<len+1 ;i++){
            if(right>len) break;
            if(days[i] > days[left] && days[i] > days[right]){
                continue;
            }
            if(i == right){
                res = Math.min(res, Math.max(days[left], days[right])+1);
            }
            left = i;
            right = i+k+1;
        }
        return res == Integer.MAX_VALUE ? -1: res;
    }

    public static void main(String[] args){
        _683_K_empty_slots solution = new _683_K_empty_slots();
        int[] arr = {1,2,3};
        int[][] teser = {{1,2,3},{1,34,5}};
        int res = solution.kEmptySlots(arr,1);
        System.out.println(teser);
    }

}
