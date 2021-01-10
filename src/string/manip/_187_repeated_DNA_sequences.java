package string.manip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 用 hashset 的查找来做
 * 有没有用contains 来看
 *
 * 然后会赚到 new ArrayList(map);
 * 8/19/20.
 */
public class _187_repeated_DNA_sequences{
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> set = new HashSet<String>();
        HashSet<String> res = new HashSet<String>();
        for(int i=0; i<s.length()-9; i++){
            String val = s.substring(i,i+10);
            if(set.contains(val)){
                res.add(val);
            }
            set.add(val);
        }
        return new ArrayList(res);
    }

}
