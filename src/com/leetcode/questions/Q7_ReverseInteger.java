package com.leetcode.questions;

/**
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * <p>
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * <p>
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * <p>
 * Output: 21
 * <p>
 * Note: Assume we are dealing with an environment which could only hold
 * integers within the 32-bit signed integer range. For the purpose of this
 * problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * <p>
 * ������������ת32λ������
 * <p>
 * ˼·��������һ�ε�ģ*10 + ��һ�ε�ģ���м��ж��Ƿ������
 * <p>
 * last_mod * 10 + this_mod
 * <p>
 * x /= 10
 * 
 * @author WPB
 *
 */
public class Q7_ReverseInteger {
	public int reverse(int x) {
		int revResult = 0;
		while (0 != x){
			int newResult = revResult * 10 + x % 10;
			//judge whether it overflows
			if (newResult / 10 != revResult) {
				return 0;
			}
			revResult = newResult;
			x /= 10;
		}
		return revResult;
	}
}
