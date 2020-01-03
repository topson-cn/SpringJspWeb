package com.panda.SpringJspWeb.kt

import com.alibaba.fastjson.JSONObject
import com.google.common.collect.Lists
import java.io.*

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
 fun getMobiles(url : String) : List<String> {
    val reader = BufferedReader(InputStreamReader(FileInputStream(url)))
    val newArrayList = Lists.newArrayList<String>()
    for (line in reader.lines()) {
        val source = JSONObject.parseObject(line)?.getString("_source")
        val content = JSONObject.parseObject(source)?.getString("content")
        val substring = content?.substring(content.length-12, content.length-1)
        newArrayList.add(substring)
    }
    return newArrayList
}

fun readMobiles() {
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\query02_rs.txt")))
    reader.readLines().forEach {
        line ->
        val url = ""

        val get = HttpUtils.get(url)
    }
}

fun main(args: Array<String>) {
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\query02_rs.txt")))
    val mobiles1 = getMobiles("C:\\Users\\toyz\\Desktop\\工作文档\\query01.josn")
    val mobiles2 = getMobiles("C:\\Users\\toyz\\Desktop\\工作文档\\query02.josn")
    val mobiles3 = getMobiles("C:\\Users\\toyz\\Desktop\\工作文档\\query31.josn")
    for (line in mobiles1) {
        writer.write(line)
        writer.newLine()
        writer.flush()
    }
    for (line in mobiles2) {
        writer.write(line)
        writer.newLine()
        writer.flush()
    }
    for (line in mobiles3) {
        writer.write(line)
        writer.newLine()
        writer.flush()
    }
}