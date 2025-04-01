package bj5986

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val map = Array(n) { Array(n) { Array(n) { '.' } } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            val line = br.readLine()
            for (k in 0 until n) {
                map[i][j][k] = line[k]
            }
        }
    }
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)
    val dy = intArrayOf(0, 0, 1, -1, 0, 0)
    val dx = intArrayOf(1, -1, 0, 0, 0, 0)
    val visited = Array(n) { Array(n) { BooleanArray(n) } }
    var count = 0
    fun dfs(z: Int, y: Int, x: Int) {
        visited[z][y][x] = true
        for (i in 0 until 6) {
            val nz = z + dz[i]
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (nz in 0 until n && ny in 0 until n && nx in 0 until n && !visited[nz][ny][nx] && map[nz][ny][nx] == '*') {
                dfs(nz, ny, nx)
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                if (!visited[i][j][k] && map[i][j][k] == '*') {
                    count++
                    dfs(i, j, k)
                }
            }
        }
    }
    println(count)
}
