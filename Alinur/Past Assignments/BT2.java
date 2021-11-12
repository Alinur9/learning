import java.util.ArrayList;
import java.util.LinkedList;

public class BT2 {
    TreeNode root = new TreeNode();
    int size = 0;
    int children = 0;
    ArrayList<TreeNode> leftNodes = new ArrayList<>();
    ArrayList<TreeNode> rightNodes = new ArrayList<>();
    LinkedList<TreeNode> eligibleParents = new LinkedList<>();
    public void add(int data){
        TreeNode newNode = new TreeNode(data);
        if (size == 0){
            root = newNode;
            eligibleParents.add(root);
            size++;
            return;
        }
        TreeNode parent =  eligibleParents.get(0);
        if (children == 0) {
            parent.left = newNode;
            parent.left.parent = parent;
            eligibleParents.add(newNode);
            children++;
        }
        else {
            parent.right = newNode;
            parent.right.parent = parent;
            eligibleParents.add(newNode);
            children++;
        }
        if (children == 2) {
            eligibleParents.remove(0);
            children = 0;
        }
        size++;
    }
    public void insert(int parentData, int data){
        TreeNode newNode = new TreeNode(data);
        TreeNode parent = new TreeNode();
        if (size == 0){
            root = newNode;
            eligibleParents.add(newNode);
            size++;
            return;
        }
        for (int i = 0; i < eligibleParents.size(); i++) {
            int eligibleParentData = eligibleParents.get(i).data;
            if (eligibleParentData == parentData){
                parent = eligibleParents.get(i);
                if (parent.left == null) {
                    parent.left = newNode;
                    eligibleParents.add(newNode);
                    newNode.parent = parent;
                    size++;
                    break;
                }
                else if (parent.right == null){
                    parent.right = newNode;
                    newNode.parent = parent;
                    eligibleParents.add(newNode);
                    eligibleParents.remove(parent);
                    size++;
                    break;
                }
                else return;
            }
        }
    }

    public void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public int height() {
        boolean leftRight = false;
        boolean rightLeft = false;
        leftHeight(root);
        rightHeight(root);
        int previousLeftHeight = leftNodes.size();
        int previousRightHeight = rightNodes.size();
        if (leftNodes.size() > 1) {
            if (leftNodes.get(0).right == null) {
                leftRight(leftNodes.get(1));
                leftRight = true;
            }
            else {
                leftRight(leftNodes.get(0));
                leftRight = true;
            }
        } else if (leftNodes.size() == 1)
            leftRight(leftNodes.get(0));
        if (rightNodes.size() > 1) {
            if (rightNodes.get(0).left == null) {
                rightLeft(rightNodes.get(1));
                rightLeft = true;
            }
            else {
                rightLeft(rightNodes.get(0));
                rightLeft = true;
            }
        } else if (rightNodes.size() == 1)
            rightLeft(rightNodes.get(0));
        if (rightNodes.size() >= leftNodes.size()) {
            if (rightLeft) {
                rightNodes.remove(rightNodes.size() - 1);
                return rightNodes.size() - 1;
            }
            else
                return rightNodes.size() -1;

        } else {
            if (leftRight) {
                leftNodes.remove(leftNodes.size()-1);
                return leftNodes.size() - 1;
            }
            else
                return leftNodes.size() -1;

        }
    }
    void leftHeight(TreeNode root){
        if (root == null)
            return;
        leftHeight(root.left);
        leftNodes.add(root);

    }
    void leftRight(TreeNode root){
        if (root == null)
            return;
        leftRight(root.right);
        // System.out.println(root.data);
        leftNodes.add(root);
    }
    void rightLeft(TreeNode root){
        if (root == null)
            return;
        rightLeft(root.left);
        // System.out.println(root.data);
        rightNodes.add(root);
    }
    void rightHeight(TreeNode root){
        if (root == null)
            return;
        rightHeight(root.right);
       // System.out.println(root.data);
        rightNodes.add(root);
    }

    //    public void remove(TreeNode data){
//        TreeNode leftNode = data.left;
//        TreeNode rightNOde = data.right;
//        TreeNode parentNOde = data.parent;
//        for (int i = 0; i < eligibleParents.size(); i++) {
//            TreeNode leaf = eligibleParents.get(i);
//            if (leaf.left == null && leaf.right == null){
//                leaf.right = rightNOde;
//                leaf.left = leftNode;
//                leaf.parent = parentNOde;
//                break;
//            }
//            size--;
//            data.left = null;
//            data.right = null;
//            data.parent = null;
//        }
//
//    }
}
