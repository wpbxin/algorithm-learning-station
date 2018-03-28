package com.leetcode.questions;
/**
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"<br>
 * Write the code that will take a string and make this conversion given a number of rows:<br>
 * string convert(string text, int nRows);<br>
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * 问题描述：Z型转换输出转换后的字符串
 * <p>
 * 思路描述：<br>
 * 方法一、参考官网https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
 * 这也是比较容易想出来的，建立numRows个字符串，然后遍历，对数组正数和倒数，逐个把字符按照规则添加到这些字符串数组中，最后合并。<br>
 * 方法二、不建立数组，直接根据规则一行一行拼接字符串。
 * 1、Z型走法，一组总共是n = numRows + numRows - 2
 * 2、从第0行开始计数,记为第row行，第0行和最后一行numRows的规则比较好确认：n * j + row即为第row所有的字符,j从0开始，直到n * j + row临界，row行共有j个字符
 * 3、其他行的字符，除了上面的记录字符，在不会越界的情况下，还会多一个连接的字符，这个字符的下标可以这样计算：(j + 1) * n - row，
 * 其实(j + 1) * n是下一组的开头，减去当前的行数row，即可得到下一个字符，比如上面的例子，row=1，j=0，下一组的字符是A(第一行的第2个字符)，
 * 计算出来的下标3，即P(第2行第2个字符)，合并
 * 
 * @author WPB
 *
 */
public class Q6_ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int n = numRows + numRows - 2, len = s.length();
		StringBuilder result = new StringBuilder();
		for (int row = 0; row < numRows; row++) {
			int j = 0, headIndex = j * n + row, tailIndex = (j + 1) * n - row;
			while (headIndex < len) {
				result.append(s.charAt(headIndex));
				j++;
				headIndex = j * n + row;
				if (row != 0 && row != numRows - 1 && tailIndex < len) {
					result.append(s.charAt(tailIndex));
					tailIndex = (j + 1) * n - row;
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Q6_ZigZagConversion s = new Q6_ZigZagConversion();
		System.out.println(s.convert("PAYPALISHIRING", 3));
	}
}
