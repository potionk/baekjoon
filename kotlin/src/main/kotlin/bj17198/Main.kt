package bj17198

import java.io.*

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val graph = Array(10) { br.readLine().toCharArray() }
    for (i in 0 until 10) {
        for (j in 0 until 10) {
            if (graph[i][j] == 'B') {
                println(bfs(graph, i, j))
                return
            }
        }
    }
}

fun bfs(start: Array<CharArray>, x: Int, y: Int): Int {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val visited = Array(10) { BooleanArray(10) }
    val queue = mutableListOf<Pair<Int, Int>>()
    visited[x][y] = true
    var count = -1
    queue.add(Pair(x, y))
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val (curX, curY) = queue.removeAt(0)
            if (start[curX][curY] == 'L') {
                return count
            }
            for (j in 0 until 4) {
                val nx = curX + dx[j]
                val ny = curY + dy[j]
                if (nx in 0 until 10 && ny in 0 until 10 && !visited[nx][ny] && start[nx][ny] != 'R') {
                    visited[nx][ny] = true
                    queue.add(Pair(nx, ny))
                }
            }
        }
        count++
    }
    return -1
}
