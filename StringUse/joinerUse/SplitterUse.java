package joinerUse;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;

/**
 * splitter 工具类
 * 	主要的功能是拆分字符串为 集合map等
 * @author Administrator
 *
 */
public class SplitterUse {
	public static void main(String[] args) {
		
		//拆分字符串为list集合
		Splitter splitter01 =Splitter.on(",");
		String str = "a,b,c,d,e,,f, g ";
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
		
	
		
		  Escaper htmlEscaper =HtmlEscapers.htmlEscaper();  
	      System.out.println(htmlEscaper.escape("<a>你好</a>")); 
	}
}
