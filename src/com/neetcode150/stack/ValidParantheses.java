package com.neetcode150.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 * The input string s is valid if and only if:
 * 1) Every open bracket is closed by the same type of close bracket.
 * 2) Open brackets are closed in the correct order.
 * 3) Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Example 1: Input: s = "[]", Output: True
 * Example 2: Input: s = "([{}])", Output: True
 * Example 3: Input: s = "[(])", Output: False
 * */
public class ValidParantheses {
    public static void main(String[] args) {
        String s1 = "[]", s2 = "([{}])", s3 = "[(])";
        ValidParantheses v = new ValidParantheses();
        System.out.println(v.isValid(s1));
        System.out.println(v.isValid(s2));
        System.out.println(v.isValid(s3));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(Character c : s.toCharArray()) {
            if(map.containsKey(c)) {
                if(!stack.isEmpty() && stack.peek() == map.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

}
