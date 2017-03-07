package bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap 键唯一，值可以重复
 * @author Administrator
 * BiMap:双向Map(Bidirectional map)键和值都不能重复（unique - valued map）
 *  
 *  案例 根据邮箱找用户 根据用户找邮箱
 */
public class GuavaTester {
	
	public static void main(String[] args) {
		BiMap<String,String>bimap = HashBiMap.create();
		
		//添加数据
		bimap.put("bjsxt", "bjsxt@sina.com");
		bimap.put("good", "good@qq.com");
		
		//通过邮箱找用户
		String user = bimap.inverse().get("good@qq.com");
		System.out.println(user);
		
		System.out.println(bimap.inverse().inverse() == bimap);
	}
}
