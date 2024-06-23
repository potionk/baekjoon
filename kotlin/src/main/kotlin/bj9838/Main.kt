package bj9838

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val a = br.readLine().toInt()
        list.add(Pair(a, i + 1))
    }
    list.sortBy { it.first }
    list.forEach { println("${it.second}") }
}
