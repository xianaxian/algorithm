package leetcode.y2020m07;

/**
 * @author whx
 */


public class MinInteger {
    /**
     * 题：1505. 最多 K 次交换相邻数位后得到的最小整数
     *
     * 描述：给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
     *
     * 你可以交换这个整数相邻数位的数字 最多 k 次。
     *
     * 请你返回你能得到的最小整数，并以字符串形式返回。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String minInteger(String num, int k) {
        //TO-DO  写错了。。。。
        char[] nums = num.toCharArray();
        int index=0;
        while (k != 0){
            int endOfIndex = Math.min(k, nums.length);
            int indexOfMin = getIndexOfMin(index, endOfIndex, nums);
            //还剩下多少可移动次数
            k=k-indexOfMin;
            char minChar = nums[indexOfMin];
            for (int i = indexOfMin; i >index ; i--) {
                char temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] =temp;
            }
            nums[index]=minChar;
            index++;
        }
        return nums.toString();
    }
    private int getIndexOfMin(int start, int end, char [] nums){
        int indexOfMin=start;
        for (int i = start+1; i <= end; i++) {
            if (nums[indexOfMin]>=nums[i]){
                indexOfMin=i;
            }
        }
        return indexOfMin;
    }

    public static void main(String[] args) {
        MinInteger test=new MinInteger();
        System.out.println(test.minInteger("100", 1).toString());
    }
}
