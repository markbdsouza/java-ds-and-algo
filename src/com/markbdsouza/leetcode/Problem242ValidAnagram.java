package com.markbdsouza.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * URL: https://leetcode.com/problems/valid-anagram/
 * Level: Easy
 * Tags: HashTable, String, Sorting
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class Problem242ValidAnagram {

    /* Best Solution
    * Create a size 26 int arrays as buckets for each letter in alphabet.
    * It increments the bucket value with String s and decrement with string t.
    * So if they are anagrams, all buckets should remain with initial value which is zero.
    * So just checking that and return
     */
    public static boolean betterSolutionIsAnagram(String s, String t){
        if(s.length()!=t.length()) return false;
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            // 'a' has a unicode value. To make it take index 0, we need to subtract 'a' from the value.
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if(i!=0) return false;
        }
        return true;
    }

    // Solution 1 uses Maps to solve this. This works fine but there is a better solution since it is only small letters
    public boolean isAnagram(String s, String t) {
        // cannot be anagram if lengths are different
        if (s.length() != t.length()) return false;
        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> secondMap = new HashMap<>();
        // since lengths are same, loop through and add to respective Map
        for (int i = 0; i < s.length(); i++) {
            addToMap(s.charAt(i), firstMap);
            addToMap(t.charAt(i), secondMap);
        }
        // should have same number of keys
        if (firstMap.keySet().size() != secondMap.keySet().size()) return false;
        else {
            for (String s1 : firstMap.keySet()) {
                // Check both have the key
                if (!firstMap.containsKey(s1) || !secondMap.containsKey(s1)) {
                    return false;
                } else if (!firstMap.get(s1).equals(secondMap.get(s1))) {
                    // return false if count is different between the two maps
                    return false;
                }
            }
        }
        return true;
    }
    private void addToMap(char alphabet, Map<String, Integer> map) {
        String x = ((Character) alphabet).toString();
        if (map.containsKey(x)) {
            map.put(x, map.get(x) + 1);
        } else map.put(x, 1);
    }

}
