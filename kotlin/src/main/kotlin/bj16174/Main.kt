package bj16174

import java.io.*

val ARROW_X = arrayOf(1, 0)
val ARROW_Y = arrayOf(0, 1)
var isFinish = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val world = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        world[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    dfs(world, Array(n) { BooleanArray(n) }, 0, 0, n)
    println(if (isFinish) "HaruHaru" else "Hing")
    br.close()
}

fun dfs(world: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int, n: Int) {
    if (x == n - 1 && y == n - 1) {
        isFinish = true
    }
    if (!isFinish) {
        visited[x][y] = true
        for (i in 0 until 2) {
            val nx = x + ARROW_X[i] * world[x][y]
            val ny = y + ARROW_Y[i] * world[x][y]
            if (nx in 0 until n && ny in 0 until n && !visited[nx][ny]) {
                dfs(world, visited, nx, ny, n)
            }
        }
    }
}
