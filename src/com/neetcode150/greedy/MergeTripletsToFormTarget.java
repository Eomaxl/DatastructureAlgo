package com.neetcode150.greedy;

import java.util.*;

public class MergeTripletsToFormTarget {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    set.add(i);
                }
            }
        }
        return set.size() == 3;
    }
}
