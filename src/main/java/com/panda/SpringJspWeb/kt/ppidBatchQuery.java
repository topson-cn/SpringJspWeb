//package com.panda.SpringJspWeb.kt;
//
//import com.alibaba.fastjson.JSONObject
//import org.apache.commons.codec.digest.DigestUtils
//import org.apache.commons.lang3.StringUtils
//import passport.central.util.HttpClientUtil
//import passport.central.util.ThreadPoolUtil
//import java.io.*
//import java.util.concurrent.locks.ReentrantLock
//
///**
// * 〈一句话功能简述〉<br>
// * 根据ppid批量查用户名
// * @author 18048474
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//
//fun ppids() {
//    val desFileName = "C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppidrs.txt" // 结果写入文件
//    val sourceFileName = "C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppid.txt" //每个ppid是一行
//    val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(desFileName)))
//    val bufferedReader = BufferedReader(InputStreamReader(FileInputStream(sourceFileName)))
//    val ppids = bufferedReader.readLines()
//    val reentrantLock = ReentrantLock()
//    for (ppid in ppids){
//        ThreadPoolUtil.execute(Runnable {
//            val url = "http://api.passport.pptv.com/querypostid"
//            val param = hashMapOf<String, String>(Pair("postid", ppid), Pair("queryBy", "ppid"), Pair("sign", DigestUtils.md5Hex(ppid + "&ppid&k!s~g9h^g23q4g0p")))
//            val queryResult = HttpClientUtil.doPost(url, param, "utf-8")
//            val queryJson = when {
//                !StringUtils.isEmpty(queryResult) && !"500".equals(queryResult)
//                        && !"504".equals(queryResult) -> JSONObject.parseObject(queryResult)
//                else -> null
//            }
//            val username = queryJson?.getJSONObject("result")?.get("username")
//
//            writeResult(ppid + "," + username, bufferedWriter,reentrantLock)
//        })
//    }
//
//}
//
//fun writeResult(line : String,bufferedWriter : BufferedWriter, reentrantLock: ReentrantLock) {
//    reentrantLock.lock()
//    bufferedWriter.write(line)
//    bufferedWriter.newLine()
//    bufferedWriter.flush()
//    reentrantLock.unlock()
//}
//
//class ppidBatchQuery {
//    fun ppid(){
//        ppids()
//    }
//}
//
//fun main(args: Array<String>) {
//    ppids()
//}