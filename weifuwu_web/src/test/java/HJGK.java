

import org.apache.commons.collections.ArrayStack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 请用java或c/c++语言编程判断一个包含{}()[]的表达式括号是否合法，合法返回true，不合法返回false。
 * 合法标准：
 * （1）左括号必须要有相同类型的右括号闭合，如‘(’必须要有‘)’闭合；
 * （2）左括号必须以正确的顺序闭合，如‘([’必须要有‘])’闭合。
 * 输入描述
 * 输入一个包含{}()[]的表达式
 *  [(3+4)*5]/2
 * @author gmq
 * @date 2020/7/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class HJGK {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        Boolean bool = isMatch(str);
        System.out.println(bool);
    }

    public static Boolean isMatch(String str) {
        Stack<Character> expr = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                expr.push(')');
            }
            if (c == '[') {
                expr.push(']');
            }
            if (c == '{') {
                expr.push('}');
            }
            if (c == ')' || c == ']' || c == '}') {
                if (expr.size() == 0) {
                    return false;
                }
                if (expr.pop() != c) {
                    return false;
                }
            }
        }
        if (expr.size() != 0) {
            return false;
        }
        return true;
    }

}
