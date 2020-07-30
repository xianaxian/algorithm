package leetcode.y2020m07;

import test.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length==0 ){
            return 0;
        }
        int leftIndex=0;
        int rightIndex=nums.length-1;
        while ( leftIndex <= rightIndex  ){
            int mid = ( leftIndex + rightIndex ) / 2;
            if ( nums[leftIndex] > target ){
                return leftIndex;
            }else if ( nums[rightIndex] <= target ){
                return rightIndex + 1;
            }else {
                if ( nums[mid] >= target ){
                    rightIndex = mid;
                    leftIndex+=1;
                }else {
                    leftIndex = mid;
                    rightIndex-=1;
                }
            }
        }
        return rightIndex;
    }

    public static void main(String[] args) {
        SearchInsertPosition test =new SearchInsertPosition();
//        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(test.searchInsert(new int[]{1}, 2));
//        System.out.println(test.searchInsert(new int[]{1,3,5,6}, 0));
        List<Test> testList=new ArrayList<>();
        boolean test1 = testList.contains("test");
        System.out.println(test1);
    }

}
