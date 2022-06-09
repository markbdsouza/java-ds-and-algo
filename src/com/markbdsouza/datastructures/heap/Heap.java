package com.markbdsouza.datastructures.heap;

// a Heap is similar to a binary tree in cocept.
// Difference is that during insert, lowest row it is filled from left to right IN ORDER ALWAYS
// There are 2 types of HEAPS. Min Heap and Max Heap.
//

// In Max Heap, the parent will be the max of all children.
// While inserting we start inserting in the next available position. But need to check if parent is > than new child
// If not we will keep swapping parent with child until parent > the new child
// when deleting, delete the node.. then replace the node with the last node. then keep swapping with parent
//as long as it is following max heap policy

// Heap can be implmented with linked list or array. In below section we use array
public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize; // number of nodes in array

    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean insert(int key) {
        // if array is full not possible
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        // create new node at the end of the list
        heapArray[currentSize] = newNode;
        // now need to check with parent until MAX heap is accurated
        trickleUp(currentSize);
        // increase overall size once swap is done
        currentSize++;
        return true;
    }

    private void trickleUp(int index) {
        int parentIndex = findParentIndex(index);
        Node nodeToInsert = heapArray[index];
    }

    // parent will always be (i-1)/2 mathematically
    private static int findParentIndex(int index) {
        return (index - 1) / 2;
    }
}
