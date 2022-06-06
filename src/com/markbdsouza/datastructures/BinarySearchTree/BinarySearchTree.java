package com.markbdsouza.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            // empty tree so newNode is
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            // keep navigating downwards until you find the right node
            while (true) {
                parent = current;
                // if new value is lower compared to current navigate to the left side
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) { // reached a leaf node
                        parent.leftChild = newNode;
                        return;
                    }
                }
                // otherwise navigate to right side.
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int key) {
        // use 2 pointers
        Node currentNode = root;
        Node parentNode = root;

        boolean isLeftChild = false;

        // Search for node to delete
        while (currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null)
                return false;
        }
        // currentNode is now the node with the key sent to delete
        Node nodeToDelete = currentNode;
        // if Node to be deleted has no child, then we only need to get the parent and make sure the parent.leftChild/rightChild is now pointing to null
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        }
        // if Node has single child, we need to move the subtree of the deleted node to the node position.
        else if (nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToDelete.leftChild;
            } else {
                parentNode.rightChild = nodeToDelete.leftChild;
            }
        }
        // if Node has single child, we need to move the subtree of the deleted node to the node position.
        else if (nodeToDelete.leftChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToDelete.rightChild;
            } else {
                parentNode.rightChild = nodeToDelete.rightChild;
            }
        }
        // If Node has 2 children. We need to find a node to safely replace the deleted node. Need to find smallest of set of nodes larger than deleted node.
        // (Next largest node).. IMPORTANT:  All nodes larger are on the right. So go right once and find min(left path till null) to get the node to replace deleted node.
        else {
            Node successor = findNodeToDelete(nodeToDelete);

            if (nodeToDelete == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.leftChild = successor;
            } else {
                parentNode.rightChild = successor;
            }
            // successor's left is set to deleted nodes left
            // SWAP PART 2
            successor.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node findNodeToDelete(Node nodeToDelete) {
        Node successorParent = nodeToDelete;
        // first go right
        Node successor = nodeToDelete.rightChild;
        // and find the min of the right subtree - no more left child.
        while (successor.leftChild != null) {
            successorParent = successor;
            successor = successor.leftChild;
        }
        // if successor is not a right child,
        if (successor != nodeToDelete.rightChild) {
            // successor cant have left, but it can have right. If it does, it becomes left child of successor parent
            successorParent.leftChild = successor.rightChild;
            // need to assign the successors right to the deleted nodes right
            // SWAP PART 1
            successor.rightChild = nodeToDelete.rightChild;
        }

        return successor;
    }


    public Node findMin() {

        Node current = root;
        Node last = null;
        // keep navigating to the left until no node on the left. This will be the minimum
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;
        // keep navigating to the right until no node. This will be the maximum
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public void displayTree() {
        int layer = 0;
        if (root == null) return;
        System.out.println(layer + " " + this.root.key);
        List<Node> prevList, currentList = new ArrayList<>();
        while (currentList.size() > 0) {
            layer++;
            prevList = currentList;
            currentList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(layer).append(" ");
            for (Node prevNode : prevList) {
//               TODO

            }
        }

    }
}
