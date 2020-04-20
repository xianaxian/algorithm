package leetcode.y2020m04;

/**
 * @author whx
 * @dare 2020/4/19 11:25
 */

/**
 * 5373. 和为 K 的最少斐波那契数字数目
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 斐波那契数字定义为：
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FinMinFibonacciNumbers {
    public int findMinFibonacciNumbers(int k) {
        int index=1;
        int []fib=new int[50];
        fib[0]=1;
        fib[1]=1;
        while (fib[index++]<k){
            fib[index]=fib[index-2]+fib[index-1];
        }
        int num=0;
        while (k>0){
            index--;
            if (k>=fib[index]){
                k=k-fib[index];
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        FinMinFibonacciNumbers test=new FinMinFibonacciNumbers();
        test.findMinFibonacciNumbers(7);
        int []fib=new int[50];
        fib[0]=1;
        fib[1]=1;
        for (int i = 2; i < fib.length; i++) {
            fib[i]=fib[i-1]+fib[i-2];
            System.out.println("第"+i+"个斐波那契数是"+fib[i]);
        }


    }
    /**
     * 思路：
     * 首先题目中说每个斐波那契数字都可以被使用多次
     * f(n)+f(n)=f(n+1)-f(n-1) + f(n-1)+f(n-2)= f(n+1) +f(n-2)
     * =f(n+2)-n(n) + f(n)-f(n-1)=f(n+2)+f(n-1)
     * =f(n+3)-f(n+1) + f(n+1)-f(n)=f(n+3)+f(n)
     * ....如果数学证明学的好的可以证明2f(n)=f(n+x)+f（n+x-3)todo 具体没有证明有空证明一下
     * 所以无论数字被使用几次都可以转化为另外不相邻的数字相加
     * 所以一个数字可以使用一次，另外
     * 所以使用贪心算法，
     * 先算得数组中最大的大于这个数字最大的下标。
     * 之后从下标出往回推算，每次背包内放入最大的元素。
     */
}
