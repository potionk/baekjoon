package bj30702

import java.io.*

val ARROW_X = arrayOf(0, 0, -1, 1)
val ARROW_Y = arrayOf(-1, 1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = Array(n) { br.readLine().toCharArray() }
    val b = Array(n) { br.readLine().toCharArray() }
    val isVisited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j]) {
                dfs(a, b, isVisited, i, j, n, m, a[i][j], b[i][j])
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (a[i][j] != b[i][j]) {
                println("NO")
                return
            }
        }
    }
    println("YES")
    br.close()
}

fun dfs(
    a: Array<CharArray>,
    b: Array<CharArray>,
    isVisited: Array<BooleanArray>,
    y: Int,
    x: Int,
    n: Int,
    m: Int,
    beforeA: Char,
    color: Char
) {
    isVisited[y][x] = true
    a[y][x] = color
    for (i in 0 until 4) {
        val nextY = y + ARROW_Y[i]
        val nextX = x + ARROW_X[i]
        if (nextY in 0 until n && nextX in 0 until m && !isVisited[nextY][nextX] && a[nextY][nextX] == beforeA) {
            dfs(a, b, isVisited, nextY, nextX, n, m, beforeA, color)
        }
    }
}
