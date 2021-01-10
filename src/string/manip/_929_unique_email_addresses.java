package string.manip;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 处理string 的一个套路，慢慢走，一个接一个处理
 * 不用indexOf, 那就先处理localName, 再处理domainName
 *
 * T:O(N) S:O(1)
 *
 * HashSet的用法
 *
 * 10/18/20.
 */
public class _929_unique_email_addresses {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String can = helper(email);
            set.add(can);
        }
        return set.size();
    }
    private String helper(String e){
        int atIndex = 0, i = 0;
        while(atIndex < e.length() && e.charAt(atIndex) != '@'){
            atIndex++;
        }
        StringBuilder sb = new StringBuilder();
        for(int l = atIndex ; l < e.length(); l++){
            sb.append(e.charAt(l));
        }
        String domain = sb.toString();
        sb = new StringBuilder();
        while(i < atIndex){
            if(e.charAt(i) != '+' && e.charAt(i) != '.'){
                sb.append(e.charAt(i));
            }else if(e.charAt(i) == '+'){
                return sb.toString() + domain;
            }
            i++;
        }
        return sb.toString() + domain;
    }


}
