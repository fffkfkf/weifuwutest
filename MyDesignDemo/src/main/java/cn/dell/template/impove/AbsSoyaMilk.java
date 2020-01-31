package cn.dell.template.impove;

/**
 * @author gmq
 * @date 2020/1/27
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public abstract class AbsSoyaMilk {

    final void make(){
        select();
        if(custwantcondiments()){
            addCondiments();
        }
        soak();
        beat();
    }

    //钩子方法，决定是否需要添加配料
    protected  boolean custwantcondiments(){
        return true;

    };

    private void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎  ");
    }

    private void soak() {
        System.out.println("第三步， 黄豆和配料开始浸泡， 需要3小时 ");
    }

    //添加不同的配料， 抽象方法, 子类具体实现
    protected abstract void addCondiments();

    private void select() {
        System.out.println("第一步：选择好的新鲜黄豆 ");
    }


}
