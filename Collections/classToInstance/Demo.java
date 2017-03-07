package classToInstance;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
/**
 * ClassToInstanceMap是一种特殊的Map:它的键是类型，而值是复合键所指类型的对象
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
		numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
		
		System.out.println(numberDefaults);
	}
}
