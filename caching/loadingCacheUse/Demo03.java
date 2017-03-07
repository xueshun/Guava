package loadingCacheUse;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 基于泛型的Callable Cache
 * @author Administrator
 *
 */
public class Demo03 {
	
	private static Cache<String,String>cacheFormCallable = null;
	
	public static<K,V>Cache<K,V> callableCached() throws Exception{
		Cache<K,V>cache = CacheBuilder
				.newBuilder()
				.maximumSize(10000)
				.expireAfterAccess(10, TimeUnit.MINUTES)
				.build();
		return cache;	
	}
	
	private String getCallableCache(final String userName){
		try {
			//Callable只有在缓存值不存在的时，返回调用
			return cacheFormCallable.get(userName, new Callable<String>() {
				
				@Override
				public String call() throws Exception {
					System.out.println(userName + " from db");
					return "hello "+ userName + " !";
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Test
    public void testCallableCache() throws Exception{
         final String u1name = "peida";
         final String u2name = "jerry"; 
         final String u3name = "lisa"; 
         cacheFormCallable=callableCached();
         System.out.println("peida:"+getCallableCache(u1name));
         System.out.println("jerry:"+getCallableCache(u2name));
         System.out.println("lisa:"+getCallableCache(u3name));
         System.out.println("peida:"+getCallableCache(u1name));
         /*
          * 说明：Callable只有在缓存值不存在时，才会调用，
          * 比如第二次调用getCallableCache(u1name)直接返回缓存中的值
          */
    }
}
