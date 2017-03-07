package immutable;

import java.lang.management.ThreadInfo;
import java.util.Collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Demo01 {
	public static void main(String[] args) {
		ImmutableSet<String> foobar = ImmutableSet.of("foo","bar","baz");
		//thingamajig(foobar);
	}
	private  void thingamajig(Collection<String>collection){
		 ImmutableList<String> defensiveCopy = ImmutableList.copyOf(collection);
	}
}
