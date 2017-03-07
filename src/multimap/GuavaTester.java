package multimap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 分析查看每门教师 教授的每门课程
 * @author Administrator
 * Multimap : key - value  key 可以重复
 */
public class GuavaTester {
	public static void main(String[] args) {
		Map<String,String> cours = new HashMap<String,String>();
		//加入测试数据
		cours.put("改革开发", "邓爷爷");
		cours.put("三个代表", "江主席");
		cours.put("科学发展观","胡主席");
		cours.put("和谐社会", "胡主席");
		cours.put("八荣八耻", "胡主席");
		cours.put(".....","习大大");
		
		//Multimap
		Multimap<String,String> teachers = ArrayListMultimap.create();
		
		//迭代器
		Iterator<Map.Entry<String, String>> it = cours.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();//课程
			String value = entry.getValue();//教师
			
			//教师 -->课程
			teachers.put(value, key);
		}
		
		//查看Multimap
		Set<String> keyset = teachers.keySet();
		for (String key : keyset) {
			Collection<String> col = teachers.get(key);
			System.out.println(key+"-->"+col);
		}
		
		Map<String, Collection<String>> asMap = teachers.asMap();
		System.out.println(asMap.get("胡主席"));
		
		//entries用Collection<<Map,Entry<K,V>>返回Multimap中所有
		//"键 - 单个值映射" ---包括重复值（对SetMultimap，返回的是Set）
		System.out.println(teachers.entries());
		
		System.out.println(teachers.keySet());
		
		//用Multiset标识Multimap中的所有键，每个键出现的次数等于他映射的值的个数
		//可以从这个Multiset中移除元素，但不能做添加操作；移除操作会反映到底层的Multimap。???
		System.out.println(teachers.keys());
		/*Iterator<Entry<String, Collection<String>>> its = asMap.entrySet().iterator();
		while (its.hasNext()) {
			System.out.println();
			
		}*/
	}
}
