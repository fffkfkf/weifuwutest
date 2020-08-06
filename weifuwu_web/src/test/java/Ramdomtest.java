
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import java.util.*;

/**
 * 对的
 *
 * @author
 * @date 2020/6/29
 */
public class Ramdomtest {

    public static void main(String args[]) {
int a,b,c;


        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 10; k++) {
                    test(i, j, k);
                }
            }
        }
    }

    private static void test(int i, int j, int k) {

    }


}





