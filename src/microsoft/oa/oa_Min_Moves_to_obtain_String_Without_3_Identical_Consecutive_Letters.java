package microsoft.oa;

/**
 * Error:
 * 理解错了，以为是直接replace最后一个
 * 又理解错了，以为 swap要和string里面的字符swap
 *
 *
 * 其实是有三个一样的那我就该swap，不管在哪个位置/3就行，我用的时候还是 while + if 舒服
 * //  https://leetcode.com/discuss/interview-question/398026/
 *
 * 9/17/20.
 */
public class oa_Min_Moves_to_obtain_String_Without_3_Identical_Consecutive_Letters {
    public  int solution(String str){
        int res = 0;
        if(str == null || str.length() ==0){
            return res;
        }

        int count =1;
        int i=1;
        while(i<str.length()){
            if( str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                res +=count/3;
                count=1;

            }
            i++;
        }

        return res;
    }

    public static void main(String[] args){
        oa_Min_Moves_to_obtain_String_Without_3_Identical_Consecutive_Letters aa = new oa_Min_Moves_to_obtain_String_Without_3_Identical_Consecutive_Letters();
        int ans = aa.solution("baabaa");
        System.out.println(ans);
    }
}
