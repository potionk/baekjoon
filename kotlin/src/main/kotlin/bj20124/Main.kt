package bj20124

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<String, Int>>()
    repeat(n) {
        val (name, score) = br.readLine().split(" ")
        list.add(Pair(name, score.toInt()))
    }
    list.sortWith(compareBy({ -1 * it.second }, { it.first }))
    println(list[0].first)
}
