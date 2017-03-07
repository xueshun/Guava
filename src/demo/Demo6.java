package demo;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 集合的操作
 * @author Administrator
 *
 */
public class Demo6 {
	public static void main(String[] args) {
		 Set<Integer> sets = Sets.newHashSet(1,2,3,4,5,6);
	     Set<Integer> sets2 = Sets.newHashSet(3,4,5,6,7,8,9);
	     
	     //交集
	     System.out.println("交集为：");
	     SetView<Integer> interSection = Sets.intersection(sets, sets2);
	     for (Integer temp : interSection) {
			System.out.print(temp);
		}
	     
	    System.out.println("===============");
	    //差集
	    System.out.println("差集为：");
	    SetView<Integer> diff = Sets.difference(sets, sets2);
	    for (Integer temp : diff) {
			System.out.print(temp);
		}
	    
	    //并集
	    System.out.println("=====并集======");
	    SetView<Integer> union = Sets.union(sets, sets2);
	    for (Integer temp : union) {
			System.out.print(temp);
		}
	    
	}
}
