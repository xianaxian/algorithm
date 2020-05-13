package leetcode.y2020m05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiana  2020-05-04 15:18
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >i; j--) {
                int sum=nums[i]+nums[j];
                int target= -sum;
                if (map.containsKey(target)){
                    Integer index = map.get(target);
                    if (index!=i&&index!=j){
                        List<Integer> res =new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[index]));
                        res.sort(Integer::compareTo);
                        if (!result.contains(res)) {
                            result.add(res);
                        }

                    }

                }
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum test=new ThreeSum();
        List<List<Integer>> lists = test.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
