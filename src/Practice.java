import java.util.List;

public class Practice {
    static int count = 0;
    public static void yzjdCount(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            count++;
        }
        yzjdCount(root.left);
        yzjdCount(root.right);
    }

    public static int yzjdCount2(Node root){
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = yzjdCount2(root.left);
        int right = yzjdCount2(root.right);
        return left + right;
    }
    public Node search(Node root,char val){
        if(root == null){
            return null;
        }
        if(root.ch == val){
            return root;
        }
        if(root.ch != val){
            Node left =  search(root.left,val);
            if(left != null){
                return left;
            }

            Node right = search(root.right,val);
            if(right != null){
                return right;
            }
        }
        return null;
    }

    public boolean search2(Node root,char val){
        if(root == null){
            return false;
        }
        if(root.ch == val){
            return true;
        }
        if(search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }
    public boolean isMirror(Node p,Node q){
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
    public static Node build(List<Character> inOrder, List<Character> postOrder){
        int size = postOrder.size();
        char p = postOrder.get(size - 1);
        int i =  inOrder.indexOf(p);
        Node root = new Node(p);
        List<Character> leftin = inOrder.subList(0,i);
        List<Character> leftpost = postOrder.subList(0,i);
        Node left =  build(leftin,leftpost);
        root.left = left;
        List<Character> rightin = inOrder.subList(i,inOrder.size());
        List<Character> rightpost = postOrder.subList(i,postOrder.size());
        Node right = build(rightin,postOrder);
        root.right = right;
        return root;
    }
}








