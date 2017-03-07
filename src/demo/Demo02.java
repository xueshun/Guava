package demo;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 函数式编程
 * @author Administrator
 *	1.Predicate
 *	2.Function
 *
 * 工具：Collections2.filter()  过滤器
 */
public class Demo02 {
	
	public static void main(String[] args) {
		//创建List  静态初始化
		List<String> list = Lists.newArrayList("moom","son","dad","bjsxt","refer");
		//找出回文 palindrome  backwords mirror words
		//匿名内部类对象 ： 匿名内部类，同时创建类对象
		Collection<String> palindrome = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				//业务逻辑
				return new StringBuilder(input).reverse().toString().equals(input);
			}
		});
		
		for (String temp : palindrome) {
			System.out.println(temp);
		}
	}
}
