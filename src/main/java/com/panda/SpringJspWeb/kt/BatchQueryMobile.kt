package com.panda.SpringJspWeb.kt

import com.alibaba.fastjson.JSONObject
import com.panda.SpringJspWeb.util.Des3Util
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//fun main(args: Array<String>) {
//    val result = arrayListOf<String>()
//    val arrayList = ArrayList<String>(10)
//    var item = "C:\\Users\\toyz\\Desktop\\kt\\购买过英超、德甲、法甲、意甲任意赛季包的用户.txt"
//    var item1 = "C:\\Users\\toyz\\Desktop\\kt\\购买过英超、德甲、法甲、意甲任意赛季包的用户_rs.txt"
//    IoUtils.readLine(item).forEach {
//        if (arrayList.size < 10){
//            arrayList.add(it)
//        } else{
//            collect(Joiner.on(",").join(arrayList),result)
//            arrayList.clear()
//        }
//    }
//    IoUtils.write(result,item1)
//}

fun collect(names : String, result : ArrayList<String>){
    var name = URLEncoder.encode(names,"utf-8")
    var sign = URLEncoder.encode(Des3Util.encode("15B9FDAEDA40F86BF71C73292516924A294FC8BA31B6E9EA","70706C6976656F6B","names=".plus(names).plus("&index=01")),"utf-8")
    var url = "https://api.passport.pptv.com/batchuserprofile?names=".plus(name).plus("&index=01&sign=") + sign
    val get = HttpUtils.get(url)
    JSONObject.parseObject(get).getJSONArray("result").forEach {
        var d = it as JSONObject
        val phoneNumber = d.getString("phoneNumber")
        val username = URLDecoder.decode(d.getString("username"),"utf-8")
        result.add(username.plus(",").plus(phoneNumber))
    }
}


fun main(args: Array<String>) {
    var item = "C:\\Users\\toyz\\Desktop\\kt\\item.txt"
    var item1 = "C:\\Users\\toyz\\Desktop\\kt\\item1.txt"
    var item2 = "C:\\Users\\toyz\\Desktop\\kt\\item2.txt"
    var item3 = "C:\\Users\\toyz\\Desktop\\kt\\购买过英超、德甲、法甲、意甲任意赛季包的用户_rs_3.txt"
//    geneSql(item,item1)
//    compare(item,item2,item3)

    var rh = "C:\\Users\\toyz\\Desktop\\kt\\rh.txt"
    var rh1 = "C:\\Users\\toyz\\Desktop\\kt\\rh1.txt"
    rongheSql(rh,rh1)
}

/**
 * 生成sql语句
 */
fun geneSql(item:String,item1:String){

    IoUtils.write(IoUtils.readLine(item),item1,true)
}

fun compare(item:String,item2:String,item3:String){
    val arrayList = ArrayList<String>()
    val hashMap = HashMap<String, String>()
    IoUtils.readLine(item2).forEach {
        val split = it.split(",")
        if (split.size < 2){
            println(1)
        }
        hashMap.put(split[0],split[1])
    }
    IoUtils.readLine(item).forEach {
        if (hashMap.containsKey(it)){
            arrayList.add(it.plus(",").plus(hashMap[it]))
        } else {
            arrayList.add(it.plus(",null"))
        }
    }
    IoUtils.write(arrayList,item3)
}

fun rongheSql(rh:String,rh1:String){
    val arrayList = ArrayList<String>()
    IoUtils.readLine(rh).forEach {
        if ("null".equals(it.split(",")[1])){
            arrayList.add(it.split(",")[0])
        }
    }
    IoUtils.write(arrayList,rh1,true)
}

