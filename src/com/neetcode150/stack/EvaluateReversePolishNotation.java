package com.neetcode150.stack;

import com.sun.jdi.request.StepRequest;

import java.util.Stack;

/**
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 * Return the integer that represents the evaluation of the expression.
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1: Input: tokens = ["1","2","+","3","*","4","-"], Output : 5
 *
 * */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        System.out.println(obj.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
