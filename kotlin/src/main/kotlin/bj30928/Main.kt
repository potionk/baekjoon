package bj30928

import java.io.*

val yokohama = listOf('Y', 'O', 'K', 'O', 'H', 'A', 'M', 'A')
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var ySize = 0
var xSize = 0
var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ySize = n
    xSize = m
    val note = Array(n) { br.readLine().toCharArray() }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (note[i][j] == yokohama[0]) {
                dfs(j, i, note, 1)
            }
        }
    }
    println(result)
}

fun dfs(x: Int, y: Int, note: Array<CharArray>, idx: Int) {
    if (idx == 8) {
        result++
        return
    }
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until xSize && ny in 0 until ySize && note[ny][nx] == yokohama[idx]) {
            dfs(nx, ny, note, idx + 1)
        }
    }
}
