package leetcode.y2020m05;

/**
 * @author xiana  2020-05-13 21:37
 */
public class Test {
    public int maxScore(int[] cardPoints, int k) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < k; i++) {
            sumRight += cardPoints[cardPoints.length - i - 1];
        }
        int max = sumRight;
        for (int i = 0; i < k; i++) {
            //i为左边取多少个元素，即右边取k-i
            //(0为取1个，1为取两个)
            sumLeft += cardPoints[i];
            sumRight -= cardPoints[cardPoints.length - k + i ];
            max = Math.max(max, sumLeft + sumRight);
        }
        return max;
    }
}
