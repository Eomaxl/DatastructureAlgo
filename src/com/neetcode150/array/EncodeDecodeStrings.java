package com.neetcode150.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings
 * Please implement encode and decode
 * Example 1: Input: ["neet","code","love","you"] Output:["neet","code","love","you"]
 * */
public class EncodeDecodeStrings {
    public static void main(String[] args) {
        String[] input = {"neet","code","love","you"};
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encodeString = encodeDecodeStrings.encode(List.of(input));
        System.out.println("Encoded String: " + encodeString);
        List<String> decodeString = encodeDecodeStrings.decode(encodeString);
        for (String str : decodeString) {
            System.out.print(str+",");
        }
    }

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return Character.toString((char)258);
        }

        String separate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.equals(Character.toString((char)258))) return new ArrayList<>();

        String separate = Character.toString((char)257);
        return Arrays.asList(str.split(separate,-1));

    }
}
