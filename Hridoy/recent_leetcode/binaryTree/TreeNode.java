package com.binaryTree;

import com.sun.source.tree.Tree;

import static javax.swing.Spring.height;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode(){};
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
    public boolean isBalanced(TreeNode left){
        if (left == null){
            return true;
        }
        int lh = height(left.left);
        int rh = height(left.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(left.left) && isBalanced(left.right);
    }

    private int height(TreeNode left) {
       if (left == null){
           return 0;
       }
       return Math.max(height(left.left),height(left.right)+1);
    }


    public void printInOrder() {
       if (left != null){
           left.printInOrder();
       }
        System.out.print(data +" ");
       if (right!= null){
           right.printInOrder();
       }
    }

    public void printPreOrder(){
        if (left != null) {
            System.out.print(data);
            left.printPreOrder();
        }else {
            System.out.print(data);
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



