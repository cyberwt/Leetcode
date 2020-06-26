package string.palindrome;

/**
 * Created by weitong on 6/26/20.
 */
public class _9_palindrome_number {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x>0 && x%10 == 0)){
            return false;
        }
        int rev = 0;
        while(x> rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev) || (rev/10 == x);
    }
    public static void main(String[] args) {
        _9_palindrome_number solution = new _9_palindrome_number();
        System.out.println(solution.isPalindrome(123));
    }
}
