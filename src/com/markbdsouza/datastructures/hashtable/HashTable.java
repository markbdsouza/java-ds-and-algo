package com.markbdsouza.datastructures.hashtable;

// Fetching is O(1)
// Internally uses the array. We will create a hashfunction(object) for HASHING, which will return the index position.

// 2 concepts. 1 os we meed a hashing function that we pass in the object and returns the index
// 2nd method is a method that returns the step size. If the index returned from hashed location is already occupied,
// we will use the stepsize to check index+stepsize.. if that is also full go to +stepsize again, until we find an empty slot

// The size of the array MUST BE a prime number. Else there is a chance of going in a complete loop when searching fori ndex with step size
public class HashTable {

    String[] hashArray;
    int arraySize;
    int size = 0; //counter for number of elements in the hash table

    public HashTable(int noOfSlots) {
        if (isPrime(noOfSlots)) {
            hashArray = new String[noOfSlots];
            // noOfSlots must be a PRIME Number
            arraySize = noOfSlots;
        } else {
            arraySize = getNextPrime(noOfSlots);
            hashArray = new String[arraySize];
            System.out.println("Hash Table is inadequate as it is not PRIME. No of slots=" + arraySize);
        }
    }

    private boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private int getNextPrime(int number) {
        for (int i = number; ; i++) {
            if (isPrime(i)) return i;
        }
    }

    private int hashMethod(String word) {
        int hashVal = word.hashCode();
        // hashVal could be larger than the array size. So take the remainder operator to get < array size
        hashVal = hashVal % arraySize;
        // hashVal could be negative. In that case make it positive
        if (hashVal < 0) {
            hashVal = hashVal * -1;
        }
        return hashVal;
    }


    // return step size >0
    private int hashMethodForStepSize(String word) {
        int hashVal = word.hashCode();
        // hashVal could be larger than the array size. So take the remainder operator to get < array size
        hashVal = hashVal % arraySize;
        // hashVal could be negative. In that case make it positive
        if (hashVal < 0) {
            hashVal = hashVal * -1;
        }
        // we need to use a different logic compared to the original hashMethod()
        // choose a prime number smaller than the array size
        return 3 - (hashVal % 3);
    }

    public void insert(String word) {
        int hashVal = hashMethod(word);
        int stepSize = hashMethodForStepSize(word);

        // loop through positions of hashVal + stepSize until you get an empty slot
        while (hashArray[hashVal] != null) {
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        hashArray[hashVal] = word;
        System.out.println("Inserted word "+word+ " at index " + hashVal);
        size++;
    }

    public String find(String word){
        int hashVal = hashMethod(word);
        int stepSize = hashMethodForStepSize(word);

        // loop through positions of hashVal + stepSize until you get an empty slot
        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].equals(word)){
                return hashArray[hashVal];
            }
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
        System.out.println("word "+ word +" not found");
        return hashArray[hashVal];
    }

    public void displayTable(){
        System.out.println("---- Printing Table ----");
        for(int i=0; i< arraySize; i++){
            System.out.println( "Index:" + i + " Value:" + hashArray[i]);
        }
    }
}
