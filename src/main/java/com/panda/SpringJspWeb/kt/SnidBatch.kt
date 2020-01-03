package com.panda.SpringJspWeb.kt

import com.alibaba.fastjson.JSONObject
import com.google.common.base.Joiner
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.lang3.StringUtils
import java.io.*
import java.util.concurrent.locks.ReentrantLock
import java.util.stream.Collectors

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun getSnids() : List<String> {
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\snids.txt")))
    val lines = reader.lines().collect(Collectors.toList())
    for (i in lines.withIndex()){
        if (lines[i.index].length < 10)
            lines[i.index] = "0".plus(lines[i.index])
    }
    return lines
}

fun writeSnids(snids : List<String>){
    if (snids is ArrayList){
        for (i in snids.withIndex()){
            snids[i.index] = "'".plus(snids[i.index]).plus("'")
        }
        val join = StringUtils.join(snids, ",")
        val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\super_snids_rs.txt")))
        writer.write(join)
    }
}

 fun writeSnids1(snids : List<String>){
     snids.stream().forEach {
         snid ->
         val url = "http://api.passport.pptv.com/querypostid"
         val param = hashMapOf<String, String>(Pair("postid", "snid"), Pair("queryBy", "snid"), Pair("sign", DigestUtils.md5Hex(snid + "&snid&k!s~g9h^g23q4g0p")))
     }
 }

fun required(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\super_snids_rs.txt")))
    val reader1 = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\super_snids_rs1.txt")))
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\super_snids_rs123.txt")))
    val lines = reader.lines().collect(Collectors.toList())
    val lock = ReentrantLock()
    reader1.lines().forEach { snidline ->
        val snid = snidline.split(",")[0]
        val get = lines.stream().filter { v -> v.split(",")[0].equals(snid) }.findFirst().orElse(null)
        if (StringUtils.isNotEmpty(get))
            writer.write(get)
        else
            writer.write(snidline)
        ThreadPoolUtil.execute(Runnable {
            lock.lock()
            writer.newLine()
            writer.flush()
            lock.unlock()
        })
    }
}

fun result(){
    val readLine = IoUtils.readLine("C:\\Users\\toyz\\Desktop\\工作文档\\super_snids_rs.txt")
    val  map =  HashMap<String,String> ()
    readLine.forEach { line ->
        val split = line.split(",")
        map.put(split[0], split[1])
    }
    val readLine1 = IoUtils.readLine("C:\\Users\\toyz\\Desktop\\工作文档\\snids.txt")
    var rs = ArrayList<String>()
    readLine1.forEach { line ->
        val username = map.get(line)
        rs.add(line + "," + username)
    }

    IoUtils.write(rs, "C:\\Users\\toyz\\Desktop\\工作文档\\snids_rs.txt")
    println(1)
}

fun result1(){
    val readLine1 = IoUtils.readLine("C:\\Users\\toyz\\Desktop\\工作文档\\snids.txt")
    var rs = ArrayList<String>()
    readLine1.forEach { line ->
        val split = line.split(",")
        if ("null".equals(split[1])){
            try {
                var snid = split[0]
                var url = "https://api.passport.pptv.com/registerForPointsBalance?timestamp=1556000409633&appplt=sports-activity&channel=sports-activity" + "&snId="+snid+"&sign="+ DigestUtils.md5Hex(Joiner.on("&").join(snid, "1556000409633", "8eef47ebff2fc65e99bdc3a297214270"))
                val get = HttpUtils.get(url)
                val jsonObject = JSONObject.parseObject(get)
                var username = jsonObject.get("username")
                rs.add(snid+","+username)
            } catch (e : Exception){
                rs.add(line)
            }
        } else {
            rs.add(line)
        }
    }

    IoUtils.write(rs, "C:\\Users\\toyz\\Desktop\\工作文档\\snids_rs.txt")
    println(1)
}

fun re(){
    var snid = "7211191628"
    var url = "https://api.passport.pptv.com/registerForPointsBalance?timestamp=1556000409633&appplt=sports-activity&channel=sports-activity" + "&snId="+snid+"&sign="+ DigestUtils.md5Hex(Joiner.on("&").join(snid, "1556000409633", "8eef47ebff2fc65e99bdc3a297214270"))
    val get = HttpUtils.get(url)
    val jsonObject = JSONObject.parseObject(get)
    var username = jsonObject.get("username")
}

fun main(args: Array<String>) {
//    writeSnids(getSnids())
//    required()
    re()
}