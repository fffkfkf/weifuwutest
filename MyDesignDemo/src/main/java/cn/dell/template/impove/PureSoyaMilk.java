package cn.dell.template.impove;

/**
 * @author gmq
 * @date 2020/1/27
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class PureSoyaMilk extends AbsSoyaMilk {
    @Override
    protected void addCondiments() {
        //空实现
    }

    @Override
    protected boolean custwantcondiments() {
        return false;

    }

    ;

}
