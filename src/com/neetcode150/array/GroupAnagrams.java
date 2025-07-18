package com.neetcode150.array;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"], Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2: Input: strs = [""] Output: [[""]]
 * Example 3: Input: strs = ["a"] Output: [["a"]]
 *
 * */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> mapping = new HashMap<>();
        int[] arr = new int[26];
        for(String str: strs){
            Arrays.fill(arr,0);
            for(char ch: str.trim().toLowerCase().toCharArray())
                arr[ch-'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i =0; i<26; i++){
                sb.append("#");
                sb.append(arr[i]);
            }
            String key = sb.toString();
            if(!mapping.containsKey(key)) mapping.put(key, new ArrayList<>());
            mapping.get(key).add(str);
        }
        return new ArrayList(mapping.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        String[] str1 = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        GroupAnagrams g = new GroupAnagrams();
//        System.out.println(g.groupAnagrams(strs));
        System.out.println(g.groupAnagrams(str1));
    }
}
