package dynamicProgram.count;

/**
 * M1: 优美的 Iteration problem
 *
 * M2： Dp

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

1.state
 d[i][j] 取word1 i 个字符 与 word2 j 个字符相匹配时，需要的操作数
2.init
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
}
