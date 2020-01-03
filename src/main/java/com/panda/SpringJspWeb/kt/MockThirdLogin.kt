package com.panda.SpringJspWeb.kt

import java.io.*
import java.util.*

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun geneSuningCode(){
    val fileName = "C:\\Users\\toyz\\Desktop\\工作文档\\mockSuningCodes.txt"
    val fileName1 = "C:\\Users\\toyz\\Desktop\\工作文档\\mockSuningPhones.txt"
    val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
    val bufferedWriter1 = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName1)))
    for (i in 1..300000){
        val phone = StringBuffer("199").append(Random().nextInt(89999999) + 10000000).toString();
        val code = StringBuffer("mock").append("_").append(phone).append("_").append(UUID.randomUUID().toString().replace("-","").substring(0, 20)).toString()
        bufferedWriter.write(code)
        bufferedWriter.newLine()
        bufferedWriter.flush()
        bufferedWriter1.write(phone)
        bufferedWriter1.newLine()
        bufferedWriter1.flush()
    }
    bufferedWriter.close()
    bufferedWriter1.close()
}

fun regeneSuningCode(){
    val fileName = "C:\\Users\\toyz\\Desktop\\工作文档\\mockReSuningCodes.txt"
    val fileName1 = "C:\\Users\\toyz\\Desktop\\工作文档\\mockSuningPhones.txt"
    val bufferedReader = BufferedReader(InputStreamReader(FileInputStream(fileName1)))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
    bufferedReader.lines().forEach {
        phone ->
        val code = StringBuffer("mock").append("_").append(phone).append("_").append(UUID.randomUUID().toString().replace("-","").substring(0, 20)).toString()
        bufferedWriter.write(code)
        bufferedWriter.newLine()
        bufferedWriter.flush()
    }
    bufferedWriter.close()
}

fun main(args: Array<String>) {
    geneSuningCode()
//    regeneSuningCode()
}