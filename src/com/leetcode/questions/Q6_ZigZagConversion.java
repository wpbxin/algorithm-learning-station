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
 * ����������Z��ת�����ת������ַ���
 * <p>
 * ˼·������<br>
 * ����һ���ο�����https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
 * ��Ҳ�ǱȽ�����������ģ�����numRows���ַ�����Ȼ������������������͵�����������ַ����չ�����ӵ���Щ�ַ��������У����ϲ���<br>
 * �����������������飬ֱ�Ӹ��ݹ���һ��һ��ƴ���ַ�����
 * 1��Z���߷���һ���ܹ���n = numRows + numRows - 2
 * 2���ӵ�0�п�ʼ����,��Ϊ��row�У���0�к����һ��numRows�Ĺ���ȽϺ�ȷ�ϣ�n * j + row��Ϊ��row���е��ַ�,j��0��ʼ��ֱ��n * j + row�ٽ磬row�й���j���ַ�
 * 3�������е��ַ�����������ļ�¼�ַ����ڲ���Խ�������£������һ�����ӵ��ַ�������ַ����±�����������㣺(j + 1) * n - row��
 * ��ʵ(j + 1) * n����һ��Ŀ�ͷ����ȥ��ǰ������row�����ɵõ���һ���ַ���������������ӣ�row=1��j=0����һ����ַ���A(��һ�еĵ�2���ַ�)��
 * ����������±�3����P(��2�е�2���ַ�)���ϲ�
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
