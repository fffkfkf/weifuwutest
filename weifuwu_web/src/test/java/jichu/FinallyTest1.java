package jichu;

/**
 * @author gmq
 * @Description
 * @date 2020/12/17
 */
public class FinallyTest1 {

    public static void main(String[] args) {
        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
            return b;
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
                b++;
                System.out.println("---, b = " + b);
            }
        }
        //return b;
    }

}
