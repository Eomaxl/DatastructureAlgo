package com.company.salesforce;

/**
 * You are given a positive integer n, you can do the following operation any number of times:
 * Add or subtract a power of 2 from n. Return the minimum number of operations to make n equal to 0
 * A number x is power of 2 if x == 2i where i >= 0.
 * */

public class MinimumOperationsToReduceAnIntegerTo0 {
    public int minimumOperations(int n) {
        int res = 0;
        while( n > 0 ){
            if ((n & 3) == 3){
                n++;
                res++;
            } else {
                res += n & 1;
                n >>= 1;
            }
        }
        return res;
    }
}
