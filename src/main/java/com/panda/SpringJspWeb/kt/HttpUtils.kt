package com.panda.SpringJspWeb.kt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
class HttpUtils {

    companion object {
        fun get(baseUrl:String) : String {
            var url = URL(baseUrl)
            var httpConnect = url.openConnection() as HttpURLConnection

            httpConnect.setRequestProperty("JSESSIONID","36477CD8DF55814EFADDCACA12D933A1")
            httpConnect.connectTimeout = 5 * 1000  // 设置连接超时时间
            httpConnect.readTimeout = 5 * 1000  //设置从主机读取数据超时
            httpConnect.doOutput = true
            httpConnect.doInput = true
            httpConnect.useCaches = false
            httpConnect.requestMethod = "POST" // 设置为Post请求
            httpConnect.connect() // 开始连接

            var inputStream = httpConnect.inputStream
            var reader = BufferedReader(InputStreamReader(inputStream))
            var strBuilder = StringBuilder()
            reader.forEachLine {
                strBuilder.append(it)
            }
            inputStream.close()
            reader.close()
            return strBuilder.toString()
        }
    }


}