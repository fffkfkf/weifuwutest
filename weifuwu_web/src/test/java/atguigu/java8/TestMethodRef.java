package atguigu.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/*
 * 一、方法引用：如果 Lambda 体中的功能，已经有方法实现了，可以使用方法引用
 * 			  (可以把方法引用理解为 Lambda 表达式的另外一种表现形式)
 * 
 * 方法引用中引入了新的操作符 “::”，语法格式如下：
 * 
 * 1.对象的引用 :: 实例方法名
 * 2.类名 :: 静态方法名
 * 3.类名 :: 实例方法名
 *
 * 方法引用的注意：
 * 	①方法引用的方法参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 *  ②若Lambda 的参数列表的第一个参数，是方法引用方法的调用者，第二个参数是方法引用方法的参数时(或无参数)。可以使用：ClassName::methodName
 *
 * 二、构造器引用
 * 	格式：ClassName::new
 * 	注意：构造器引用的参数列表，必须与函数式接口中抽象方法的参数列表保持一致！
 * 三、数组引用
 * 	格式： type[]::new;
 * 
 * 
 */
public class TestMethodRef {
	
	//对象的引用 :: 实例方法名
	@Test
	public void test1(){
		PrintStream ps = System.out;
		Consumer<String> con = (x) -> ps.println(x);
		con.accept("哈哈哈");
		
		System.out.println("-----------------------------");
		
		//实例方法名
		Consumer<String> con2 = ps::println;
		con2.accept("嘿嘿嘿");

		System.out.println("----111111----------");
		Consumer<String> con3 = System.out::println;
		con3.accept("hhh");
	}

	//对象的引用 :: 实例方法名
	@Test
	public void test2(){
		Employee emp = new Employee(101, "张三", 18, 9999.99);

		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());

		System.out.println("----------------------------");

		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());

		Supplier<Integer> sup3 = emp::getAge;
		System.out.println(sup3.get());
	}

	//类名 :: 静态方法名
	@Test
	public void test3(){
		BiFunction<Integer, Integer, Integer> bf = (x, y) -> Math.max(x, y);
		System.out.println(bf.apply(10, 20));

		System.out.println("----------------------------");

		BiFunction<Integer, Integer, Integer> bf2 = Math::max;
		System.out.println(bf2.apply(10, 20));

		System.out.println("--------22-----------");
		Supplier<Double> sup = Math::random;
		System.out.println(sup.get());

		double random = Math.random();
		int i = (int) (random * 100);
		System.out.println(i);
		System.out.println(random);
	}

	//类名 :: 实例方法名
	@Test
	public void test4(){
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		System.out.println(bp.test("abc", "abc"));

		System.out.println("--------------------------------");

		BiPredicate<String, String> bp2 = String::equals;
		System.out.println(bp2.test("ddd", "eee"));

		System.out.println("--------------------------------");

		Consumer<Employee> con = (e) -> e.show();
		con.accept(new Employee());

		System.out.println("---------------------");

		Consumer<Employee> con2 = Employee::show;
		con2.accept(new Employee());
	}

	//构造器引用
	@Test
	public void test5(){
		Supplier<Employee> sup = () -> new Employee();
		System.out.println(sup.get());

		System.out.println("1--------------------------------------");

		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());

		System.out.println("2--------------------------------------");

		Function<String, Employee> fun = (name) -> new Employee(name);

		System.out.println("3--------------------------------------");

		Function<String, Employee> fun2 = Employee::new;
		Employee emp = fun2.apply("张三");
		System.out.println(emp.getName());

		System.out.println("4---------------------------------------");

		BiFunction<Integer, Integer, Employee> bf = Employee::new;
	}

	//数组引用
	@Test
	public void test6(){
		Function<Integer, String[]> fun = String[]::new;
		String[] strs = fun.apply(10);
		System.out.println(strs.length);

		String[] strings = new String[4];
		System.out.println(strings.length);
	}

	@Test
	public void test7(){
		List<Employee> emps = Arrays.asList(
				new Employee(101, "张三", 18, 9999.99),
				new Employee(102, "李四", 58, 5999.55),
				new Employee(103, "王五", 16, 3333.33),
				new Employee(104, "赵六", 8, 6666.66),
				new Employee(105, "田七", 98, 8888.88)
		);

		System.out.println("---1--------");
		emps.stream()
			.forEach((x) -> System.out.println(x));
		System.out.println("---2--------");
		emps.stream()
			.forEach(System.out::println);
		
		System.out.println("----------------------");
		
		emps.stream()
			.map((e) -> e.getAge())
			.sorted((x, y) -> Integer.compare(x, y))
			.forEach((x) -> System.out.println(x));
		
		System.out.println("----------------------");
		
		emps.stream()
		  	.map(Employee::getAge)
		  	.sorted(Integer::compare)
		  	.forEach(System.out::println);
	} 
}
