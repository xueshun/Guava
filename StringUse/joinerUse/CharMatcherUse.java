package joinerUse;

import com.google.common.base.CharMatcher;

/**
 * CharMatcher  对字符串特定类型操作 trim(修剪)，collapse(折叠),remove(移除),retain(保留)
 * @author Administrator
 * 		ANY  NONE WHITRSPACE BREAKING_WHITESPACE  INVISIBILE　DIGIT  JAVA_LETTER
 * 		JAVA_DIGIT  JAVA_LETTER_OR_DIGIT  JAVA_ISO_CONTROL  JAVA_LOWER_CASE  JAVA_UPPER_CASE
 * 		ASCII  SINGLE_WIDTH
 * 
 * 	anyOf(CharSequence) 枚举匹配字符。如CharMatcher.anyOf("aeiou") 匹配小写的英文元音
 *  is(char)  给定单一字符匹配。
 *  inRange(char,char) 给定字符范围匹配如CharMatcher.inRange('a','z');
 *  negate();
 *  and(CharMatcher);
 *  or(CharMatcher)
 *  
 *  collapseFrom(CharSequence, char) 把每组连续的匹配字符替换为特定字符。
 *  		如WHITESPACE.collapseFrom(string, ‘ ‘)把字符串中的连续空白字符替换为单个空格。
 *  
 *	matchesAllOf(CharSequence)测试是否字符序列中的所有字符都匹配。
 *
 *	removeFrom(CharSequence)从字符序列中移除所有匹配字符
 *
 *	retainFrom(CharSequence) 在字符序列中保留匹配字符，移除其他字符
 *
 *	trimFrom(CharSequence)  移除字符序列的前导匹配字符和尾部匹配字符。
 *
 *	replaceFrom(CharSequence,   CharSequence)用特定字符序列替代匹配字符。
 */
public class CharMatcherUse {
	public static void main(String[] args) {
		String str = "CONTROL1a2d6d5fd2g5";
		String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(str);
		System.out.println(noControl);
		
		String theDigits = CharMatcher.DIGIT.retainFrom(str);
		System.out.println(theDigits);
		
		//去除两端的空格，并把中间连续的空格替换为单个空格
		String str01 = " 1   2   3  4  ";
		String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(str01, ' ');
		System.out.println(spaced);
		
		//用*替代所有的数字
		String str02 = "1a2b3c4d5e";
		String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(str02, "*");
		System.out.println(noDigits);
		
		//只保留数字和小写字符
		String str03 = "1a2B3c4D5e6F";
		String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(str03);
		System.out.println(lowerAndDigit);
		
		String stro3 = "abcdefighijklmn";
		String what = CharMatcher.anyOf("aeiou").retainFrom(stro3);
		System.out.println(what);
		
		String str04 = "a1b1c1d1f1h1";
		String str05 = "2";
		String replaceFrom = CharMatcher.DIGIT.replaceFrom(str04, str05);
		System.out.println(replaceFrom);
		
	}
}
