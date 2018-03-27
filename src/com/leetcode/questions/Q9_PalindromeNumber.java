package com.leetcode.questions;

/**
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <br>
 * Some hints:<br>
 * Could negative integers be palindromes? (ie, -1)<br>
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space. You could also try reversing an integer. However, if
 * you have solved the problem "Reverse Integer", you know that the reversed
 * integer might overflow. How would you handle such case?<br>
 * There is a more generic way of solving this problem.
 * <p>
 * 问题描述：判断一个数是否是回文数
 * <p>
 * 思路描述： <br>
 * 最直接简单的方法时直接反转数字进行判断，但是要考虑溢出的问题，而且需要处理整数的所有位数。根据回文数(都属于自然数)的定义，回文数是对称的，
 * 只需反转一半的数字即可。<br>
 * 注意问题：<br>
 * 1、特殊值问题：大于0的数字，且个位数是0，明显不是。小于0的负数，明显不是<br>
 * 2、数字是奇数位：反转的数字/10=前半部分<br>
 * 3、数字是偶数位：反转的数字=前半部分<br>
 * 4、因此关键的判断条件就是：反转的数字 < 前半部分
 * <p>
 * <br>回文数-维基百科：https://en.wikipedia.org/wiki/Palindromic_number
 * <br>回文数-百度百科：https://baike.baidu.com/item/%E5%9B%9E%E6%96%87%E6%95%B0/1830170?fr=aladdin
 * <br>其他的可以參考官网的讨论
 * @author WPB
 *
 */
public class Q9_PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}
		int revX = 0;
		while (revX < x) {
			revX = revX * 10 + x % 10;
			x /= 10;
		}
		return (revX == x || revX / 10 == x);
	}
}
