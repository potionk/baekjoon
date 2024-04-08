package bj31575

import java.io.*

val dx = intArrayOf(1, 0)
val dy = intArrayOf(0, 1)
var result = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val world = Array(m) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(m) { BooleanArray(n) }
    dfs(0, 0, visited, world, m to n)
    println(if (result) "Yes" else "No")
}

fun dfs(y: Int, x: Int, visited: Array<BooleanArray>, world: Array<IntArray>, size: Pair<Int, Int>) {
    visited[y][x] = true
    if (y == size.first - 1 && x == size.second - 1) {
        result = true
        return
    }
    for (i in 0 until 2) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until size.second && ny in 0 until size.first && !visited[ny][nx] && world[ny][nx] == 1) {
            dfs(ny, nx, visited, world, size)
        }
    }
}
