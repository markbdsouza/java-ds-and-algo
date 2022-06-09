package com.markbdsouza.datastructures.BinarySearchTree;

public class BSTApplication {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30, "Thirty");
        bst.insert(20, "Twenty");
        bst.insert(15, "Fifteen");
        bst.insert(45, "FortyFive");
        bst.insert(60, "Sixty");
        bst.insert(70, "Seventy");
        bst.insert(90, "Ninety");
        bst.insert(18, "Eighteen");
        bst.insert(50, "Fifty");

        System.out.println(bst.findMin().key);
        System.out.println(bst.findMax().key);
        bst.displayTree();

    }
}
