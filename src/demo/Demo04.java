package demo;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 *  组合式函数编程
 * @author Administrator
 *  确保容器中的字符长度不超过5，超过进行截取，后全部大写
 *  
 *  Functions.compose()
 */
public class Demo04 {
	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("bjsxt","good","happiness");
		
		//判断一个字符串是否长度大于 5 大于截取
		Function<String,String> f1 = new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.length()>5 ? input.substring(0,5):input;
			}
			
		};
		
		//小写 转大写
		Function<String,String> f2 =new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
			
		};
		
		Function<String,String> f = Functions.compose(f1, f2);
		
		Collection<String> resultCol = Collections2.transform(list, f);
		
		for (String temp : resultCol) {
			System.out.println(temp);
		}
	}
}
