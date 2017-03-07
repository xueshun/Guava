package ordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

public class Binary {
	public static void main(String[] args) {
		binary();
	}
	/**
	 * 搜索排序列表使用键的二进制搜索算法
	 */
	private static void binary() {
		Ordering ordering = Ordering.natural();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int binarySearch = ordering.binarySearch(list,5);
		int indexOf = list.indexOf(5);
		System.out.println(binarySearch);
		System.out.println(indexOf);
	}
}
