package bj30876

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val points = mutableListOf<Pair<Int,Int>>()
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        points.add(Pair(x, y))
    }
    points.sortBy { it.second }
    println("${points.first().first} ${points.first().second}")
}