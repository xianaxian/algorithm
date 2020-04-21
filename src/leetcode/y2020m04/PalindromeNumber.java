package leetcode.y2020m04;

/**
 * @author xiana  2020-04-22 00:36
 */
public class PalindromeNumber {
    /**
     *9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public boolean isPalindrome(int x){
        int source=x;
        int target=0;
        while (x!=0) {
            int num=x%10;
            x = (x - num)/10;
            target = target * 10 + num;
        }
        return source==target;
    }

    public static void main(String[] args) {
        PalindromeNumber test=new PalindromeNumber();
        System.out.println(test.isPalindrome(121));
    }
    /**
     * 解题思路：小于0的数字均不属于回文数，所以小于0的数则直接返回false;
     * 对于正整数(包括0)直接求得倒叙的数字，即每次对对源数字求余后，源数字除以10，
     * 目标数字等于目标数字乘10+余数
     * 求得之后对正序数字和倒叙数字判断时候相等。
     */
}
