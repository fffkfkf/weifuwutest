package atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * 一、Stream 的操作步骤：
 * 
 * 1. 创建流
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI1 {

	//1. 创建流
	@Test
	public void test1(){
		//①通过 Collection 系列集合提供的方法 stream() 或  parallelStream()
		List<Employee> list = new ArrayList<>();
		Stream<Employee> stream1 = list.stream();
		Stream<Employee> stream2 = list.parallelStream();

		//②通过 Arrays 中的静态方法方法  stream() 创建数组流
		Integer[] num = new Integer[10];
		Stream<Integer> stream3 = Arrays.stream(num);

		//③通过 Stream 中的静态方法 of()
		Stream<Integer> stream4 = Stream.of(1,2,3,4,5,6,7);

		//④创建无限流
		//迭代
		Stream<Integer> stream5 = Stream.iterate(0, (x) -> x + 2).limit(10);
		stream5.forEach(System.out::println); //终止操作

		//生成
		Stream<Double> stream6 = Stream.generate(Math::random).limit(2);
		stream6.forEach(System.out::println);
	}

	/*
	 * 2. 中间操作
	 */

	/*
	  	筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
			new Employee(102, "李四", 58, 5999.55, Employee.Status.BUSY),
			new Employee(103, "王五", 16, 3333.33, Employee.Status.VOCATION),
			new Employee(104, "赵六", 8, 6666.66, Employee.Status.BUSY),
			new Employee(105, "田七", 98, 8888.88, Employee.Status.FREE),
			new Employee(103, "王五", 16, 3333.33, Employee.Status.VOCATION)
	);

	//内部迭代：迭代操作由 Stream API 完成
	@Test
	public void test2(){
		//中间操作：不会做任何处理
		Stream<Employee> stream = emps.stream()
									  .filter((e) -> {
										  System.out.println("测试惰性求值");
										  return e.getAge() <= 35;
									  });

		//终止操作：一次性执行全部功能，称为“惰性求值”
		stream.forEach(System.out::println);
	}

	//外部迭代
	@Test
	public void test3(){
		Iterator<Employee> it = emps.iterator();

		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	@Test
	public void test4(){
		emps.stream()
			.filter((e) -> {
				System.out.println("短路"); //&& ||
				return e.getAge() <= 35;
			})
			.limit(1)
			.forEach(System.out::println);
	}

	@Test
	public void test5(){
		emps.stream()
			.filter((e) -> e.getAge() <= 35)
			.skip(2)
			.forEach(System.out::println);
	}

	@Test
	public void test6(){
		emps.stream()
			.distinct()
			.forEach(System.out::println);
	}

	/*
  		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
	@Test
	public void test7(){
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "java8", "atguigu");

		list.stream()
			.map((x) -> x.toUpperCase())
			.forEach(System.out::println);

		emps.stream()
//			.map((e) -> e.getName())
			.map(Employee::getName)
			.forEach(System.out::println);
	}
	
	@Test
	public void test8(){
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "java8", "atguigu");
		
		/*Stream<Stream<Character>> stream = list.stream()
											   .map(TestStreamAPI1::filterCharacter);//{{a,a,a} {b,b,b} {c,c,c}}
		
		stream.forEach((s) -> {
			s.forEach((c) -> System.out.print(c + " "));
			System.out.println();
		});*/
		
		list.stream()
			.flatMap(TestStreamAPI1::filterCharacter)
			.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> chList = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			chList.add(ch);
		}
		
		return chList.stream();
	}
	
	/*
		排序
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
	@Test
	public void test9(){
		/*emps.stream()
			.map(Employee::getSalary)
			.sorted()
			.forEach(System.out::println);*/
		
		emps.stream()
			.map(Employee::getAge)
			.sorted(Integer::compare)
			.forEach(System.out::println);
	}
}
