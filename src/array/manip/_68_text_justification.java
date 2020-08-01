package array.manip;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Error:
 *  1. last 指的是结束点，算的时候并没有包含进去
 *  count 和last 构建，确定此行长什么洋子
 *
 *  2. 构建sb 的两种情况
 *  *只有一个数 ｜｜ 已经到了最后一个数  左贴合
 *  *正常情况，判断 spaces 和 extra_spaces (与i的关系)
 *
 *  Corner Case:
 *  a. count += 1+ words[last].length(); 什么时候需要加一个空格值
 *  b. 左贴会有两种可能情况
 *  c. space remain 的计算方式
 *
 * 7/12/20.
 */
public class _68_text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //https://leetcode.com/problems/text-justification/discuss/24876/Simple-Java-Solution
        LinkedList<String> res = new LinkedList<String>();

        int index = 0;
        while(index < words.length){
            int last = index+1;
            int count = words[index].length();


            // do I need two constrain here to avoid keep looping
            while(last<words.length){
                if((count + 1 + words[last].length())> maxWidth) break;
                count += 1+ words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            if(index+1 == last || last==words.length){
                for(int i=index; i<last; i++){
                    sb.append(words[i]+ " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for(int i=sb.length(); i<maxWidth; i++){
                    sb.append(" ");
                }
            }else{
                int diff = last - index-1;
                int space = (maxWidth-count)/diff;
                int remain = (maxWidth-count) % diff;
                // construct a builder to append

                for(int i=index; i<last;i++){
                    sb.append(words[i]);
                    if(i!=last-1){
                        // calculate by i not j to define the extra space
                        for(int j=0; j<=space + ( (i-index) <remain? 1:0) ;j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            index = last;
        }

        return res;
    }
}
