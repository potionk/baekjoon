package bj11609

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<String, String>>()
    repeat(n) {
        val (a, b) = br.readLine().split(" ")
        list.add(Pair(a, b))
    }
    list.sortedWith(compareBy({ it.second }, { it.first })).forEach {
        println("${it.first} ${it.second}")
    }
}
