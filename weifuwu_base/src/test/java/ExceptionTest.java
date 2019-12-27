import com.dell.base.BaseApplication;
import com.dell.base.Service.QueryCrudImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author gmq
 * @date 2019/12/22
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class ExceptionTest {
    @Resource
    private QueryCrudImpl queryCrud;

    @Test
   public void test1(){

        try {
            queryCrud.getFsmNumById();
        }catch (Exception e){

            String message = e.getMessage();
//
            System.out.println("message:"+message);
        }


        System.out.println(1111);

    }



}
