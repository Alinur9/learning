package com.binaryTree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(int value) {
        if (value <= data && left == null){
            left = new TreeNode(value);
        } else if (value <= data) {
            left.insert(value);
        } else if (right == null) {
            right = new TreeNode(value);

        } else {
            right.insert(value);
        }

    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        }
        if (value < data && left == null) {
            return false;
        } else if (value < data) {
            return left.contains(value);
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }
    public void printInOrder() {
       if (left != null){
           left.printInOrder();
       }
        System.out.println(data);
       if (right!= null){
           right.printInOrder();
       }
    }

    public void printPreOrder(){
        if (left != null) {
            System.out.println(data);
            left.printPreOrder();
        }else {
            System.out.println(data);
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder(){
        if ( left != null ){
            left.printPostOrder();
        }
        if (right != null){
            right.printPostOrder();
        }
        System.out.println(data);
    }
    }


