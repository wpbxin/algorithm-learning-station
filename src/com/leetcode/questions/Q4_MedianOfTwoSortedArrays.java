package com.leetcode.questions;

/**
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * <p>
 * Examples 1: nums1 = [1, 3],nums2 = [2],The median is 2.0 .
 * <p>
 * Example 2: nums1 = [1, 2],nums2 = [3, 4],The median is (2 + 3)/2 = 2.5 .
 * <p>
 * 问题描述：给定长度分别为m和n的两个排序数组nums1和nums2，在时间复杂度O(log (m+n))内算出数组的中位数
 * <p>
 * 思路描述：分治算法
 * <p>
 * 参考1：https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/
 * Share-my-O(log(min(mn))-solution-with-explanation
 * <p>
 * 中文说明：【分步详解】两个有序数组的中位数和Top K问题，https://www.cnblogs.com/voidsky/p/5373982.html
 * <p>
 * 把中位数也当作是top k问题，最后进行奇偶判断
 * 
 * @author WPB
 *
 */
public class Q4_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		// make sure that m <= n
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		// n>=m,i = 0 ~ m,so j = (m + n + 1) / 2 -i > 0.
		int i = 0, j = 0, imax = m, imin = 0, halfLen = (m + n + 1) / 2;
		int maxLeft = 0, minRight = 0;
		while (imin <= imax) {
			i = (imin + imax) / 2;
			j = halfLen - i;
			if (i < m && nums2[j - 1] > nums1[i]) {
				imin = i + 1;
			} else if (i > 0 && nums1[i - 1] > nums2[j]) {
				imax = i - 1;
			} else {
				if (i == 0) {
					//the target is in nums2
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					//the target is in nums1
					maxLeft =  nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				break;
			}
		}
		//odd
		if ((m + n) % 2 == 1) {
			return (double)maxLeft;
		}
		//even
		if (i == m) {
			//nums1 is out of index m
			minRight = nums2[j];
		} else if (j == n) {
			//nums2 is out of index n
			minRight = nums1[i];
		} else {
			//others
			minRight = Math.min(nums1[i], nums2[j]);
		}
		return (double) (maxLeft + minRight) / 2;
	}

	public static void main(String[] args) {
		new Q4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });

	}
}
