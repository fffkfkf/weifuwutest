package atguigu.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class TestLambda {
	
	//原来的匿名内部类
	@Test
	public void test1(){
		// 字符串长度从小到大的顺序排列. Comparator该接口代表一个比较器.
		//1,单独new了一个Comparator的实现类
		Comparator<String> com = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//默认是自增.
				return Integer.compare(o1.length(), o2.length());
			}
		};

		TreeSet<String> ts = new TreeSet<String>(com);
		ts.add("67");
		ts.add("5");
		ts.add("9");
		ts.add("2");
		//注意是:字符串长度
		System.out.println(ts);
		System.out.println("--------------");

		//---------------------
		//2,
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		ts2.add("55");
		ts2.add("5532");
		ts2.add("276762");
		ts2.add("66");
		System.out.println(ts2.toString());
		System.out.println("-----------");
	}

	
	//Java8 中的 Lambda 表达式
	@Test
	public void test2(){
		//第一种写法.
		Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
		TreeSet<String> ts33 = new TreeSet<>(com);

		//第二种写法.
		TreeSet<String> ts = new TreeSet<>((x, y) -> Integer.compare(x.length(), y.length()));
	}

	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 58, 5999.55),
			new Employee(103, "王五", 16, 3333.33),
			new Employee(104, "赵六", 8, 6666.66),
			new Employee(105, "田七", 98, 8888.88)
	);

	//需求：获取所有年龄小于 35 的 Employee
	@Test
	public void test3(){
		List<Employee> list = filterEmployeeAge(emps);

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	//需求：获取所有年龄小于 35 的 Employee
	public List<Employee> filterEmployeeAge(List<Employee> list){
		List<Employee> employees = new ArrayList<>();

		for (Employee employee : list) {
			if(employee.getAge() <= 35){
				employees.add(employee);
			}
		}

		return employees;
	}

	//需求：获取所有工资大于 5000 的 Employee
	public List<Employee> filterEmployeeSalary(List<Employee> list){
		List<Employee> employees = new ArrayList<>();

		for (Employee employee : list) {
			if(employee.getSalary() >= 5000){
				employees.add(employee);
			}
		}

		return employees;
	}

//自定义函数型接口(@FunctionalInterface用法)
	@Test
	public void test4(){
		List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());

		for (Employee employee : list) {
			System.out.println(employee);
		}

		List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());

		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}
	//-------------------------------------------------

	//优化方式一:策略设计模式
	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
		List<Employee> employees = new ArrayList<>();

		for (Employee employee : list) {
			if(mp.apply(employee)){
				employees.add(employee);
			}
		}

		return employees;
	}

	//优化方式二：,不在单独定义FilterEmployeeForAge类,而是用匿名内部类.
	@Test
	public void test5(){
		List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
			@Override
			public boolean apply(Employee t) {
				return t.getSalary() >= 9999;
			}
		});
		System.out.println(list);
	}
	
	//优化方式三：Lambda 表达式代替匿名内部类.
	@Test
	public void test6(){
		List<Employee> list = filterEmployee(emps, (t) -> t.getSalary() >= 5000);
		list.forEach(System.out::println);
	}
	
	//优化方式四：Stream API ?????????
	@Test
	public void test7(){
		emps.stream()
			.filter((t) -> t.getSalary() >= 5000)
			.limit(6)//返回由该流的元素流，截断成比不再maxSize长。
			.forEach(System.out::println);
		
		System.out.println("111--------------------------------");
		
		emps.stream()
			.map((t) -> t.getName())
			.forEach(System.out::print);

		System.out.println("222--------------------------------");


	}
	
}
