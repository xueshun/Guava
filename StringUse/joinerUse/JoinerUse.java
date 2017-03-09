package joinerUse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Joiner;

public class JoinerUse {
	
	public static void main(String[] args) {
		
		//连接List列表
		Joiner joiner = Joiner.on(",");
		List<String> list = new ArrayList<String>();
		list.add("xiaoming");
		list.add("xiaohong");
		list.add("wangsan");
		System.out.println(joiner.join(list));
		
		//连接Iterator<T>列表
		Joiner joiner01 = Joiner.on(",");
		List<String> list1 = new ArrayList<String>();
		list1.add("xiaoming");
		list1.add("xiaohong");
		list1.add(null);
		list1.add("wangsan");
		Iterator<String> it = list.iterator();
		System.out.println(joiner01.join(it));
		
		//连接多个字符串
		Joiner joiner02 = Joiner.on(",");
		System.out.println(joiner02.join("123","345","56","43"));
		
		//字符串与列表
		StringBuilder builder = new StringBuilder("标题");
		//System.out.println(joiner02.appendTo(builder, list));
		
		
		//跳过null
		Joiner joiner03 =Joiner.on(",").skipNulls();
		//System.out.println(joiner03.appendTo(builder, list1));
		
		//替换null值进行连接
		Joiner joiner04 = Joiner.on(",").useForNull("123");
		System.out.println(joiner04.appendTo(builder, list1));
		
	}
}
