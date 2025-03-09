package bj6032

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Triple<Int, Int, Double>>()
    for (i in 1..n) {
        val (a, b) = br.readLine().split(" ")
        list.add(Triple(i, b.toInt(), a.toDouble() / b.toDouble()))
    }
    list.sortByDescending { it.third }
    val result = list.take(3)
    println(result.sumOf { it.second })
    result.forEach { println(it.first) }
}
