package leetcode.y2020m05;

/**
 * @author xiana  2020-05-21 23:00
 */
public class MergeSort {
    public static void mergeSort(int[] num, int left, int right){
        if (left<right) {
            int mid = (left + right) / 2;
            System.out.println("mid "+mid);
            mergeSort(num, left, mid);
            mergeSort(num, mid + 1, right);
            merge(num, left, right, mid);
        }
    }

    public static void merge(int []num,int left,int right,int mid){
        if (left==mid){
            return;
        }
        int leftIndex=left;
        int rightIndex=mid+1;
        int[] newNum =new int[num.length];
        int index=left;
        while (leftIndex<=mid&&left<=right){
            if (num[leftIndex]<num[rightIndex]){
                newNum[index++]=num[leftIndex++];
            }else {
                newNum[index++]=num[rightIndex++];
            }
        }
            while (leftIndex <= mid) {
                newNum[index++] = num[leftIndex++];
            }


            while (rightIndex <= right) {
                newNum[index++] = num[rightIndex++];

            }

        System.out.println("from "+left+" to "+ right);
        for (int i = left; i <=right; i++) {
            num[i]=newNum[i];
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] n = {1, 6, 3, 4, 2, 5, 2, 5, 7, 10};
        mergeSort(n, 0, n.length - 1);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }
}
