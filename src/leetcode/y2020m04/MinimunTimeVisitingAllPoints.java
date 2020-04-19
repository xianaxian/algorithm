package leetcode.y2020m04;

public class MinimunTimeVisitingAllPoints {
    /**
     *1266. 访问所有点的最小时间
     * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
     *
     * 你可以按照下面的规则在平面上移动：
     *
     * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
     * 必须按照数组中出现的顺序来访问这些点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        if (points.length==0){
            return time;
        }
        for (int i = 1; i <points.length ; i++) {
            //使用方法；
            //time+=getMinTimeWithTwoPoints(points[i-1],points[i]);
            int x=points[i-1][0]-points[i][0];
            int y=points[i-1][1]-points[i][1];
            x=x<0?-x:x;
            y=y<0?-y:y;
            time+=Math.max(x,y);
        }
        return time;
    }
    public int getMinTimeWithTwoPoints(int []pointA,int []pointB){
        int x=pointA[0]-pointB[0];
        int y=pointA[1]-pointB[1];
        x=x<0?-x:x;
        y=y<0?-y:y;
        if (y==x){
            return x;
        }else if (x>y){
            return x;
        }else {
            return y;
        }
    }
    /**
     * 解题思路：按照顺序遍历，本题的难度在于得到两点之间的距离，
     * 但无论是怎么移动，移动距离其实是水平距离和竖直距离的两者中的最大值。
     */
}
