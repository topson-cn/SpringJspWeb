package com.panda.SpringJspWeb.kt

import com.google.common.base.Joiner
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
fun main(args: Array<String>) {
    geneSnPpBind()
}

fun geneSnPpBind(){
    var source = "D:\\project\\pptv\\跑批数据\\SNID\\result7_20190807.txt"
    var sql = "D:\\project\\pptv\\跑批数据\\SNID\\201908071_sql_8.txt"
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream(sql)))

    IoUtils.readLine(source).forEach {
        val split = it.split(",")
        var username = ""
        var snid = ""
        var mobile = ""
        when{
            split.size > 2 -> {
                username = split[0]
                snid = split[1]
                mobile = split[2]
            }
            split.size > 1 -> {
                username = split[0]
                snid = split[1]
            }
            split.isNotEmpty() -> username = split[0]
        }
        val sql = "insert into data_bind_sn_new (username, snid, mobile) values ('".plus(Joiner.on("','").join(username,snid,mobile)).plus("');")
        writer.write(sql)
        writer.newLine()
        writer.flush()
    }
}