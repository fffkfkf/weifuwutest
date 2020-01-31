package cn.dell.template;

/**
 * @author gmq
 * @date 2020/1/27
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public abstract class AbsSoyaMilk {

    final void make(){
        select();
        addCondiments();
        soak();
        beat();

    }

    private void select() {
        System.out.println("第一步：选择好的新鲜黄豆");
    }
    //添加不同的配料， 抽象方法, 子类具体实现
    abstract  void addCondiments() ;

    private void soak() {
        System.out.println("第三步， 黄豆和配料开始浸泡");
    }
    private void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎  ");
    }

}
