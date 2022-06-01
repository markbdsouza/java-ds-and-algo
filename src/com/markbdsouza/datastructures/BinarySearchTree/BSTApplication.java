package com.markbdsouza.datastructures.BinarySearchTree;

public class BSTApplication {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "Ten");
        bst.insert(20, "Twenty");
        bst.insert(15, "Fifteen");

        System.out.println(bst.findMin().key);
        System.out.println(bst.findMax().key);
    }
}
