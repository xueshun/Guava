package joinerUse;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;

/**
 * splitter 工具类
 * 	主要的功能是拆分字符串为 集合map等
 * @author Administrator
 *	Splitter.on();  char  		Splitter.on(',')   按单个字符拆分
 *					CharMatcher Splitter.on(CharMatcher.BREAKING_WHITESPACE) 按照字符匹配器拆分
 *					String      Splitter.on(', ')  按照字符串拆分
 *					Pattern     Splitter.on(Pattern)  Splitter.onPattern(String)  按照正则表达式
 *					fixedLength Splitter.fixedLength(int) 按固定长度拆分；最后一段可能比给定长度短，但不会为空。
 *	
 *		omitEmptyStrings() 
 *		trimResults()
 *		trimResults(CharMatcher)
 *  	limit(int) 
 */
public class SplitterUse {
	public static void main(String[] args) {
		
		//拆分字符串为list集合
		Splitter splitter01 =Splitter.on(",");
		String str = "a,b,c,d,e,,f, g ";
		String str01 = "abcdefghi";
		List<String> list = splitter01.splitToList(str);
		System.out.println(list);
		
		//忽略空字符
		Splitter splitter02 =Splitter.on(",").omitEmptyStrings();
		List<String> list01 = splitter02.splitToList(str);
		System.out.println(list01);
		
		//忽略空字符且去除字符串前后空格
		Splitter splitter03 = Splitter.on(",").omitEmptyStrings().trimResults();
		List<String> list02 = splitter03.splitToList(str);
		System.out.println(list02);
		
		Splitter splitter04 =Splitter.on(",").limit(4);
		 List<String> list03 = splitter04.splitToList(str01);
		System.out.println(list03);
		
		  Escaper htmlEscaper =HtmlEscapers.htmlEscaper();  
	      System.out.println(htmlEscaper.escape("<a>你好</a>")); 
	}
}
