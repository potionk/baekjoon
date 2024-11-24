package bj15702

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val scoreBoard = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val info = br.readLine().split(" ")
        val name = info[0]
        var score = 0
        for (i in 0 until n) {
            if (info[i + 1] == "O") {
                score += scoreBoard[i]
            }
        }
        list.add(Pair(score, name.toInt()))
    }
    list.sortWith(compareBy({ -it.first }, { it.second }))
    println("${list[0].second} ${list[0].first}")
}
