public class Practice3 {

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

    //计算节点数
//    static int count = 0;
//    public static void perOrder(Node root){
//        if(root == null){
//            return;
//        }
//        count++;
//        perOrder(root.left);
//        perOrder(root.right);
//    }

    //计算节点数
//    public static int  perOrder2(Node root){
//        if(root == null){
//            return 0;
//        }
//        int left = perOrder2(root.left);
//        int right = perOrder2(root.right);
//        return left + right + 1;
//    }

    //计算叶子结点个数
    //第一种
//    static int leafCount = 0;
//    public static void calcLeafCount(Node root){
//        if(root == null){
//            return;
//        }
//        if(root.left == null && root.right == null){
//            leafCount++;
//        }
//        calcLeafCount(root.left);
//        calcLeafCount(root.right);
//    }

//    public static int calcLeafCount2(Node root){
//        if(root == null){
//            return 0;
//        }
//        if(root.left == null && root.right == null){
//            return 1;
//        }
//       int left =  calcLeafCount2(root.left);
//       int right =  calcLeafCount2(root.right);
//       return left + right;
//    }

    //计算二叉树第K层结点
    public static int calcKLevel(Node root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int left = calcKLevel(root.left,k - 1);
        int right = calcKLevel(root.right,k - 1);
        return left + right;
    }

    public static void main(String[] args) {
//        System.out.println(calcLeafCount2(buildTree()));
    }
}
