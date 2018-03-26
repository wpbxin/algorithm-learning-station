package com.leetcode.questions;

/**
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples: Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 问题描述：给定一个字符串，找出最长不重复子串的长度
 * <p>
 * 思路描述：建立一个128的数组，存储字符的下标，min存储非重复子串的最小下标，max存储最大下标。
 * max逐步加大，如果下一个字符的下标大于min，则增加min，同时记录最大的max - min + 1
 * 
 * @author WPB
 *
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (null == s || s.length() < 1) {
			return 0;
		}
		// 初始化128的数组，足够存储所有字符
		int[] intArray = new int[128];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = -1;
		}
		char num = s.charAt(0);
		intArray[num] = 0;
		int min = 0;
		int max = 0;
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			num = s.charAt(i);
			max = i;
			if (intArray[num] == (max - 1)) {
				count = max - min > count ? max - min : count;
				min = max;
			} else if (intArray[num] >= min) {
				count = max - intArray[num] > count ? max - intArray[num] : count;
				min = intArray[num] + 1;
			} else {
				count = max - min + 1 > count ? max - min + 1 : count;
			}
			intArray[num] = i;
		}
		return count;
	}

	public static void main(String[] args) {
		Q3_LongestSubstringWithoutRepeatingCharacters longest = new Q3_LongestSubstringWithoutRepeatingCharacters();
		System.out.println(longest.lengthOfLongestSubstring("nfpdmpi"));
	}
}
