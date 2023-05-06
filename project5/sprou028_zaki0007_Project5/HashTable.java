// Written by sprou028@umn.edu & zaki0007@umn.edu

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable<T>{
    NGen<T>[] hashTable;

    //TODO: Create a constructor that takes in a length and initializes the hash table array
    public HashTable(int size){
        hashTable = new NGen[size];
    }

    //TODO: Implement a simple hash function
    public int hash1(T item) {
        int length = hashTable.length;
        int hash = item.toString().charAt(0) + item.toString().charAt(item.toString().length() - 1) % length;
        return hash;
    }

    //TODO: Implement a second (different and improved) hash function
    public int hash2(T item) {
        int hash = (((item.toString().charAt(0) * 11) + (item.toString().charAt(item.toString().length() / 2) * 7)
                + item.toString().charAt(item.toString().length() - 1)) % hashTable.length);
        // I found that by multiplying the character by a prime number than % by the length distributes the hashes well

        //System.out.println(hash);
        return hash;
    }

    //TODO: Implement the add method which adds an item to the hash table using your best performing hash function
    // Does NOT add duplicate items
    public void add(T item) {
        int index = hash2(item);
        if (item != null){
            if (hashTable[index] == null) {
                hashTable[index] = new NGen<>(null, null);
            }
            NGen<T> ptr = hashTable[index];
            T data = null;
            boolean inList = false;
            while (ptr.getNext() != null){
                ptr = ptr.getNext();
                data = ptr.getData();
                if (data.equals(item)){
                    inList = true;
                    break;
                }
            }
            if (!inList){
                NGen<T> newNode = new NGen<T>(item, null);
                ptr.setNext(newNode);
            }
        }
    }

    // ** Already implemented -- no need to change **
    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    //TODO: Implement the display method which prints the indices of the hash table and the number of words "hashed"
    // to each index. Also prints:
    // - total number of unique words
    // - number of empty indices
    // - number of nonempty indices
    // - average collision length
    // - length of longest chain
    public void display() {
        int totalNonEmpty = 0;
        int empty = 0;
        int nonEmpty = 0;
        int totalTokens = 0;
        int longest = 0;
        int currentLongest;
        int nodeCount;
        double collisions;
        NGen ls;
        for(int i = 0; i < hashTable.length; i++){
            ls = hashTable[i];
            currentLongest = 0;
            if(ls != null){
                totalNonEmpty++;
                nodeCount = 0;
                while(ls.getNext() != null){
                    nodeCount++;
                    if(++currentLongest > longest)
                        longest = currentLongest;
                    ls = ls.getNext();
                    totalTokens++;
                }
                System.out.println(i+": " + nodeCount);
            }else{
                System.out.println(i+": 0");
            }
            //System.out.println();
        }
        for (int j = 0; j < hashTable.length; j++){
            if (hashTable[j] == null){
                empty++;
            } else {
                nonEmpty++;
            }
        }
        collisions = (double) totalTokens/ (double) totalNonEmpty;

        System.out.println("Total Unique Words: " + totalTokens);
        System.out.println("Empty Indices: " + empty);
        System.out.println("Non Empty Indices: " + nonEmpty);
        System.out.println("Average Collisions: " + collisions);
        System.out.println("Longest Collisions: " + longest);

    }

    // TODO: Create a hash table, store all words from "canterbury.txt", and display the table
    //  Create another hash table, store all words from "keywords.txt", and display the table
    public static void main(String args[]) {

        HashTable get = new HashTable(105);
        get.addWordsFromFile("gettysburg.txt");
        get.display();


        HashTable kw = new HashTable(100);
        kw.addWordsFromFile("keywords.txt");
        kw.display();
    }
}
