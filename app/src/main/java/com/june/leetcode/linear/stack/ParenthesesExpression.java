package com.june.leetcode.linear.stack;

import java.util.Stack;

/**
 * 带括号的表达式求值
 * 该题不属于LeetCode 但是原理和逆波兰式求值差不多
 * 2021年4月1日15:55:40
 */
class ParenthesesExpression {

    public static void main(String[] args) {
        System.out.println(evaluation("1+(3-2)*5"));
        System.out.println(evaluation("3*(4/2)"));
        System.out.println(evaluation("(1+3-2)*5"));
    }

    private static int evaluation(String expression) {
        if (null == expression || expression.isEmpty()) return 0;
        // 还需要校验表达式的合法性
        // 1+2* 这种以符号结尾的需要过滤到最后的符号  保证数字或者)结尾

        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                // 反括号需要立即执行，直到 ( 出栈
                char operator = operatorStack.pop();
                while (operator != '(') {
                    int second = numberStack.pop();
                    int first = numberStack.pop();
                    System.out.println("执行括号内的运算:" + first + operator + second);
                    numberStack.push(operate(first, second, operator));
                    operator = operatorStack.pop();
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                System.out.println("将操作符" + c + "入栈");
                operatorStack.push(c);
            } else {
                // 将操作数push入栈
                System.out.println("将操作数" + Integer.parseInt(c + "") + "入栈");
                numberStack.push(Integer.parseInt(c + ""));

                if (!operatorStack.isEmpty()) {
                    char operator = operatorStack.peek();
                    if (operator == '*' || operator == '/') {
                        //立即执行运算
                        int second = numberStack.pop();
                        int first = numberStack.pop();
                        operator = operatorStack.pop();
                        System.out.println("执行优先级高的运算:" + first + operator + second);
                        numberStack.push(operate(first, second, operator));
                    }
                }
            }
        }

        if (!operatorStack.isEmpty()) {
            //立即执行运算
            int second = numberStack.pop();
            int first = numberStack.pop();
            char operator = operatorStack.pop();
            System.out.println("执行最后的运算:" + first + operator + second);
            numberStack.push(operate(first, second, operator));
        }

        return numberStack.pop();

    }

    private static int operate(int first, int second, char operate) {
        int result = 0;
        switch (operate) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
        }
        return result;
    }
}
