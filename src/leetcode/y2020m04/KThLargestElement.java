package leetcode.y2020m04;

import java.util.Arrays;

/**
 * @author xiana  2020-04-29 12:37
 */
public class KThLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int []res=Arrays.copyOf(nums,k);
        for (int i = 0; i < res.length-1; i++) {
            for (int j = 0; j <res.length-i-1 ; j++) {
                if (res[j]>res[j+1]){
                    int temp=res[j];
                    res[j]=res[j+1];
                    res[j+1]=temp;
                }
            }
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i]>res[0]){
                int j=1;
                while(j<res.length &&res[j]<nums[i]){
                    res[j - 1] = res[j++];
                }
                res[--j]=nums[i];
            }
        }
        return res[0];
    }

    public static void main(String[] args) {
        KThLargestElement test=new KThLargestElement();
//        System.out.println(test.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(test.findKthLargest(new int[]{7,6,5,4,3,2,1}, 5));
    }
}
