package com.neetcode150.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 * Input n = 1, Output = ["()"]
 * Input n = 3, Output = ["((()))","(()())","(())()","()(())","()()()"]
 * */
public class GenerateParantheses {
    public static void main(String[] args) {
        int n1 = 1, n2 = 3;
        GenerateParantheses g = new GenerateParantheses();
        List<String> parantheses1 = g.generateParenthesis(n1);
        List<String> parantheses2 = g.generateParenthesis(n2);
        for(String s : parantheses1){
            System.out.print(s+" | ");
        }
        System.out.println();
        for(String s : parantheses2){
            System.out.print(s+" | ");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        for(int i =0; i<=n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for(int k =0 ; k<= n ; k++){
            for (int i = 0; i< k; i++) {
                for(String left : res.get(i)) {
                    for(String right : res.get(k - i - 1)) {
                        res.get(k).add( "("+left+")" + right );
                    }
                }
            }
        }
        return res.get(n);
    }
}
