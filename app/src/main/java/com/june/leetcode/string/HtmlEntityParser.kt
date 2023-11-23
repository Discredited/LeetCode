package com.june.leetcode.string

import java.lang.StringBuilder
import java.util.regex.Pattern

/**
 * Html实体解析
 *
 * 1410. HTML 实体解析器
 * https://leetcode.cn/problems/html-entity-parser/?envType=daily-question&envId=2023-11-23
 *
 * 2023/11/23
 * @author June
 */
class HtmlEntityParser {

    private val checkList = mutableListOf(
        Pair("&quot;", "\""),
        Pair("&apos;", "'"),
        Pair("&amp;", "&"),
        Pair("&gt;", ">"),
        Pair("&lt;", "<"),
        Pair("&frasl;", "/")
    )

    fun entityParser(text: String): String {
        // 官方解法
        // 大致思路就是查找字符串中的"&"，每找到一个"&"
        // 在checkList中遍历查找，当前"&"开始+对应长度的字符组合起来是否在checkList中
        // 如果在，则替换，不在就继续
        // 需要注意pos的移动长度
        // 执行时长为：320 ms
        if (text.isEmpty()) return ""
        val builder = StringBuilder()
        val length = text.length
        var pos = 0

        while (pos < length) {
            var isEntity = false
            if (text[pos] == '&') {
                for (entityChar in checkList) {
                    val e = entityChar.first
                    val c = entityChar.second
                    if (pos + e.length <= text.length && text.substring(pos, pos + e.length) == e) {
                        builder.append(c)
                        pos += e.length
                        isEntity = true
                        break
                    }
                }
            }
            if (!isEntity) {
                builder.append(text[pos++]);
                continue
            }
        }

        return builder.toString()
    }

    fun entityParser2(text: String): String {
        // 第一版，想到的是查找到以"&"开始，以";"结束的所有字符串，然而这样的方式
        // 没法处理"&&quot"这样的情况，故提交失败
        // val pattern = Pattern.compile("&(.*?);")

        // 第二版，根据规律，发现，"&"和";"中间，都是字母，所以限制了一下正则的内容
        // 虽然提交通过了，但是执行时长为：2708 ms
        // 而官方题解的时长为：37ms
        // emmmm 所以这个方式也不太行
        val pattern = Pattern.compile("&[a-zA-Z]+;")
        val matcher = pattern.matcher(text)

        var finalString = text
        while (matcher.find()) {
            println("当前匹配：${matcher.group(0)}")
            val findEncode = when (matcher.group(0)) {
                "&quot;" -> Pair("&quot;", "\"")
                "&apos;" -> Pair("&apos;", "'")
                "&amp;" -> Pair("&amp;", "&")
                "&gt;" -> Pair("&gt;", ">")
                "&lt;" -> Pair("&lt;", "<")
                "&frasl;" -> Pair("&frasl;", "/")
                else -> null
            }

            findEncode?.let { finalString = finalString.replace(it.first, it.second) }
        }
        return finalString
    }

    fun entityParser3(text: String): String {
        // 简单粗暴，但是需要注意，将("&amp;", "&")这一对放在最后，因为放在前面，"&amp;gt;"这个就通不过
        // 因为"&amp;"替换为"&"后，和"gt;"又组合成了"&gt;"！！！
        // 执行时长为：316 ms
        return text.replace("&quot;", "\"")
            .replace("&apos;", "'")
            .replace("&gt;", ">")
            .replace("&lt;", "<")
            .replace("&frasl;", "/")
            .replace("&amp;", "&")
    }
}

fun main() {
    val htmlEntityParser = HtmlEntityParser()
    println(htmlEntityParser.entityParser("&amp; is an HTML entity but &ambassador; is not."))
    println(htmlEntityParser.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"))
    println(htmlEntityParser.entityParser("&&gt;"))
}