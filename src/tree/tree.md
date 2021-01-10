*Binary Search Tree* is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.

The right subtree of a node contains only nodes with keys greater than the node’s key.

The left and right subtree each must also be a binary search tree.


Preorder: 根 左 右

Inorder: 左 右 根

Postorder: 左 右 根

Tree Type:
Full Binary Tree: 一棵二叉树的所有节点要么没有孩子节点，要么有两个孩子节点。
Complete Binary Tree: 完全二叉树，每一层都是紧凑靠左排列的
Perfect Binary Tree: 满二叉树，是一种特殊的完全二叉树，每层都是是满的，像一个稳定的三角形

https://labuladong.gitbook.io/algo/labuladong-he-ta-de-peng-you-men/gao-xing-neng-duan-lian-she-ji

基本变化:
https://blog.csdn.net/My_Jobs/article/details/43451187
前序，中序，后序， 层次遍历(bfs)， 深度遍历(dfs)
前中后，分别iterative, recursive


树的递归
当前root节点该做什么，然后根据函数定义递归调用子节点，递归调用会让孩子节点做相同的事情