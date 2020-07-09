package stack.string;

import stack.parentheses._20_valid_parentheses;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * 不要只想着数量，每道题是真的掌握了么
 * 1.数据结构： Deque-> 双向链表， 需实例化  new LinkedList<>()
 *
 * 2.String 比较，需要用equals
 *
 * 3. pop前，要看不为空，且在下一层
 *
 * 4. Iterate 的结果要是从 老向新，stack 符合题意，但重组结构是：res =  res+ "/" +val;
 *
 *
 *
 * 7/5/20.
 */
public class _71_simplify_path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for(String str: strs){
            if(str.length() == 0 || str.equals(".")){
                continue;
            }else if(str.equals("..") ){

                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{

                stack.push(str);
            }
        }
        String res= "";
        for(String val:stack){
            System.out.println(res);
            res =  res+ "/" +val;
        }
        return res.length() == 0 ? "/":res;

    }


    public String simplifyPath2(String path) {
        //先利用 "/" 将字符串分割成一个一个单词
        String[] wordArr = path.split("/");
        //将空字符串（由类似这种"/a//c"的字符串产生）和 "." （"."代表当前目录不影响路径）去掉，保存到 wordList
        ArrayList<String> wordList = new ArrayList<String>();
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i].isEmpty() || wordArr[i].equals(".")) {
                continue;
            }
            wordList.add(wordArr[i]);
        }
        //wordListSim 保存简化后的路径
        ArrayList<String> wordListSim = new ArrayList<String>();
        //遍历 wordList
        for (int i = 0; i < wordList.size(); i++) {
            //如果遇到 ".."，wordListSim 就删除末尾的单词
            if (wordList.get(i).equals("..")) {
                if (!wordListSim.isEmpty()) {
                    wordListSim.remove(wordListSim.size() - 1);
                }
                //否则的话就加入 wordListSim
            } else {
                wordListSim.add(wordList.get(i));
            }
        }
        //将单词用 "/" 连接
        String ans = String.join("/", wordListSim);
        //开头补上 "/"
        ans = "/" + ans;
        return ans;

    }

    public static void main(String[] args) {
        _71_simplify_path solution = new _71_simplify_path();
        System.out.println(solution.simplifyPath(".///../a/s/d/../"));
    }

}
