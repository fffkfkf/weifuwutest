package atguigu.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

/**
 * @author gmq
 * @Description
 * @date 2020/9/22
 */
public class Car {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided== " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the=== " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired=== " + this.toString());
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    @Test
    public void test1() {

        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
        System.out.println(Arrays.toString(cars.toArray()));
        System.out.println("---------");

//静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach( Car::collide );
        System.out.println("----1111-----");

       // 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach( Car::repair );

        System.out.println("----2222-----");
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        System.out.println("----333-----");
        cars.forEach( System.out::println);

        System.out.println("----444-----");
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        //打印每一个元素
        names.forEach(System.out::println);


    }



}
