package bj32932

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    var y = 0
    var x = 0
    val obstacles = mutableSetOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        obstacles.add(Pair(b, a))
    }
    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, 1, -1)
    val ks = br.readLine().toCharArray()
    for (i in 0 until k) {
        val dir = when (ks[i]) {
            'U' -> 0
            'D' -> 1
            'R' -> 2
            'L' -> 3
            else -> -1
        }
        val ny = y + dy[dir]
        val nx = x + dx[dir]
        if (Pair(ny, nx) in obstacles) {
            continue
        }
        y = ny
        x = nx
    }
    println("$x $y")
}
