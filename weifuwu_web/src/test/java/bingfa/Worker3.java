package bingfa;

import java.util.concurrent.Callable;

/**
 * @author gmq
 * @Description
 * @date 2020/11/9
 */
public class Worker3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        int a=1;
        int b=2;
        System.out.println("call,a+b:"+(a+b));
        return "执行结果"+(a+b);
    }





}
