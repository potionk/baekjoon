package bj7107

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, i, j) = br.readLine().split(" ").map { it.toInt() }
    val isVisited = Array(n) { Array(m) { false } }
    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)
    fun bfs(y: Int, x: Int): Int {
        val queue = mutableListOf(Pair(y, x))
        isVisited[y][x] = true
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (s in 0 until size) {
                val (curY, curX) = queue.removeAt(0)
                if (curY == i - 1 && curX == j - 1) {
                    return count
                }
                for (k in 0 until 8) {
                    val nextY = curY + dy[k]
                    val nextX = curX + dx[k]
                    if (nextY in 0 until n && nextX in 0 until m && !isVisited[nextY][nextX]) {
                        isVisited[nextY][nextX] = true
                        queue.add(Pair(nextY, nextX))
                    }
                }
            }
            count++
        }
        return -1
    }

    val result = bfs(0, 0)
    println(if (result == -1) "NEVAR" else result)
}
