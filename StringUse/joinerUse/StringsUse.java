package joinerUse;

import com.google.common.base.Strings;

public class StringsUse {
	public static void main(String[] args) {
		
		//Strings.padEnd  普全右
		String a = "12345";
		String b = Strings.padEnd(a, 10, 'x');
		System.out.println(b);//12345xxxxx
		
		//Strings.padStart
		String c = Strings.padStart(a, 10, 'y');
		System.out.println(c);//yyyyy12345
		
		//Strings.isNullOrEmpty
		String d = "";
		boolean e = Strings.isNullOrEmpty(d);
		System.out.println(e);//true
		
		//Strings.nullToEmpty
		String f = null;
		String g = Strings.nullToEmpty(f);
		System.out.println(g);
		
		//Strings.emptyToNull  方法  
		
		//Strings.repeat 重复字符串
		String h = "123";
		String x = Strings.repeat(h, 3);
		System.out.println(x);
		
		//Strings.commonPrefix 获取a,b左公共部分字符串
		String y ="adcdsfsfs";
		String w = "adc3sfsd";
		String q= Strings.commonPrefix(y, w);
		System.out.println(q);
		
		//Stings.commonSuffix获取右公共部分
		String u="faaxyz";  
	    String i="fwefxyz";  
	    String o=Strings.commonSuffix(u, i);  
	    System.out.println(o); 
	    
	}
}
