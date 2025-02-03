package bj20126

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, s) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }
    list.sortBy { it.first }
    if (list[0].first >= m) {
        println(0)
        return
    }
    var result = -1
    for (i in 0 until n - 1) {
        if (list[i + 1].first - (list[i].first + list[i].second) >= m) {
            result = list[i].first + list[i].second
            break
        }
    }
    if (result == -1) {
        if (list[n - 1].first + list[n - 1].second + m <= s) {
            result = list[n - 1].first + list[n - 1].second
        }
    }
    println(result)
}
