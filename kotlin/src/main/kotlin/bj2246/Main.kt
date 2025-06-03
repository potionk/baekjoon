package bj2246

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val condos = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (d, c) = br.readLine().split(" ").map { it.toInt() }
        condos.add(Pair(d, c))
    }
    condos.sortWith(compareBy({ it.first }, { it.second }))
    var count = 0
    var minCost = Int.MAX_VALUE
    for (i in 0 until n) {
        if (condos[i].second < minCost) {
            count++
            minCost = condos[i].second
        }
    }
    println(count)
}
