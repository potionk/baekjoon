package bj6108

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    for (i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }.sorted()
        list.add(line[n / 2])
    }
    list.sort()
    println(list[n / 2])
}
