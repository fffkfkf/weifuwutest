package atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Java8 内置的四大核心函数式接口：
 * 
 * 	Consumer<T> : 消费型接口
 * 		void accpet(T t);
 * 
 *  Supplier<T> : 供给型接口
 *  	T get();
 * 
 *  Function<T, R> : 函数型接口
 *  	R apply(T t);
 *  
 *  Predicate<T> : 断言型接口
 *  	boolean test(T t);
 */
public class TestLambda3 {
	
	@Test
	public void test4(){
		List<String> list = Arrays.asList("java8", "lambda", "atguigu", "ab", "0519");
		
		Predicate<String> pre = (str) -> str.length() > 3;
		
		for (String str : list) {
			if(pre.test(str)){
				System.out.println(str);
			}
		}
	}
	
	@Test
	public void test3(){
		Function<Integer, Double> fun = (a) -> Math.sqrt(a);
		Double d = fun.apply(100);
		System.out.println(d);
	}
	
	@Test
	public void test2(){
		List<Integer> list = numHandler(() -> (int)(Math.random() * 100), 10);
		
		for (Integer n : list) {
			System.out.println(n);
		}
	}
	
	public List<Integer> numHandler(Supplier<Integer> sup, int num){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			list.add(sup.get());
		}
		
		return list;
	}
	
	@Test
	public void test1(){
		Consumer<String> con = (str) -> System.out.println(str.length());
		con.accept("我大尚硅谷威武!");
	}
	
}
