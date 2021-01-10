package dynamicProgram.count;

/**
 * 8.31 二刷
 * > 又被曾经的惯性思维弄倒，增删查，分别有对应操作
 * > dp 大口诀
 *
 *
 *
 * M1: 优美的 Iteration problem
 *
 * M2： Dp  t:o(mn) s:o(mn)

 D("abbc“，“acc")            //2

   = D("ab”，"ac”）          //2, no edit on last c

    = 1+min(D("ab”，"ac”）, //1, delete ab[b]

            D(“abb”，“a"), //2, insert a[c]

            D(“ab”，“a”）  //1, replace ab [b】」toa [c]

                  i
                 ------------------
               j |
                 |      改         增
                 |    (i-1,j-1) (i,j-1)
                 |
                 |      删
                 |    (i-1,j)   (i,j)


 基本步骤

 D(i, j):= minDIstance(word1[0..i-1],
                       word2[0. j-1])

1.确定状态- state
 d[i][j] 取word1 前i 个字符 与 前word2 j 个字符相匹配时，需要的操作数
 ! 无论我增减删, 变得不是数组的结构，依旧是在 i,j上变的
2.init 初始(边界)条件
 d(i, j) =
   1. i if j==0
   2. j if i==0
3.状态转移方程
 d(i, j) =
   d(i-1, j-1) if
        word1[i-1) == word (j-1]
   Min(d(i -1, j),
       d(i, j-1),
       d(i-1, j-1)) +1

T: O(L1*L2)

S: O(L1*L2) ->(min(L1, L2))




 *
 *
 * 7/12/20.
 */
public class _72_edit_distance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int x = minDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
        int y = minDistance(word1.substring(0, word1.length() - 1), word2) + 1;
        int z = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        if(word1.charAt(word1.length()-1)!=word2.charAt(word2.length()-1)){
            z++;
        }
        return Math.min(Math.min(x, y), z);
    }
    // memorize solution
    int[][] dp;

    public int minDistance3(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        return minDistanceHelper(word1, word2, 0, 0);
    }

    private int minDistanceHelper(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length()) return word2.length() - index2;
        if (index2 == word2.length()) return word1.length() - index1;

        if (dp[index1][index2] > 0) return dp[index1][index2];

        int result;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            result = minDistanceHelper(word1, word2, index1+1, index2+1);
        } else {
            // replace char
            result = 1 + minDistanceHelper(word1, word2, index1+1, index2+1);

            // delete char from word1
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1+1, index2));

            // delete char from word2
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1, index2+1));
        }

        dp[index1][index2] = result;
        return result;
    }


    public int minDistance2(String word1, String word2) {

        if(word1 == null || word2 == null){
            return 0;
        }

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];


        dp[0][0]= 0;
        for(int i=1;i<=m;i++){
            dp[i][0] =i;
        }
        for(int j=1;j<=n;j++){
            dp[0][j] =j;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}
