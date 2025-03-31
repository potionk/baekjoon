package bj33656

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ySize, xSize) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(ySize) { br.readLine().toCharArray() }
    var startY = 0
    var startX = 0
    for (y in 0 until ySize) {
        for (x in 0 until xSize) {
            if (map[y][x] == 'S') {
                startY = y
                startX = x
            }
        }
    }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val visited = Array(ySize) { BooleanArray(xSize) }
    var count = 1
    fun dfs(y: Int, x: Int) {
        visited[y][x] = true
        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0 until ySize && nx in 0 until xSize && !visited[ny][nx] && map[ny][nx] == '#') {
                count++
                dfs(ny, nx)
            }
        }
    }
    dfs(startY, startX)
    println(count)
}
