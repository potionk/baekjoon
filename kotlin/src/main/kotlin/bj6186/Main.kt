package bj6186

import java.io.*

val ARROW_X = arrayOf(1, 0, -1, 0)
val ARROW_Y = arrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { CharArray(c) }
    for (i in 0 until r) {
        val line = br.readLine()
        for (j in 0 until c) {
            map[i][j] = line[j]
        }
    }
    var count = 0
    val visited = Array(r) { BooleanArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (!visited[i][j] && map[i][j] == '#') {
                dfs(map, visited, i, j, r, c)
                count++
            }
        }
    }
    println(count)
}

fun dfs(world: Array<CharArray>, visited: Array<BooleanArray>, y: Int, x: Int, ySize: Int, xSize: Int) {
    visited[y][x] = true
    for (i in 0 until 4) {
        val nx = x + ARROW_X[i]
        val ny = y + ARROW_Y[i]
        if (nx in 0 until xSize && ny in 0 until ySize && !visited[ny][nx] && world[ny][nx] == '#') {
            dfs(world, visited, ny, nx, ySize, xSize)
        }
    }
}
