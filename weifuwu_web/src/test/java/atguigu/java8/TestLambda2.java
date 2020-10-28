package atguigu.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/*
 * 一、Lambda 基础语法：Java8 中引入了一个新的操作符 "->", 该操作符称为箭头操作符或Lambda 操作符
 * 				  Lambda 操作符将 Lambda 表达式拆分成两部分：
 * 
 * 左侧：Lambda 所需的参数列表
 * 右侧：Lambda 所需的功能实现，即 Lambda 体
 * 
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * 语法格式二：有一个参数，无返回值，并且 Lambda 体只有一条语句
 * 		(args) -> System.out.println(args);
 * 
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		args -> System.out.println(args);
 * 
 * 语法格式四：有两个参数，有返回值，并且 Lambda 体有多条语句
 * 
 * 		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口！");
 *			return Integer.compare(x, y);
 *		};
 * 
 * 语法格式五：有多个参数，有返回值，并且 Lambda 体只有一条语句, "return 与 大括号可以省略不写"
 * 		(x, y) -> Integer.compare(x, y);
 * 
 * 语法格式六：Lambda 的参数列表的数据类型可以省略不写，因为 Java 编译器可以通过上下文，推断出数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二、Lambda 表达式需要"函数式接口"的支持
 * 
 * 函数式接口:若接口中只有一个抽象方法，该接口称为“函数式接口”。 可以使用注解 @FunctionalInterface 修饰
 * 			可以检查是否是函数式接口
 */
public class TestLambda2 {
	
	@Test
	public void test1(){
		//原来:
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
		r.run();
		
		System.out.println("-------------------------------");
		//现在
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		r1.run();
	}

	//一个参数
	@Test
	public void test2(){
		Consumer<String> con = args -> System.out.println(args);
		con.accept("我大呃呃呃呃威武！");
	}

	//两个参数
	@Test
	public void test3(){
		Comparator<Integer> com = (x, y) -> {
			System.out.println("函数式接口！");
			return Integer.compare(x, y);
		};



	}
	
	@Test
	public void test4(){
		Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
	}
	
	@Test
	public void test5(){
		String[] strs = {"aaa", "bbb", "ccc"};
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());
	}
	
	public void show(Map<String, Integer> map){
		
	}
	
	//需求：对一个整数进行运算
	@Test
	public void test6(){
		op(100, (n) -> n * n);
		
		op(100, (n) -> n + 100);
	}
	
	public void op(Integer num, MyFun mf){
		System.out.println(mf.getValue(num));
	}
}
