package com.panda.SpringJspWeb.kt

import java.util.stream.Collectors

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
class CollectUtils{

    companion object {

        fun difference(big :List<String>, small : List<String>): List<String>{
            return big.stream().filter {it->
                !small.contains(it)
            }.collect(Collectors.toList())
        }
    }
}