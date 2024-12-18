package bj8633

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<String>()
    for (i in 0 until n) {
        list.add(br.readLine())
    }
    list.sortWith(compareBy({ it.length }, { it }))
    list.forEach {
        println(it)
    }
}
