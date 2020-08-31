package atguigu.java8;

import atguigu.java8.Employee;
import atguigu.java8.MyFunction;
import atguigu.java8.MyFunction2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda11 {
	
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 58, 5999.55),
			new Employee(103, "王五", 16, 3333.33),
			new Employee(104, "赵六", 8, 6666.66),
			new Employee(105, "田七", 98, 8888.88)
	);
	
	@Test
	public void test1(){
		Collections.sort(emps, (e1, e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	//处理字符串
	@Test
	public void test2(){
		String upper = strHandler("abcdef", (str) -> str.toUpperCase());
		System.out.println(upper);
		
		String newStr = strHandler("abcdef", (str) -> str.substring(0, 2));
		System.out.println(newStr);
	}
	
	public String strHandler(String str, MyFunction mf){
		return mf.getValue(str);
	}
	
	@Test
	public void test3(){
		Long sum = longHandler(100L, 200L, (l1, l2) -> l1 + l2);
		System.out.println(sum);
		
		System.out.println(longHandler(10L, 20L, (l1, l2) -> l1 * l2));
	}
	
	public Long longHandler(Long l1, Long l2, MyFunction2<Long, Long> mf){
		return mf.getValue(l1, l2);
	}
}
