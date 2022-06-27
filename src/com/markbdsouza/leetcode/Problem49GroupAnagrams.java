package com.markbdsouza.leetcode;

import java.util.*;

/**
 * URL: https://leetcode.com/problems/group-anagrams/
 * Level: EASY
 * Tags: String, Stack
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class Problem49GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strsMap = new HashMap<>();
        for (String str : strs) {
            // convert to chars
            char[] chars = str.toCharArray();
            // sort. All anagrams when sorted like this will have same sequence
            Arrays.sort(chars);
            // Make sure to use String.valueOf and not .toString(). String.value of converts it back to string. toString() gets the address location
            String key = String.valueOf(chars);
            if (!strsMap.containsKey(key)) {
                strsMap.put(key, new ArrayList<>());
            }
            strsMap.get(key).add(str);
        }
        return new ArrayList<>(strsMap.values());
    }

    public static void main(String[] args) {
        String[] x = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(x);
    }

}
