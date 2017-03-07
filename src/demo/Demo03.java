package demo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

/**
 * Function
 * @author Administrator
 * Collections2.transform()
 */
public class Demo03 {
	public static void main(String[] args) {
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(10000000000L);
		timeSet.add(9999999999999999L);
		timeSet.add(2000000000000000L);
		
		Collection<String> timeStrCol = Collections2.transform(timeSet,new Function<Long,String>(){

			@Override
			public String apply(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
			
		});
		
		for (String temp : timeStrCol) {
			System.out.println(temp);
		}
	}
}
