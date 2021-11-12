public class BTtest {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(20);
        TreeNode f = new TreeNode(17);
        TreeNode g = new TreeNode(30);
        TreeNode h = new TreeNode(43);
        TreeNode i = new TreeNode(45);
        BT2 binaryTree = new BT2();
        binaryTree.add(a.data);
        binaryTree.add(b.data);
        binaryTree.add(c.data);
        binaryTree.add(d.data);
        binaryTree.add(e.data);
        binaryTree.add(f.data);
        binaryTree.add(g.data);
        binaryTree.add(h.data);
        binaryTree.add(i.data);

      //  binaryTree.remove(c);
//        binaryTree.insert(0,5);
//        binaryTree.insert(5,10);
//        binaryTree.insert(5,15);
//        binaryTree.insert(15,16);
//        binaryTree.insert(15,17);
//        binaryTree.insert(10,11);
//        binaryTree.insert(17,77);
    //    binaryTree.inOrder(binaryTree.root);
        System.out.println(binaryTree.height());

    }
}
