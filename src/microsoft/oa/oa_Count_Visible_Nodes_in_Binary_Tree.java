package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Count_Visible_Nodes_in_Binary_Tree {
    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public int solution(Node root){
        return solution(root,Integer.MIN_VALUE);
    }

    public int solution(Node node,int maxValue){
        if(node==null){
            return 0;
        }

        int count=0;
        if(node.value>=maxValue){
            count = count+1;
            maxValue = node.value;
        }

        count = count + solution(node.left,maxValue)+solution(node.right,maxValue);

        return count;
    }
}
