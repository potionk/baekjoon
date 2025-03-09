package bj3109

import java.io.*

val dy = intArrayOf(-1, 0, 1)
val dx = intArrayOf(1, 1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { br.readLine().toCharArray() }
    val isVisited = Array(r) { BooleanArray(c) }
    fun dfs(y: Int, x: Int): Boolean {
        if (x == c - 1) {
            return true
        }
        for (i in 0 until 3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (ny in 0 until r && nx in 0 until c && graph[ny][nx] == '.' && !isVisited[ny][nx]) {
                isVisited[ny][nx] = true
                if (dfs(ny, nx)) {
                    return true
                }
            }
        }
        return false
    }

    var count = 0
    for (i in 0 until r) {
        if (dfs(i, 0)) {
            count++
        }
    }
    println(count)
}
