package iterable;

import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;

public class Demo01 {
	public static void main(String[] args) {
		Iterable<Integer> concatenated = Iterables.concat(
				Ints.asList(1,2,3),
				Ints.asList(4,5,6));
		//String lastAdded = Iterables.getLast(iterable);
	}
}
