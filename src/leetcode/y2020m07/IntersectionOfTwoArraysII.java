package leetcode.y2020m07;

import java.util.*;


public class IntersectionOfTwoArraysII {
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            intersect1(nums2,nums1);
        }
        HashMap<Integer,Integer> numberTimeMap=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer time = numberTimeMap.getOrDefault(nums1[i], 0);
            numberTimeMap.put(nums1[i],time+1);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (numberTimeMap.containsKey(nums2[i])){
                int num = nums2[i];
                list.add(num);
                Integer times = numberTimeMap.get(num);
                if (times-1>0) {
                    numberTimeMap.put(num, times - 1);
                }else {
                    numberTimeMap.remove(num);
                }
            }
        }
        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public int [] intersect(int [] nums1, int [] nums2){
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums1) {
            int count=map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int [] intersection =new int [nums1.length];
        int index=0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0){
                intersection[index++] = num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
public static void main(String[] args) {
    UUID x = UUID.randomUUID();
    System.out.println(x.toString().length());
    System.out.println(x);
}
}
