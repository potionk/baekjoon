package bj6031

import java.io.*
import kotlin.math.max

val ARROW_X = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
val ARROW_Y = arrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
var result = 0
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val wh = br.readLine().split(" ").map { it.toInt() }
    val ySize = wh[1]
    val xSize = wh[0]
    val world = Array(ySize) { CharArray(xSize) }
    for (i in 0 until ySize) {
        world[i] = br.readLine().toCharArray()
    }
    val visited = Array(ySize) { BooleanArray(xSize) }
    for (i in 0 until ySize) {
        for (j in 0 until xSize) {
            if (world[i][j] == '.' && !visited[i][j]) {
                count = 0
                dfs(world, visited, i, j, ySize, xSize)
                result = max(result, count)
            }
        }
    }
    println(result)
    br.close()
}

fun dfs(field: Array<CharArray>, visited: Array<BooleanArray>, y: Int, x: Int, ySize: Int, xSize: Int) {
    visited[y][x] = true
    count++
    for (i in 0 until 8) {
        val nx = x + ARROW_X[i]
        val ny = y + ARROW_Y[i]
        if (nx in 0 until xSize && ny in 0 until ySize && !visited[ny][nx] && field[ny][nx] == '.') {
            dfs(field, visited, ny, nx, ySize, xSize)
        }
    }
}
