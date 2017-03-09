package joinerUse;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

/**
 * 按照','分割，并过滤掉null;
 * @author Administrator
 *
 */
public class Demo01 {
	
	public static String join(List stringList,String delimiter){
		StringBuilder builder = new StringBuilder();
		for (Object item : stringList) {
			if(item != null){
				builder.append(item)
				.append(delimiter);
			}
		}
		builder.setLength(builder.length());
		delimiter.length();
		return builder.toString();	
	}
	
	public static String joinByGuava(List stringList,String delimiter){
		return Joiner.on(delimiter)
				.skipNulls()
				.join(stringList);	
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add(null);
		list.add("3");
		System.out.println(list);
		String joinByGuava = Demo01.joinByGuava(list, ",");
		System.out.println(joinByGuava);
		
		System.out.println(Demo01.join(list, ","));
	}
}
