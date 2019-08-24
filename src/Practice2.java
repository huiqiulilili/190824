import java.util.*;

class Solution {
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return isSameTree(p.left,q.right)&&
                isSameTree(p.right,q.left)&&
                q.ch == p.ch;
    }
    public boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }

        return isSameTree(root,root);

    }
}
public class Practice2 {

    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;

        return a;
    }

    //前序遍历
    //把树看成 根 + 左子树 + 右子树
    public static List<Character> perOrderTraversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Character> list = new ArrayList<>();

        List<Character> left = perOrderTraversal(root.left);
        List<Character> right = perOrderTraversal(root.right);
        list.add(root.ch);
        left.addAll(left);
        list.addAll(right);
        return list;
    }

//    static List<Character> list;
//
//    private static void perOrder(Node root){
//        if(root == null){
//            return;
//        }
//        list.add(root.ch);
//        perOrder(root.left);
//        perOrder(root.right);
//    }
//    public static List<Character> perOrderTraversal2(Node root){
//        list = new ArrayList<>();
//        perOrder(root);
//        return list;
//    }


    //计算二叉树结点个数
    //第一种 遍历
//    static int count = 0;
//    public static void calcCount(Node root){
//
//        if(root == null){
//            return;
//        }
//
//        count++;
//        calcCount(root.left);
//        calcCount(root.right);
//    }

    //第二种
    //汇总
//    public static int calcCount2(Node root){
//        if(root == null){
//            return 0;
//        }
//        int left = calcCount2(root.left);
//        int right = calcCount2(root.right);
//        int count = right + left + 1;
//        return count;
//    }

    //计算叶子结点的个数
    //第一种遍历
//    static int leafCount = 0;
//    public static void calcLeafCount(Node root){
//        if(root == null){
//            return;
//        }
//
//        if(root.left == null && root.right == null){
//            leafCount++;
//        }
//        calcLeafCount(root.left);
//
//        calcLeafCount(root.right);
//    }
    //第二种
    //汇总
//    public static int calcLeafCount2(Node root){
//        if(root == null){
//            return 0;
//        }
//        if(root.left == null && root.right == null){
//            return 1;
//        }
//       int left =  calcLeafCount2(root.left);
//       int right = calcLeafCount2(root.right);
//       return left + right;
//    }

    //计算二叉树的高度
    //汇总
//    public static int calcHight(Node root){
//        if(root == null){
//            return 0;
//        }
//        int left = calcHight(root.left);
//        int right = calcHight(root.right);
//        int hight = Math.max(right,left) + 1;
//        return hight;
//    }


    //计算二叉树第K层节点的个数
//    public static int calcKLevel(Node root,int k){
//        if(root == null){
//            return 0;
//        }
//        if(k == 1){
//            return 1;
//        }
//        int left = calcKLevel(root.left,k - 1);
//        int right = calcKLevel(root.right,k - 1);
//        return left + right;
//    }

    //查找
//    public static Node search(Node root,char val){
//        if(root == null){
//            return null;
//        }
//        if(root.ch == val){
//            return root;
//        }
//        Node left = search(root.left,val);
//        if(left != null){
//            return left;
//        }
//        Node right = search(root.right,val);
//        if(right != null){
//            return right;
//        }
//        return null;
//    }


    //查找，返回boolean

//    public static boolean search2(Node root,char val){
//        if(root == null){
//            return false;
//        }
//        if(root.ch == val){
//            return true;
//        }
//        if(search2(root.left,val)){
//            return true;
//        }
//        if(search2(root.right,val)){
//            return true;
//        }
//        return false;
//    }

    //检查两棵树是否相等
//    public boolean isSameTree(Node p,Node q) {
//        if(p == null && q == null){
//            return true;
//        }
//        if(p == null || q == null){
//            return false;
//        }
//        return isSameTree(p.left,q.left)&&
//                isSameTree(p.right,q.right)&&
//                q.ch == p.ch;
//    }

    //检查两棵树是否镜像对称

    public static boolean isMirror(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        return p.ch == q.ch
                && isMirror(p.left,q.right)
                && isMirror(p.right,q.left);
    }

    //前序 + 中序
    public static Node buildTree1(List<Character> preOrder,List<Character> inOrder){
        char c = preOrder.get(0);
        int size = preOrder.size();
        int i = inOrder.get(c);

        Node root = new Node(c);
        List<Character> leftp = preOrder.subList(1,1 + size);
        List<Character> lefti = inOrder.subList(0,size);
        Node left =  buildTree1(leftp,lefti);
        root.left = left;

        List<Character> rightp = preOrder.subList(1 + size,preOrder.size());
        List<Character> righti = inOrder.subList(size + 1,inOrder.size());
        Node right = buildTree1(righti,rightp);
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

//        System.out.println(search(buildTree(),'C'));
    }
}
