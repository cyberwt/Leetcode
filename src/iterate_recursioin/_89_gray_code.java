package iterate_recursioin;

import java.util.LinkedList;
import java.util.List;

/**
 * 了解格雷码是如何构成的
 *
 * * 上一组的反解构成下一组的值
 *
 * * 且顺序是: res.add(res.get(j) + val);
 *
 * 7/13/20.
 */
public class _89_gray_code {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<Integer>();
        res.add(0);
        for(int i=0; i<n;i++){
            int val = 1<<i;
            for(int j=res.size()-1; j>=0; j--){
                res.add(res.get(j) + val);
            }
        }

        return res;
    }
}
