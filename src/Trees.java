import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trees {
    public static Node BTrees(){
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        d.left=d.right=e.right=e.left=f.right=f.left=g.right=d.left=null;
        return a;
    }
    //前序遍历
    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        //跟+左子树+右子树；
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        //左子树+跟+右子树；
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        //左子树+右子树+跟
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
    //返回前序链表
    public static List<Integer> preOrder(Node root) {
      if(root==null){
          //如果树为空，则返回一个空的链表  （用链表实现的list）
              return new LinkedList<>();
          }
          //跟+左子树+右子树；
          List<Integer> list=new LinkedList<>();//本次递归的结果集，第一次的是最终的结果集
          //树不为空，先创建一个表，再得到它的左子树的前序链表和右子树的前序链表
          List<Integer> leftPreOrder=preOrder(root.left);
          List<Integer> rightPreOrder=preOrder(root.right);

          //把当前节点存入链表，然后将他的左列表放入，右列表放入
          list.add(root.value);
          list.addAll(leftPreOrder);
          list.addAll(rightPreOrder);
          return list;
    }
    //遍历思想：设定一个变量跟随着调用去++
    //汇总思想：总的=跟结点+左子树+右子树


    //遍历思想，求总结点个数
    public static void calcCount1(Node root){
        if(root==null){
            return;
        }
        //结点不为空，就++一次
        count++;
        calcCount1(root.left);
        calcCount1(root.right);

    }
    //汇总思想，求总结点个数
    //判断根节点，去找它的左子树总结点个数，去找它的右子树总结结点个数
    static int count=0;
    public static int calcCount2(Node root){
        if(root==null){
            return 0;
        }
        int left=calcCount2(root.left);
        int right=calcCount2(root.right);
        int count=1+left+right;
        return count;
    }
    //遍历求数的叶子结点
    public static int leafCount=0;
    public static int calcLeafCount1(Node root){
        if(root==null){
            return 0;
        }
        //先去看他的左子树的叶子结点，如果里面左右子树都为空，则++
        calcLeafCount1(root.left);
        if(root.left==null&&root.right==null) {
            leafCount++;
        }
        //注意:如果该点是叶子结点，在上一步if就已经把左右都判断了，下面调用肯定是返回
        //0的，可是要写下面调用的原因是主要判断回溯到上一个结点时的右子树，并不是来
        //判断该点的右子树，该点的上一步已经判断过了，
        calcLeafCount1(root.right);
        return leafCount;
    }
    //汇总求叶子结点
    public static int calcLeafCount2(Node root) {
        if(root==null){
            return 0;
        }
        //代表只有一个结点的数
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=calcLeafCount2(root.left);
        int right=calcLeafCount2(root.right);
        return left+right;
    }
    //求数的高度
    public static int calcHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=calcHeight(root.left);
        int right=calcHeight(root.right);
        int height=Math.max(left,right)+1;
        return height;
    }
    //求第k层的总结点数
    public static int calcKLevel(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int left=calcKLevel(root.left,k-1);
        int right=calcKLevel(root.right,k-1);
        //左子树第k层节点加上右子树第k层结点
        int count=left+right;

        return count;
    }
    //查找树中有没有这个结点
    public static Node search(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        //除了这两种可能之外，会一直去左子树找
        Node left=search(root.left,val);
        //如果left为空就不能来到判断这一步，会一直调用上面的方法
        //如果left为空说明左树没找到，如果不为空，说明找到了，
        if(left!=null){
            return left;
        }
        Node right=search(root.right,val);
        if(right!=null){
            return right;
        }
        //都没有找到则返回null
        return null;
    }
    //两个数互为镜像
    public boolean isMirror(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.value==q.value
                &&isMirror(q.left,p.right)
                &&isMirror(q.right,p.left);
    }
    //数中查找值
    public boolean search2(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.value==val){
            return true;
        }
        boolean left=search2(root.left,val);
        if(left){
            return true;
        }
        boolean right=search2(root.right,val);
        if(right){
            return true;
        }
        return false;
    }
    //public static Node buildTree2(List<Character> inorder,List<Character> postorder){}
    // 前序 + 中序
    public static Node buildTree1(List<Character> preorder, List<Character> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTree1(leftPreorder, leftInorder);
        root.left = left;
        List<Character> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Character> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        Node right = buildTree1(rightPreorder, rightInorder);
        root.right = right;
        return root;
    }
    public static void main(String[] args) {
        List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        Node root = buildTree1(preorder, inorder);
        System.out.println("成功");
        Node root2 = BTrees();
        preOrderTraversal(root2);
        System.out.println("=======================");
        inOrderTraversal(root2);
        System.out.println("=======================");
        postOrderTraversal(root2);
        System.out.println("=======================");
        System.out.println(preOrder(root2));
    }
}

