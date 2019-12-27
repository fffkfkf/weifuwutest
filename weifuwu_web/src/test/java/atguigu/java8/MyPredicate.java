package atguigu.java8;

@FunctionalInterface
public interface MyPredicate<T> {
	
	public boolean apply(T t);

}
