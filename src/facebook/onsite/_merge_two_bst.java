package facebook.onsite;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by weitong on 4/4/21.
 */


// actually iterator makes it super easy and understandable
public class _merge_two_bst {
    // how to construct
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }


    public List<Integer> megerTwoBST(TreeNode node1, TreeNode node2){
        // is it merge
        List<Integer> list = new LinkedList<Integer>();
        BSTIterator iterator1 = new BSTIterator(node1);
        BSTIterator iterator2 = new BSTIterator(node1);
        Integer val1=0, val2=0;
        boolean flag1 = true, flag2 = true;


        val1 =iterator1.hasNext() ? iterator1.next(): null;
        val2 =iterator2.hasNext() ? iterator2.next(): null;

        while(val1 != null || val2 != null){

            if(val1 == null || val1 > val2){
                list.add(val2);
                val2 = iterator2.hasNext() ? iterator2.next(): null;
            }else{
                list.add(val1);
                val1 =  val1 =iterator1.hasNext() ? iterator1.next(): null;
            }
        }

        return list;

    }


    class BSTIterator{
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root){
            stack = new Stack<TreeNode>();
            TreeNode node = root;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }

        public int next(){
            TreeNode node = stack.pop();
            TreeNode cur = node.right;
            while(cur !=null){
                stack.push(cur);
                cur = cur.left;
            }

            return node.val;
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }
    }



}
