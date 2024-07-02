package bj2890

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until r) {
        val line = br.readLine()
        var index = c - 1
        while (!line[index].isDigit()) {
            index--
            if (index == -1) break
        }
        if (index == -1) continue
        list.add(Pair(line[index] - '0', c - index - 1))
    }
    list.sortBy { it.second }
    var rank = 1
    var prev = list[0].second
    val map = mutableMapOf<Int, Int>()
    list.forEach {
        if (it.second != prev) {
            rank += 1
            prev = it.second
        }
        map[it.first] = rank
    }
    for (i in 1 until 10) {
        println(map[i])
    }
}
