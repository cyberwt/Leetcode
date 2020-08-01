package string.manip;

/**
 * >用while + /if/if/if 去判定每一格的变化 比while+ while 更安全
 *
 * > 且求差的方法其实并不靠谱: Math.abs, 因为他会有 0,P 这种情况 转而
 * 换成  s = s.toLowerCase()
 *
 * 7/30/20.
 */
public class _125_valid_palindrome {
    public boolean isPalindrome(String s) {
        //怎么换成最优解
        if(s == null || s.length() == 0){
            return true;
        }

        int left =0, right =s.length() -1;
        s = s.toLowerCase();
        while(left <= right){
            if(!isValid(s.charAt(left)) ){
                left++;
            }

            else if(!isValid(s.charAt(right))){
                right--;
            }


            else if( s.charAt(left) != s.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isValid(Character c){
        if((c>= 'a'&& c<= 'z') || (c>='A' && c<= 'Z') || (c>= '0' && c<= '9') ){
            return true;
        }
        return false;
    }
}
