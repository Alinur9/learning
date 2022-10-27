package com.hridoy;

public class InsertionBST {
    TrNode root;

    private static TrNode insertNode(TrNode current, int value){

        if (current == null){
            current = new TrNode(value);
            return current;
        }
        if(value < current.value) {
            current.left = insertNode(current.left,value);
        }else if (value > current.value){
            current.right = insertNode(current.right,value);
        }else {
            return current;
        }
        return current;
    }
    public void insert(int value){
        root = insertNode(root,value);
    }

    private static boolean containsNodeRecursive(TrNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
    }
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public static void main(String[] args) {
        InsertionBST tree = new InsertionBST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(55);
        tree.insert(45);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(12);

        System.out.println(tree.containsNode(19));

    }
}
