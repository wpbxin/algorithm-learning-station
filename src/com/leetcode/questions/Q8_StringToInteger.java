package com.leetcode.questions;

/**
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * <p>
 * Requirements for atoi:<br>
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.<br>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.<br>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.<br>
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * <p>
 * ����������atoi (��ʾ ascii to integer)�ǰ��ַ���ת������������һ������,������ɨ�����
 * nptr�ַ���������ǰ��Ŀհ��ַ�������ո�tab�������ȣ�
 * ֱ���������ֻ��������Ųſ�ʼ��ת�����������������ֻ��ַ�������ʱ�Ž���ת��������������ء���� nptr����ת���� int��
 * nptrΪ���ַ�������ô������ ������򷵻�INT_MAX����INT_MIN
 * <p>
 * ˼·������һ��ʼ���������Ϊ�Ǹ����ַ����С������ο����¹�����Discuss��https://leetcode.com/problems/string-to-integer-atoi/discuss/<br>
 * ���µĴ���͵���һ�ֲο���<br>
 * ���ִ���Ϊ�������ո�ѡ���ѡ��ǰ��+����-�������Ǿ����ܶ�����֣�ֱ�������������������֡�<br>
 * ��Ŀ��ȷʵ���������ֳ�������ֵ�͵��ֶ�ʹ��������+�����ַ���Ȼ����ַ������н����� ���ֳ����»��������š����ź��0��ʵ�ʵ����֣�
 * ���綨��10λ����1λ�������ţ�+066666660��ʵ���Ͼ���66666660
 * 
 * @author WPB
 *
 */
public class Q8_StringToInteger {
	public int myAtoi(String str) {
		if (null == str || str.isEmpty()) {
			return 0;
		}
		int result = 0, sign = 1, index = 0, len = str.length();
		while (index < len && str.charAt(index) == ' ') {
			index++;
		}
		if (index == len) {
			return 0;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index++) == '-' ? -1 : 1;
		}
		while (index < len && str.charAt(index) <= '9' && str.charAt(index) >= '0') {
			//����ж�
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + str.charAt(index++) - '0';
		}
		return result * sign;
	}
}
