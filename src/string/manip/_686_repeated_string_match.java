package string.manip;

/**
 * sb.toString().contains(A) - 不断向下构造
 *
 * 10/22/20.
 */
public class _686_repeated_string_match {
    public int repeatedStringMatch2(String A, String B) {
        if(A==null || B==null)
            return -1;

        StringBuilder temp = new StringBuilder();
        int count = 0;
        while(temp.length()<B.length()){
            temp.append(A);
            count++;
        }
        if(isFound(temp, B))
            return count;
        if(isFound(temp.append(A), B))
            return count+1;
        return -1;
    }

    private boolean isFound(StringBuilder A, String B){
        for(int i=0; i<A.length() ; i++){
            int start = i;
            int j=0;
            while(start<A.length() && j<B.length() && A.charAt(start) == B.charAt(j)){
                start++;
                j++;

            }
            if(j==B.length())
                return true;
        }
        return false;
    }


    public int repeatedStringMatch(String A, String B) {

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }
}
