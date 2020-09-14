package com.june.leetcode.linear.stack

import com.june.leetcode.linear.TestInterface
import java.util.*

/**
 * 逆波兰表达式求值
 * 中缀表达式转逆波兰表达式
 * 前缀表达式、中缀表达式、后缀表达式(逆波兰表达式)
 * 2020年9月14日11:45:54
 *
 * 总结：
 * * 边界值的判断，输入数组是否为空，是否只有一个元素(经常犯的错误)
 * * 一开始没有想到再将result的值push在栈里面，而是去判断是否需要pop两次，写了很多无用代码
 * * first和second的pop顺序很重要，决定了运算的顺序
 *
 * * 计算器利用中缀表达式转后缀表达式，再利用后缀表达式求值
 */
class ReversePolishNotation : TestInterface {

    //利用数组模拟栈实现
    // 212ms  33.9M
    private fun evalRPNByArray(tokens: Array<String>): Int {
        //数组容量问题，操作数为原数组的一半+1
        val capacity = (tokens.size shr 1) + 1
        val array = Array(capacity) { 0 }
        var size = 0
        for (element in tokens) {
            when (element) {
                "+" -> array[size - 2] += array[--size]
                "-" -> array[size - 2] -= array[--size]
                "*" -> array[size - 2] *= array[--size]
                "/" -> array[size - 2] /= array[--size]
                else -> array[size++] = element.toInt()
            }
        }
        return array[0]
    }

    //利用栈实现
    // 320 ms  35.4 MB
    private fun evalRPN(tokens: Array<String>): Int {
        if (tokens.isEmpty()) {
            return 0
        }
        if (tokens.size == 1) {
            return tokens[0].toInt()
        }
        var result = 0
        val stack = Stack<Int>()
        tokens.forEach {
            //循环遍历的时候只会将数值push到栈中
            if (it == "+" || it == "-" || it == "*" || it == "/") {
                //取pop顺序决定了的运算的顺序
                val second = stack.pop()
                val first = stack.pop()

                when (it) {
                    "+" -> result = first + second
                    "-" -> result = first - second
                    "*" -> result = first * second
                    "/" -> result = first / second
                }
                //每一次计算结果也需要push到栈中，方便下一次计算
                stack.push(result)
            } else {
                stack.push(it.toInt())
            }
        }

        return result
    }

    //中缀表达式转逆波兰表达式
    private fun toRPN(expression: String): Array<String> {
        if (expression.isEmpty() || expression.isBlank()) {
            return arrayOf()
        }
        //9+(3-1)*3+10/2
        val scanList = scanExpression(expression)

        val numberList = mutableListOf<String>()
        val operatorStack = Stack<String>()
        for (element in scanList) {
            when (element) {
                "(" -> {
                    //左括号直接入栈
                    operatorStack.push(element)
                }
                "+", "-", "*", "/" -> {
                    //操作符
                    if (operatorStack.isEmpty() ||
                        "(" == operatorStack.peek() ||
                        operatorPriority(element) > operatorPriority(operatorStack.peek())
                    ) {
                        operatorStack.push(element)
                    } else {
                        while (!operatorStack.isEmpty() && "(" != operatorStack.peek()) {
                            if (operatorPriority(element) <= operatorPriority(operatorStack.peek())) {
                                numberList.add(operatorStack.pop())
                            }
                        }
                        operatorStack.push(element)
                    }
                }
                ")" -> {
                    while (!operatorStack.isEmpty()) {
                        if ("(" == operatorStack.peek()) {
                            operatorStack.pop()
                            break
                        } else {
                            numberList.add(operatorStack.pop())
                        }
                    }
                }
                else -> numberList.add(element)
            }
        }

        while (operatorStack.isNotEmpty()) {
            numberList.add(operatorStack.pop())
        }

        return numberList.toTypedArray()
    }

    //将表达式字符串扫描为集合
    private fun scanExpression(expression: String): MutableList<String> {
        //扫描表达式
        val scanList = mutableListOf<String>()
        val builder = StringBuilder()
        expression.forEachIndexed { index, c ->
            when (c) {
                in '0'..'9' -> {
                    builder.append(c)
                    if (index == expression.length - 1) {
                        scanList.add(builder.toString())
                    }
                }
                '(', ')', '+', '-', '*', '/' -> {
                    if (builder.isNotEmpty()) {
                        scanList.add(builder.toString())
                        builder.clear()
                    }
                    scanList.add(c.toString())
                }
            }
        }
        print("[")
        scanList.forEachIndexed { index, s ->
            if (index > 0) {
                print(", ")
            }
            print(s)
        }
        println("]")
        return scanList
    }

    private fun operatorPriority(operator: String): Int {
        return if ("*" == operator || "/" == operator) {
            1
        } else if ("+" == operator || "-" == operator) {
            0
        } else {
            -1
        }
    }

    ////////////////////  测试方法 Begin  ////////////////////
    private fun evalRPNText() {
        val array1 = arrayOf(
            "2", "1", "+", "3", "*"
        )
        val array2 = arrayOf(
            "4", "13", "5", "/", "+"
        )
        val array3 = arrayOf(
            "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        )
        val array4 = arrayOf(
            "3", "11", "+", "5", "-"
        )
        val array5 = arrayOf(
            "18"
        )

        println("correct:9    result:${evalRPNByArray(array1)}")
        println("correct:6    result:${evalRPNByArray(array2)}")
        println("correct:22    result:${evalRPNByArray(array3)}")
        println("correct:9    result:${evalRPNByArray(array4)}")
        println("correct:18    result:${evalRPNByArray(array5)}")
    }

    private fun toRPNTest() {
        val expression1 = "1"
        val expression2 = "1+2"
        val expression3 = "1+2*3/4"
        val expression4 = "9+(3-1)*3+10/2"
        //println("correct:[1]    result:${printArray(toRPN(expression1))}")
        //println("correct:[1,2,+]    result:${printArray(toRPN(expression2))}")
        //println("correct:[1,2,3,*,4,/,+]    result:${printArray(toRPN(expression3))}")
        println("correct:[9,3,1,-,3,*,+,10,2,/,+]    result:${printArray(toRPN(expression4))}")
    }
    ////////////////////  测试方法 End  ////////////////////

    private fun printArray(array: Array<String>): String {
        if (array.isEmpty()) {
            return "[]"
        }

        val builder = StringBuilder()
        builder.append("[")
        array.forEachIndexed { index, s ->
            if (index > 0) {
                builder.append(",")
            }
            builder.append(s)
        }
        builder.append("]")
        return builder.toString()
    }

    override fun test() {
        //evalRPNText()

        toRPNTest()
    }
}