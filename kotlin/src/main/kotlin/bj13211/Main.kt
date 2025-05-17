package bj13211

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    val n = br.readLine().toInt()
    val taxis = mutableListOf<Triple<Int, Int, Int>>() // x, y, distance
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        taxis.add(Triple(a, b, (calculateManhattanDistance(x, y, a, b))))
    }
    taxis.sortBy { it.third }
    val nearestTaxi = taxis.first()
    println("${nearestTaxi.first} ${nearestTaxi.second}")
}

fun calculateManhattanDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return abs(x1 - x2) + abs(y1 - y2)
}
