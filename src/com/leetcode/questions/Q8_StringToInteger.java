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
 * 问题描述：atoi (表示 ascii to integer)是把字符串转换成整型数的一个函数,函数会扫描参数
 * nptr字符串，跳过前面的空白字符（例如空格，tab缩进）等，
 * 直到遇上数字或正负符号才开始做转换，而在遇到非数字或字符串结束时才结束转换，并将结果返回。如果 nptr不能转换成 int、
 * nptr为空字符串，那么将返回 。溢出则返回INT_MAX或者INT_MIN
 * <p>
 * 思路描述：一开始理解有误，以为是各种字符都有。后来参考了下官网的Discuss，https://leetcode.com/problems/string-to-integer-atoi/discuss/<br>
 * 以下的代码就当是一种参考。<br>
 * 发现大致为：跳过空格，选择可选的前导+或者-，后面是尽可能多的数字，直到结束或者遇到非数字。<br>
 * 项目中确实遇到过这种场景：数值型的字段使用正负号+定长字符，然后对字符串进行解析。 这种场景下会有正负号、符号后的0和实际的数字，
 * 比如定长10位，第1位是正负号：+066666660，实际上就是66666660
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
			//溢出判断
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + str.charAt(index++) - '0';
		}
		return result * sign;
	}
}
