package bj28471

import java.io.BufferedReader
import java.io.InputStreamReader

val X_ARROW = listOf(-1, -1, -1, 0, 1, 1, 1)
val Y_ARROW = listOf(-1, 0, 1, -1, -1, 0, 1)
var count = -1
var n = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val map = Array(n) { br.readLine().toCharArray() }
    val isVisited = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 'F') {
                dfs(i, j, map, isVisited)
                println(count)
                return
            }
        }
    }
}

fun dfs(y: Int, x: Int, map: Array<CharArray>, isVisited: Array<BooleanArray>) {
    isVisited[y][x] = true
    count++
    for (i in 0 until 7) {
        val nx = x + X_ARROW[i]
        val ny = y + Y_ARROW[i]
        if (nx in 0 until n && ny in 0 until n && !isVisited[ny][nx] && map[ny][nx] == '.') {
            dfs(ny, nx, map, isVisited)
        }
    }
}
