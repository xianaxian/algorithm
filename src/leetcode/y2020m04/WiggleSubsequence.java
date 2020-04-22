package leetcode.y2020m04;

/**
 * @author xiana  2020-04-22 23:34
 */

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int subX=nums[1]-nums[0];
        if (nums.length==2){
            if (subX==0){
                return 1;
            }else {
                return 2;
            }
        }
        //以上是长度小于等于2的情况
        int num=1;
        int subY=nums[2]-nums[1];
        Boolean firstTag=true;
        for (int i = 3; i < nums.length; i++) {
            if (firstTag){
                if (subX!=0||subY!=0){
                    num++;
                    firstTag=false;
                }
            }
            if (subX * subY >=0){
                //是连续递增或者递减的，则换将元素放入内。
                subX=+subY;
                subY=nums[i]-nums[i-1];
            }else {
                //如果是摆动的，则num++
                num++;
                subX=subY;
                subY=nums[i]-nums[i-1];
            }
        }
        if (subX*subY<0){
            num++;
        }
        return num;
    }

    /**
     * 大致的思路就是算递增递减之后两个的斜率相乘小于0
     * 需要注意的事是对于第一个斜率不为0的两个数应该算一次摆动
     * 另外注意相乘为0的情况应该subX=+subY;
     */
    public static void main(String[] args) {
        WiggleSubsequence test=new WiggleSubsequence();
        System.out.println(test.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));//2
        System.out.println(test.wiggleMaxLength(new int[]{0,0}));//1
        System.out.println(test.wiggleMaxLength(new int[]{1,7,4,9,2,5}));//6
        System.out.println(test.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));//7
        System.out.println(test.wiggleMaxLength(new int[]{3,3,3,2,5}));//3
    }
}
