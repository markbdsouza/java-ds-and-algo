package com.markbdsouza.datastructures.heap;

public class Application {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(40);
        heap.insert(20);
        heap.insert(80);
        heap.insert(50);
        heap.display();
        heap.insert(100);
        heap.insert(30);
        heap.insert(90);

        heap.display();
    }
}
