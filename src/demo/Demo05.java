package demo;

import java.util.Set;


import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * 加入约束条件： 非空，长度验证
 * @author Administrator
 * Constraint
 */
public class Demo05 {
	public static void main(String[] args) {
			
		Set<String> sets = Sets.newHashSet();
		
		//创建约束条件
		Constraint<String> constraint = new Constraint<String>(){

			@Override
			public String checkElement(String element) {
				//非空验证
				Preconditions.checkNotNull(element);
				//长度验证
				Preconditions.checkArgument(element.length()>=5 && element.length()<=20);
				return element;
			}
		};
		
		Set<String> cs = Constraints.constrainedSet(sets, constraint);
		//cs.add(null); // java.lang.NullPointerException
		//cs.add("dog"); //java.lang.IllegalArgumentException
		cs.add("bjsxt");
		
		for (String temp : cs) {
			System.out.println(temp);
		}
	}
}
