package com.neetcode150.array;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] num = {1,2,4,6};
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();
        int[] result = self.productExceptSelf(num);
        for(int i : result){
            System.out.print(i+",");
        }
    }
    public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];
            answer[0] =1 ;
            for(int i =1; i<length; i++){
                answer[i] = answer[i-1] * nums[i-1];
            }

            int r  = 1;
            for(int i= length-1; i>=0; i--){
                answer[i] = answer[i] * r;
                r = r * nums[i];
            }
            return answer;
        }

}
