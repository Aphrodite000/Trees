import java.util.ArrayList;
import java.util.List;

//要求返回前序
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
//放一个全局变量
public class Solution {
   private List<Integer> list;
   private void perOrder(TreeNode root) {
       if(root==null){
           return;
       }
       list.add(root.value);
       perOrder(root.left);
       perOrder(root.right);
   }
   private List<Integer> pre0rderTraversal(TreeNode root) {
       list=new ArrayList<>();
       perOrder(root);
       return list;
   }
}
