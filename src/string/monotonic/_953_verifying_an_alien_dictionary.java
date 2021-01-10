package string.monotonic;

/**
 * 单调性 if a2>a1, a3>a2 => a3>a1
 * 所以设一个arr,一个一个词去比
 * 当比到相等且其中一个已越界时，最后比长度
 *
 * 8/28/20.
 */
public class _953_verifying_an_alien_dictionary {
    private int[] arr = new int[26];
    public boolean isAlienSorted(String[] words, String order) {

        for(int i=0; i<order.length(); i++){
            arr[order.charAt(i)-'a'] = i;
        }

        for(int i=1; i<words.length; i++){
            if(!compute(words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }

    public boolean compute(String a, String b){

        for(int i=0; i<a.length() && i<b.length(); i++){
            if(arr[a.charAt(i)-'a']<arr[b.charAt(i)-'a']){
                return true;
            }
            if(arr[a.charAt(i)-'a']>arr[b.charAt(i)-'a']){
                return false;
            }
        }

        if(a.length() > b.length()){
            return false;
        }
        return true;
    }
}
