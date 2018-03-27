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
 * �����������ж�һ�����Ƿ��ǻ�����
 * <p>
 * ˼·������ <br>
 * ��ֱ�Ӽ򵥵ķ���ʱֱ�ӷ�ת���ֽ����жϣ�����Ҫ������������⣬������Ҫ��������������λ�������ݻ�����(��������Ȼ��)�Ķ��壬�������ǶԳƵģ�
 * ֻ�跴תһ������ּ��ɡ�<br>
 * ע�����⣺<br>
 * 1������ֵ���⣺����0�����֣��Ҹ�λ����0�����Բ��ǡ�С��0�ĸ��������Բ���<br>
 * 2������������λ����ת������/10=ǰ�벿��<br>
 * 3��������ż��λ����ת������=ǰ�벿��<br>
 * 4����˹ؼ����ж��������ǣ���ת������ < ǰ�벿��
 * <p>
 * <br>������-ά���ٿƣ�https://en.wikipedia.org/wiki/Palindromic_number
 * <br>������-�ٶȰٿƣ�https://baike.baidu.com/item/%E5%9B%9E%E6%96%87%E6%95%B0/1830170?fr=aladdin
 * <br>�����Ŀ��ԅ�������������
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
