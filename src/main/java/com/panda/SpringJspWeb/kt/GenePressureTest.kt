package com.panda.SpringJspWeb.kt

import com.google.common.collect.Lists

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
fun main(args: Array<String>) {
    //总用户
    var result1 = "C:\\Users\\toyz\\Desktop\\kt\\result2.txt"
    var jiangbei = "C:\\Users\\toyz\\Desktop\\kt\\jiangbei.txt"
    var yuhua = "C:\\Users\\toyz\\Desktop\\kt\\yuhua.txt"
    var jiangbeis = Lists.newArrayList<String>("7","15","23","31","39","47","55","63","71","79","87","95","103","111","119","127","135","143","151","159","167","175","183","191","199","207","215","223","231","239","247","255")
    var jiangbeiList = Lists.newArrayList<String>()
    var yuhuaList = Lists.newArrayList<String>()
   IoUtils.readLine(result1).map {
       var jf = it.split(",")[1]
       if (jiangbeis.contains(jf)){
           jiangbeiList.add(it)
       }else{
           yuhuaList.add(it)
       }
   }
    IoUtils.write(jiangbeiList,jiangbei)
    IoUtils.write(yuhuaList,yuhua)
}