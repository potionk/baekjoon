package bj30610

import java.io.*

val Y_ARROW = intArrayOf(-1, 0, 1, 0)
val X_ARROW = intArrayOf(0, 1, 0, -1)
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ySize, xSize) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(ySize) { br.readLine().toCharArray() }
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    val result = mutableListOf<Int>()
    for (i in 0 until ySize) {
        for (j in 0 until xSize) {
            if (!isVisited[i][j] && map[i][j] == '1') {
                count = 0
                dfs(i, j, isVisited, map, ySize, xSize)
                result.add(count)
            }
        }
    }
    println(result.size)
    println(result.sorted().joinToString(" "))
}

fun dfs(
    y: Int,
    x: Int,
    isVisited: Array<BooleanArray>,
    map: Array<CharArray>,
    ySize: Int,
    xSize: Int
) {
    isVisited[y][x] = true
    count++
    for (i in 0 until 4) {
        val ny = y + Y_ARROW[i]
        val nx = x + X_ARROW[i]
        if (ny < 0 || nx < 0 || ny >= map.size || nx >= map[0].size) {
            continue
        }
        if (map[ny][nx] == '1' && !isVisited[ny][nx]) {
            dfs(ny, nx, isVisited, map, ySize, xSize)
        }
    }
}
