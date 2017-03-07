package immutable;

import java.awt.Color;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

public class Demo {
	public static void main(String[] args) {
		Set<Integer> set= Sets.newHashSet(1,2,3);
		
		ImmutableSet.copyOf(set);
		
		ImmutableSet.of(1,2,3);
		
		ImmutableMap.of("a",1,"b",2);
		
		//此外，对有序不可变集合来说，排序是在构造集合的时候完成
		ImmutableSortedSet<String> of = ImmutableSortedSet.of("a","b","c","a","d","b");
		System.out.println(of);
		
	}
	
	public static final ImmutableSet<Color> GOOGLE_COLORS =
	    ImmutableSet.<Color>builder()
	        .add(new Color(0, 191, 255)) .build();

}
