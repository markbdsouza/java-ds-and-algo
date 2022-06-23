package com.markbdsouza.datastructures.hashtable;

public class HashTableApplication {
    public static void main(String[] args) {
        HashTable table = new HashTable(19);
        table.insert("Mango");
        table.insert("Yellow");
        table.insert("Orange");
        table.insert("Red");
        table.insert("Black");
        table.insert("White");
        table.insert("Apple");


        System.out.println(table.find("Apple"));
        System.out.println(table.find("Yellow"));
        System.out.println(table.find("Zebra"));

        table.displayTable();
    }
}
