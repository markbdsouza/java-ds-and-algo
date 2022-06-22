package com.markbdsouza.datastructures.heap;

// a Heap is similar to a binary tree in concept.
// Difference is that during insert, lowest row it is filled from left to right IN ORDER ALWAYS
// There are 2 types of HEAPS. Min Heap and Max Heap.

// In Max Heap, the parent will be the max of all children.
// While inserting we start inserting in the next available position. But need to check if parent is > than new child
// If not we will keep swapping parent with child until parent > the new child
// when deleting, delete the node.. then replace the node with the last node. then keep swapping with parent
//as long as it is following max heap policy

// Heap can be implemented with linked list or array. In below section we use array to mplement MAX HEAP
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

        // loop as long as we havent reached the root and key of nodeToInsert's parent is less than the nodeToInsert
        while (index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {
            heapArray[index] = heapArray[parentIndex]; // move parent down
            index = parentIndex;
            parentIndex = findParentIndex(parentIndex); // get new parent after shifting
        }
        heapArray[index] = nodeToInsert;
    }


    // parent will always be (i-1)/2 mathematically
    private static int findParentIndex(int index) {
        return (index - 1) / 2;
    }


    // we delete only from top. That is the MAX record. So no parameter
    public Node remove() {
        Node root = heapArray[0];
        // Get the last element and put it on top of the tree
        currentSize--;
        Node lastElement = heapArray[currentSize];
        heapArray[0] = lastElement;
        // Now a small element is on top. We need to swap it as it is no longer MAX of children
        // Each time, we check between the 2 children, which child is larger and swap.
        // We keep going down until we find it is following the MAX Heap logic
        trickleDown(0);

        // return deleted Node
        return root;
    }

    private void trickleDown(int index) {
        int largerChildIndex;
        Node topNode = heapArray[index]; // the first time this is the last Node that is now at the top of the heap

        // will run as long as index is not on the bottom row( at least 1 child)
        while (index < currentSize / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;

            // figure out which child is larger between the 2
            if (rightChildIndex < currentSize && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) // first check is to make sure we are not at the end of the heap
            {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }

            if (topNode.getKey() >= heapArray[largerChildIndex].getKey()) {
                // the node at thee end should finally be > the largest child. If so break
                break;
            }
            // swap the index
            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;
        }
        // finally set the new index with the value of the topNoed which we had set at the beginning of this method
        heapArray[index] = topNode;
    }
    public void display() {
        System.out.println("Printing the Heap as an Array");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println("\n------------------------------------------------------------------------");

        System.out.println("Printing the Heap as a Tree ");

        // nBlanks will be the number of blanks before and in between.
        // First row.. 32 blanks-number-32 blanks.. Second row- 16 blank-no-16 blank-16 blank-no-16 blank
        // Each row we iterate through we will halve it. Start with 32. Then 16, 8, 4.. etc.
        int nBlanks = 32;
        int totalCurrentCount = 0;
        int currentRow = 0;
        // while loop. One iteration of this loop = one row being printed
        while (totalCurrentCount < currentSize) {
            // space before first element
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }
            // Mathematically each row in the tree is from (2^currentRow)-1 TO (2^(currentRow+1))-1
            // first row is 0->1. Second row 1->3. Third Row 3->7. etc. Using this logic for the loop
            int currentIndex = (int) (Math.pow(2, currentRow) - 1);
            // loop through current row elements and make sure we arent run out of all elements as well
            while (currentIndex < (int) (Math.pow(2, currentRow + 1) - 1)
                    && totalCurrentCount < currentSize) {
                // Print the current element
                System.out.print(heapArray[currentIndex].getKey());
                // print space between 2 elements
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    // print nblanks*2 since there is empty space on right side of one value and left of next value.
                    System.out.print(" ");
                }
                totalCurrentCount++;
                currentIndex++;
            }
            // printing one row is over. Increment row counter
            currentRow++;
            // next row should have half the blanks between numbers
            nBlanks = nBlanks / 2;
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
