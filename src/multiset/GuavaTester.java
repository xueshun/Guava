package multiset;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 统计单词出现的次数
 * @author Administrator
 *	Multiset ： 无序 + 可重复  .count()  增强了可读性 + 操作简单
 *
 *  案例：会员访问网站的次数
 */
public class GuavaTester {
	
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice where is the food";
		//分割字符串
		String[] strArray = str.split(" ");
		//存储到MultiSet中
		Multiset<String> set = HashMultiset.create();
		for (String strTemp : strArray) {
			set.add(strTemp);
		}
		 
		//获取所有的单词set
		Set<String> letters = set.elementSet();
		for (String temp : letters) {
			System.out.println(temp+"-->"+set.count(temp));
		}
	}
}
