 package com.panda.SpringJspWeb.kt

import com.alibaba.fastjson.JSONObject
import com.google.common.collect.Sets
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.lang3.StringUtils
import java.io.*
import java.util.stream.Collectors

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun getUserName() : List<String> {
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\username\\usernames.txt")))
    val lines = reader.lines().collect(Collectors.toList())
    for (i in lines.withIndex()){
        if (lines[i.index].length < 10)
            lines[i.index] = "0".plus(lines[i.index])
    }
    return lines
}

fun queryInfoByUserName(usernames : List<String>){
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\username\\usernames_rs.txt")))
    usernames.stream().forEach { u ->
        val url = "http://api.passport.pptv.com/account/queryPhoneNumber?username=".plus(u).plus("&sign=").plus(DigestUtils.md5Hex(u + "99bdc3a2972142708eef47ebff2fc65e"))
        val get = HttpUtils.get(url)
        val phone = JSONObject.parseObject(get)?.get("phone")
        writer.write(u + "," + phone)
        writer.newLine()
        writer.flush()
    }
}

fun findQQuser(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union.txt"),"utf-8"))
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union_all_rs.txt"),"utf-8"))
    reader.lines().forEach {
        line ->
        var lineArr = line.split(",")
        var id = lineArr[0]
        var username = lineArr[1]
//        if (username.endsWith("@qq")){
//            writer.write(id.plus(",".plus(username)))
//            writer.newLine()
//            writer.flush()
//        }
        writer.write(id.plus(",".plus(username)))
        writer.newLine()
        writer.flush()
    }
}

fun writeUserName(usernames: List<String>){
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\username\\usernames_rs.txt")))
    usernames.stream().forEach {
        username ->
        val url = "http://api.passport.pptv.com/querypostid?postid=".plus(username).plus("&queryBy=username&sign=").plus(DigestUtils.md5Hex(username + "&username&k!s~g9h^g23q4g0p"))
        val get = HttpUtils.get(url)
        val snid = JSONObject.parseObject(get)?.getJSONObject("result")?.getString("snid")
        writer.write(username + "," + snid)
        writer.newLine()
        writer.flush()
    }
}

fun geneUseName(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\mmmdwadwam.txt")))
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\mmmdwadwam_1112.txt")))
    writer.write("(")
    reader.lines().forEach {
        username ->
        writer.write("'".plus(username).plus("'").plus(","))
    }
    writer.write(")")
    writer.newLine()
    writer.flush()
    println(reader.lines().count())
}

fun fun1(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union_all_query_1.txt")))
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union_all_query_1_rs.txt")))

    reader.lines().forEach {
        line ->
        var name = line.split(",")[2]
        var snid = line.split(",")[0]
        if (name.endsWith("@qq")){
            writer.write(snid.plus(",".plus(name)))
            writer.newLine()
            writer.flush()
        }
    }
}

fun findUnUpdate(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union_all_rs.txt")))
    val reader1 = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\union_all_rs_1.txt")))
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\mmmdwadwam.txt")))
    val collect = reader1.lines().collect(Collectors.toList())
    val newHashSet = Sets.newHashSet<String>()
    reader.lines().forEach {
        line ->
        if (!collect.contains(line))
            newHashSet.add(line)
    }
    newHashSet.forEach {
        v ->
        writer.write(v)
        writer.newLine()
        writer.flush()
    }
    println(1)

}

 fun clearCache() {
     val readLine = IoUtils.readLine("C:\\Users\\toyz\\Desktop\\kt\\usernames.txt")
     val fails = ArrayList<String>()
     readLine.forEach {
         try {
             val url = "http://admin.vip.synacast.com/clearVipInfoCache?vipType=vip&userName=" + it
             val get = HttpUtils.get(url)
             if (StringUtils.isNoneEmpty(get)
                     && get.contains("errorCode")) {
                 val code = JSONObject.parseObject(get).getString("errorCode")
                 if ("0".equals(code)) {
                     println(it + " clear")
                 } else {
                     fails.add(it)
                 }
             } else {
                 fails.add(it)
             }
         } catch (e: Exception) {
             fails.add(it)
         }

     }
     IoUtils.write(fails, "C:\\Users\\toyz\\Desktop\\kt\\usernames_fail.txt")
 }

fun main(args: Array<String>) {
//    queryInfoByUserName(getUserName())
//    writeUserName(getUserName())
//    findQQuser()
//    geneUseName()
//    fun1()
//    findUnUpdate()
    clearCache()
}