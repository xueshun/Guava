package table;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * 双键的Map --> table
 * @author Administrator
 *  双键Map  rowKey  + columnKey + value
 *  
 * 	a)  所有的行数据 cellSet()
 *  b)	所有的学生： rowKeySet()
 *  c)	所有的课程： columnKeySet()
 *  d)	所有的成绩： values()
 *  e)	学生对应的课程：rowMap() + get(学生)+row(学生)
 *  f)	课程对应的学生 ： columnMap + get(课程) +  column(课程)

 */
public class GuavaTester {
	
	public static void main(String[] args) {
		Table<String,String,Integer> tables = HashBasedTable.create();
		
		//测试数据
		tables.put("a", "JAVASE", 80);
		tables.put("b", "JAVASE", 90);
		tables.put("a", "oracle", 100);
		tables.put("c", "oracle", 95);
		
		Set<Cell<String,String,Integer>> cells = tables.cellSet();
		
		for (Cell<String, String, Integer> temps : cells) {
			System.out.println(temps.getRowKey()+"-->"+temps.getColumnKey()+"-->"+temps.getValue());
		}
		
		System.out.println("=======学生查看课程成绩=============");
		System.out.print("学生\t");
		//所有的课程
		Set<String> cours = tables.columnKeySet();
		for (String t : cours) {
			System.out.print(t+"\t");
		}
		System.out.println();
		
		//所有的学生
		Set<String> stus = tables.rowKeySet();
		for (String stu : stus) {
			System.out.print(stu+"\t");
			Map<String,Integer> scoures = tables.row(stu);
			for (String c : cours) {
				System.out.print(scoures.get(c)+"\t");
			}
			System.out.println();
		}
		
		
		System.out.println("=======课程查看学生成绩=============");
		
		
		System.out.println("============转换================");
		Table<String,String,Integer> tables2 = Tables.transpose(tables);
		
		//所有的行数据
		
		Set<Cell<String,String,Integer>>cells2 = tables2.cellSet();
		for (Cell<String, String, Integer> temp : cells2) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
	}
}
