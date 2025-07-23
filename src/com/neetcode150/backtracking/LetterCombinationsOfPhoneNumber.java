package com.neetcode150.backtracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    private List<String> res = new ArrayList<>();

    public static void main(String[] args){
        String digits = "34";
        LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
        List<String> res = obj.letterCombinations(digits);
        for(String s : res){
            System.out.print(s+" | ");
        }
    }
    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }

}
