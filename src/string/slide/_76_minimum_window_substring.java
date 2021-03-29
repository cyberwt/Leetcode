package string.slide;

/**
 * Track back same content:
 *
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 *
 * 3/10/20
 *
 * 此外，判断当前窗口是否含有所有字母，我们除了可以判断所有字母的次数是否小于等于 0，还可以用一个计数变量 count，把 count 初始化为 t 的长度，然后每次找到一个满足条件的字母，count 就减 1，如果 count 等于了 0，就代表包含了所有字母。这样的话，可以把之前的 match(map) 优化到 O（1）
 *
 *
 * 可以先考虑map 技法，但每一步要用一个common map函数去看是否能够移动左指针
 *
 * 很巧妙，这里我只用一个map, 却记录出我想要的两组值
 *
 * 以t为标准构建int[] index 数组
 *
 * 右指针一直在移动， 左指针在 len==0时，在s里钩值
 * 若此时int[] index 里查出 ++index[j++]>0 时，才能证明我是存在再远数组里，没被剥夺的
 *
 * s是看作一直往外拿：cc[s.charAt(i)]-- >0
 * 右移j,则是恢复原数组，向里面放值
 *
 * 7/7/20.
 */
public class _76_minimum_window_substring {
    public String minWindow(String s, String t) {
        //it's a truncate string don't need substring here
        if(s==null || s.length()==0 || t== null || t.length()==0){
            return "";
        }
        int res = Integer.MAX_VALUE;
        int from = 0;
        int[] cc = new int[255];
        int len = t.length();
        for(int i=0; i<len; i++){
            cc[t.charAt(i)]++;
        }
        int j =0; // j is the start value

        for(int i=0; i<s.length(); i++){
            //满了我再算
            if(cc[s.charAt(i)]-- >0){
                len --;
            }
            while(len == 0){
                if(res > i-j+1 ){
                    res = i-j+1;
                    from = j;
                }
                if(++cc[s.charAt(j++)] > 0){
                    len++;
                }
            }
        }
        return (res == Integer.MAX_VALUE )? "" :s.substring(from, from+res);
    }

    public static void main(String[] args) {
        _76_minimum_window_substring solution = new _76_minimum_window_substring();
        System.out.println(solution.minWindow("ASCEWFCREW","ACW"));
    }
}
