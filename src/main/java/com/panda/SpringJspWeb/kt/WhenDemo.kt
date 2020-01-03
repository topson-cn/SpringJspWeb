package com.panda.SpringJspWeb.kt

import java.util.*

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

interface Exper
class NUM(val value : Int) : Exper
class SUM(val leftNum : Exper, val rightNum : Exper) : Exper

fun eval(e : Exper) : Int{
    if (e is NUM){
        val n = e as NUM
        return n.value
    }
    if (e is SUM){ // 类型只能转换
        return eval(e.leftNum) + eval(e.rightNum)
    }
    throw IllegalArgumentException("unkonw experssion")
}

fun eval1(e : Exper) : Int = //if 表达式体函数
        if (e is NUM) e.value else if (e is SUM) eval1(e.rightNum) + eval1(e.leftNum) else throw IllegalAccessError("unkonw experssion")

fun eval2(e: Exper) : Int = // when 表达体函数
        when(e){
            is NUM -> e.value
            is SUM -> eval2(e.leftNum) + eval2(e.rightNum)
            else -> throw IllegalArgumentException("unkonw experssion")
        }

fun evalWithLog(e: Exper) : Int =
        when(e){
            is NUM -> {//大括号函数体
                println("NUM ${e.value}")//字符串模板
                e.value
            }
            is SUM -> {
                val left = evalWithLog(e.leftNum)
                val right = evalWithLog(e.rightNum)
                println("SUM ${left} + ${right}")
                left + right
            }
            else -> throw IllegalAccessError("unkonw experssion")
        }

fun fizzBuzz(i: Int) : String =
        when{
            i % 15 == 0 -> "fizzBuzz"
            i % 3 == 0 -> "fizz"
            i % 5 ==0 -> "buzz"
            else -> "${i}"
        }

fun fb(){
    for (i in 1..100){ //区间用.. , 如果可以迭代区间中所以数的区间被称为数列
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2){// downto 递减,step 迭代间隔
        println(fizzBuzz(i))
    }

    for (i in 1..100 step 2){
        println(fizzBuzz(i))
    }

    for (i in 1 until 100 step 2){ // util 右闭区间 util == 100-1
        println(fizzBuzz(i))
    }
}

// 迭代map
fun iterMap(){
    val treeMap = TreeMap<Char, String>()// 创建对象不需new,这里完全是jdk的map类
    for (i in 'a'..'z'){// 字符可以转成ascii码,所以这里可以用区间,字符串就不行
        treeMap[i] = "${i}"// 数组可以直接通过[]赋值
    }
    for ((key,value) in treeMap){ // 可以key,value同时赋值在迭代时
        println("${key} -> ${value}")
    }
}

// in检查区间和集合
fun isletter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigist(c: Char) = c !in '0'..'9'
fun inSet(c: Char) =
        when {
            isletter(c) -> "letter"
            isNotDigist(c) -> "not digist"
            else -> "i dont know"
        }

fun inset(c: Char) =
        when {
            c in '0'..'9' -> "its digist"
            c in 'a'..'z' || c in 'A'..'Z' -> "its letter"
            else -> "i dont know"
        }

fun inset1(){
    println("kotlin" in "Java".."Scala")
    println("kotlin" in setOf<String>("Java","Scala"))
}

fun main(args: Array<String>) {
//    println(eval(SUM(SUM(NUM(1),NUM(2)),NUM(3))))
//    println(eval1(SUM(SUM(NUM(1),NUM(2)),NUM(3))))
//    println(eval2(SUM(SUM(NUM(1),NUM(2)),NUM(3))))
//    println(evalWithLog(SUM(SUM(NUM(1),NUM(2)),NUM(3))))
//    fb()
//    iterMap()
//    println(inSet(';'))
//    println(inset('1'))
    inset1()
}