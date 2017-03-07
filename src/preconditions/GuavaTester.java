package preconditions;

import com.google.common.base.Preconditions;

/**
 * Preconditions 提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。
 * 它检查的先决条件。 其方法失败抛出IllegalArgumentException
 * 
 * Preconditions.checkArgument()
 * 
 * Preconditions.checkNotNull()
 * 
 * Preconditions.checkElementsIndex()
 * 
 * Preconditions.checkPositionIndex()
 * 
 * Preconditions.checkState()
 * @author Administrator
 *
 */
public class GuavaTester {
	public static void main(String[] args) {
		GuavaTester guavaTester = new GuavaTester();
		try {
			System.out.println(guavaTester.sqrt(-3.0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(guavaTester.sum(null, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(guavaTester.getValue(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public double sqrt(double input){
		Preconditions.checkArgument(input > 0.0, 
				"Illegal Argument passed : Negative value %s", input);
		return Math.sqrt(input);
	}
	
	public int sum(Integer a,Integer b){
		a = Preconditions.checkNotNull(a, 
				"Illegal Argument passed : First parameter is null");
		
		b = Preconditions.checkNotNull(b, 
				"Illegal Argument passed : Second parameter is null");
		return a + b;
	}
	
	public int getValue(int input){
		int[] data = {1,2,3,4,5};
		Preconditions.checkElementIndex(input, data.length, 
				"Illegal Argument passed: Invalid index");
		return 0;
	}
}
