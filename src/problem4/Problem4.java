package problem4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by shawee on 2018/7/29
 */
public class Problem4 {
    public static void main(String[] args) {
        int m ,n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
//寻找中位数的问题可以化为寻找第k小的数
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 != 0){
            return findKth(nums1, nums2, (length + 1) / 2);
        }else{
            return (findKth(nums1, nums2, (length + 1 ) / 2) + findKth(nums1, nums2, (length + 2) / 2)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        //令nums1长度小于nums2长度
        if (m > n) return findKth(nums2, nums1, k);
        //如果nums1长度为0,直接返回nums2中第k小的数
        if (m == 0) return nums2[k - 1];
        //如果k等于1,直接返回nums1[0]和nums2[0]中较小的一个
        if (k == 1) return Math.min(nums1[0], nums2[0]);

        int i = Math.min(m, k / 2);
        int j = Math.min(n, k - i);
        //如果nums1[i - 1] < nums2[j - 1]说明nums1中前i个数都小于两数组合并后的第k小的数,可以除去,继续找两数组合并后的第k-i小的数
        if (nums1[i - 1] < nums2[j - 1]) return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        //如果nums1[i - 1] > nums2[j - 1]说明nums2中前j个数都小于两数组合并后的第k小的数,可以除去,继续找两数组合并后的第k-j小的数
        if (nums1[i - 1] > nums2[j - 1]) return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k -j);
        //相等的话这个数就是两数组合并后的第k小的数
        return nums1[i - 1];
    }
}
