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
 * ��������������һ���������飬���������к�Ϊ����target������Ԫ�ص��±ꡣ ���Լٶ�ÿ������target����һ���ض������������ͬ��Ԫ��ֻʹ��һ�Ρ�
 * <p>
 * ˼·����������������ģ��Ƚϱ�ݵķ������ǰ���k-v(Ԫ��-�±�)��ʽ������Ԫ�ؽ����жϺʹ洢���жϲ��Ƿ���k���д洢��
 *        ���У�˵�����ڣ������Ԫ�ؽ��д洢����Ϊֻ��Ҫɨ��һ�飬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)��
 * @author WPB
 *
 */
public class Q1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (null == nums || nums.length < 2)
			return null;
		//�����Y��
		int[] result = new int[2];
		Map<Integer, Integer> resultMap = new Hashtable<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			//���
			int differ = target - nums[i];
			//����k��˵����������
			if (resultMap.containsKey(differ)) {
				int tmpResult = resultMap.get(differ);
				if (tmpResult > i) {
					//�����ȷ�������±�
					result[0] = i;
					result[1] = tmpResult;
				} else {
					result[0] = tmpResult;
					result[1] = i;
				}
				return result;
			} else {
				//k-v�洢
				resultMap.put(nums[i], i);
			}
		}
		return null;
	}
}
