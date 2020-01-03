package com.panda.SpringJspWeb.kt

import java.io.*
import java.util.stream.Collectors

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
class IoUtils{


    companion object {
        /**
         * 读行转为list
         */
        fun readLine(fileName:String) : List<String>{
            val reader = BufferedReader(InputStreamReader(FileInputStream(fileName)))
            reader.use { r ->
                return r.lines().collect(Collectors.toList())
            }
        }


        /**
         * 写数据
         */
        fun write(data:String,fileName:String){
            val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
            bufferedWriter.use { w ->
                w.write(data)
                w.flush()
            }
        }

        /**
         * 写数据
         */
        fun write(data:List<String>,fileName:String,isAdd :Boolean){
            val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
            bufferedWriter.use { w ->
                w.write("select username,snid from passport_dbs_sso_sn_pp_bound where username in (")
                data.forEach {  it ->
                    if (isAdd) w.write("'")
                    w.write(it)
                    if (isAdd) w.write("'")
                    w.write(",")
                    w.flush()}
                w.write(")")
            }
        }

        /**
         * 写数据
         */
        fun writeSnPPBound(data:List<String>,fileName:String){
            val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
            val indexedValue = (data.size % 5000) -1
            bufferedWriter.use { w ->
                for (i in 0..indexedValue){
                    if (i == indexedValue){
                        write(data.subList(5000*i,data.size),fileName+"_"+indexedValue,true)
                    }
                    write(data.subList(5000*i,5000*(i+1)),fileName+"_"+indexedValue,true)
                }
            }
        }

        /**
         * 写数据
         */
        fun write(data:List<String>,fileName:String){
            val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(fileName)))
            bufferedWriter.use { w ->
                data.forEach {  it ->
                    synchronized(this){
                        w.write(it)
                        w.newLine()
                        w.flush()}
                    }

            }
        }
    }

}