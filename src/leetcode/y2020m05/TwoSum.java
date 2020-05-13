package leetcode.y2020m05;

import java.util.HashMap;

/**
 * @author xiana  2020-05-04 14:45
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsIndexMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetNums=target-nums[i];
            if (numsIndexMap.containsKey(targetNums)){
                return new int[]{i,numsIndexMap.get(targetNums)};
            }else {
                numsIndexMap.put(nums[i],i);
            }
        }
        throw  new RuntimeException("没有两个数相加等于target");
    }
}
