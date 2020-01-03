package com.panda.SpringJspWeb.kt

import com.alibaba.fastjson.JSONObject
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.lang3.StringUtils
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun readPpids(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppid.txt")))
    val lines = reader.readLine()?.split(",")
    val listOf = ArrayList<String>()
    lines!!.mapTo(listOf) { "'".plus(it).plus("'") }
    println(listOf.joinToString(","))
}

fun writePpids(){
    val reader = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppid_hive_rs.txt")))
    val map = HashMap<String, String>()
    reader.lines().forEach { line -> map.put(line.split(",")[0],line) }
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppid_rs1.txt")))
    val reader1 = BufferedReader(InputStreamReader(FileInputStream("C:\\Users\\toyz\\Desktop\\工作文档\\ppid跑批\\ppid.txt")))
    val lines = reader1.readLine()?.split(",")
    for (line in lines!!){
        if (map.containsKey(line)){
            writer.write(map[line])
            writer.newLine()
            writer.flush()
        } else {
            val url = "http://api.passport.pptv.com/querypostid?postid=".plus(line).plus("&queryBy=ppid&sign=").plus(DigestUtils.md5Hex(line + "&ppid&k!s~g9h^g23q4g0p"))
            val get = HttpUtils.get(url)
            val username = JSONObject.parseObject(get)?.getJSONObject("result")?.getString("username")
            val snid = JSONObject.parseObject(get)?.getJSONObject("result")?.getString("snid")
            writer.write(StringUtils.join(arrayOf(line,username,snid),","))
            writer.newLine()
            writer.flush()
        }
    }
}




fun main(args: Array<String>) {
    writePpids()
}