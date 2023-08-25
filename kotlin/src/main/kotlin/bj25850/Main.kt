package bj25850

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val players = mutableListOf<Pair<Int, Char>>()
    for (i in 0 until n) {
        val player = br.readLine().split(" ").map { it.toInt() }
        for (j in 1 until player[0] + 1) {
            players.add(Pair(player[j], 'A' + i))
        }
    }
    players.sortBy { it.first }
    players.forEach {
        print("${it.second}")
    }
}
