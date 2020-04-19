package leetcode.y2020m04;

public class RemoveElement {
    /**
     *27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int removeElement(int []nums,int val){
        int num=nums.length;
        int index=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[index]==val){
                nums[index] = nums[num-1];
                nums[num-1] = val;
                num--;
            }else{
                index++;
            }
        }
        return num;
    }
    /**
     * 解题思路：把每一个和val相等的元素和目前确定数组的长度的最后一个元素互换，
     * 此处需要注意的是互换以后不用index++，因为互换以后并没有确定互换后的元素不等于valm
     */

}
