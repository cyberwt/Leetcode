package string.reverse;

/**
 * 为什么要这样全反，这样不用再查，且是inplace
 *
 * 全局反，局部反
 *
 * 最后一组 要特别的反序
 *
 * 8/19/20.
 */
public class _186_reverse_words_in_a_string_II {
    public void reverseWords(char[] s) {
        //how to make this code clear
        // inplace reverse

        if(s==null || s.length == 0){
            return;
        }
        reverse(s, 0, s.length-1);
        int start =0;
        for(int i=0; i<s.length; i++){
            if(s[i] != ' '){
                continue;
            }else{
                reverse(s,start,i-1);
                start = i+1;
            }
        }
        reverse(s,start,s.length-1);
    }

    public void reverse(char[] s,int start, int end){
        while(start < end){
            char tem = s[start];
            s[start] = s[end];
            s[end] = tem;
            start++;
            end--;
        }
    }

}
