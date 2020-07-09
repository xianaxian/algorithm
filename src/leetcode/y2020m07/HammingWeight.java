package leetcode.y2020m07;

/**
 * @author  whx
 * 题：191. 位1的个数
 * 描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {
    /**
     * mask 掩码，mask掩码与n与以后，为0则该位置为0，不为0则表示该位置是1
     * 每次不为0时,weight++，且mask左移一位
     */
    private static int HAMMING_LENGTH=35;
    public int hammingWeight(int n){
        int weight=0;
        int mask=1;
        for (int i = 0; i < HAMMING_LENGTH; i++) {
            if ((mask&n)!=0){
                weight++;
            }
            mask=mask<<1;
        }
        return weight;
    }

    /**
     * leetCode上的解法
     *  n 与 n - 1相与
     *  例如        n  = 0110 0010 1001 0000
     *  则       n-1   = 0110 0010 1000 1111
     *  相与以后的结果为    0110 0010 1000 0000
     *  每次n&(n-1)以后去除一个1
     */
    public int hammingWeight1(int n){
        int weight=0;
        while (n != 0){
            weight++;
            n=n&(n-1);
        }
        return weight;
    }
    public static void main(String[] args) {
        HammingWeight test=new HammingWeight();
        System.out.println(test.hammingWeight(3));
    }
}
