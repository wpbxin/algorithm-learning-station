package com.leetcode.questions;

import java.util.Hashtable;
import java.util.Map;

/**
 * <p>
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.You may assume that each input would have exactly
 * one solution, and you may not use the same element twice.
 * <p>
 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 * 2 + 7 = 9, return [0, 1].
 * <p>
 * 问题描述：给定一个整数数组，返回数组中和为数字target的两个元素的下标。 可以假定每个输入target都有一组特定的输出，并且同个元素只使用一次。
 * <p>
 * 思路描述：数组是无序的，比较便捷的方法就是按照k-v(元素-下标)形式将数据元素进行判断和存储，判断差是否在k中有存储，
 *        若有，说明存在，否则把元素进行存储。因为只需要扫描一遍，时间复杂度O(n)，空间复杂度O(n)。
 * @author WPB
 *
 */
public class Q1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (null == nums || nums.length < 2)
			return null;
		//保留結果
		int[] result = new int[2];
		Map<Integer, Integer> resultMap = new Hashtable<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			//求差
			int differ = target - nums[i];
			//存在k，说明符合条件
			if (resultMap.containsKey(differ)) {
				int tmpResult = resultMap.get(differ);
				if (tmpResult > i) {
					//输出正确的数组下标
					result[0] = i;
					result[1] = tmpResult;
				} else {
					result[0] = tmpResult;
					result[1] = i;
				}
				return result;
			} else {
				//k-v存储
				resultMap.put(nums[i], i);
			}
		}
		return null;
	}
}
