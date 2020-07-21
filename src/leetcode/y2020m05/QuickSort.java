package leetcode.y2020m05;

/**
 * @author whx  2020-05-21 22:29
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int tagLeft = left;
        int tagRight = right;
        int tagElement = arr[tagLeft];
        while (tagLeft < tagRight) {
            while (tagLeft < tagRight && arr[tagRight] >= tagElement) {
                tagRight--;
            }
            arr[tagLeft] = arr[tagRight];
            while (tagLeft < tagRight && arr[tagLeft] < tagElement) {
                tagLeft++;
            }
            arr[tagRight] = arr[tagLeft];
        }
        arr[tagLeft] = tagElement;
        //System.out.println(tagLeft + " " + tagRight);
        quickSort(arr, left, tagLeft);
        quickSort(arr, tagLeft + 1, right);
    }

    public static void main(String[] args) {
        int[] n = {1, 6, 3, 4, 2, 5, 2, 5, 7, 10};
        QuickSort test = new QuickSort();
        quickSort(n, 0, n.length - 1);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }
}
