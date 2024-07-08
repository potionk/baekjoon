package bj6993

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (str, num) = br.readLine().split(" ")
        val result = str.substring(str.length - num.toInt()) + str.substring(0, str.length - num.toInt())
        println("Shifting $str by $num positions gives us: $result")
    }
}
