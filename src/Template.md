
*双指针
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.

*二分
https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems

* Union find
https://blog.csdn.net/liujian20150808/article/details/50848646


孤独九剑
独孤九剑 —— 破剑式：比O(n)更优的时间复杂度 几乎只能是O(logn)的二分法

 

独孤九剑——破枪式
能够用 BFS 解决的问题，一定不要用 DFS 去做! 因为用 Recursion 实现的 DFS 可能造成 StackOverflow!
(NonRecursion 的 DFS 一来你不会写，二来面试官也看不懂) 

总结：先想最短路的BFS，再想所有路的DFS(backtracing)

 

独孤九剑 —— 破鞭式 碰到让你找所有方案的题，一定是DFS。 90%DFS的题，要么是排列，要么是组合

 

独孤九剑 —— 破索式 链表结构发生变化时，就需要 Dummy Node

 

独孤九剑 —— 破掌式 对于求 2 个变量如何组合的问题，可以循环其中一个变量，然后研究另外一个变量如何变化
 

独孤九剑 —— 破箭式 BFS 的主要数据结构是 Queue
DFS 的主要数据结构是 Stack 千万不要搞反了!很体现基础知识的扎实度!