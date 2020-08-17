import java.util.*;

/**
 * @author gmq
 * @date 2020/8/16
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Student {
    private String name;
    private  int age;
    private  String QQ;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(QQ, student.QQ);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, QQ);
    }
*/
}
