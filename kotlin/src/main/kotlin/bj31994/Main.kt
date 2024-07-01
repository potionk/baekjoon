package bj31994

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<Pair<String, Int>>()
    for (i in 0 until 7) {
        val (a, b) = br.readLine().split(" ")
        list.add(Pair(a, b.toInt()))
    }
    list.sortByDescending { it.second }
    println(list[0].first)
}
