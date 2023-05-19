package bj26533

import java.io.*

val ARROW_X = arrayOf(1, 0)
val ARROW_Y = arrayOf(0, 1)
var isFinish = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val farmhouse = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        farmhouse[i] = br.readLine().toCharArray()
    }
    dfs(farmhouse, Array(n) { BooleanArray(n) }, 0, 0, n)
    println(if (isFinish) "Yes" else "No")
    br.close()
}

fun dfs(farmhouse: Array<CharArray>, visited: Array<BooleanArray>, x: Int, y: Int, n: Int) {
    if (x == n - 1 && y == n - 1) {
        isFinish = true
    }
    if (!isFinish) {
        visited[y][x] = true
        for (i in 0 until 2) {
            val nx = x + ARROW_X[i]
            val ny = y + ARROW_Y[i]
            if (nx in 0 until n && ny in 0 until n && !visited[ny][nx] && farmhouse[ny][nx] == '.') {
                dfs(farmhouse, visited, nx, ny, n)
            }
        }
    }
}
