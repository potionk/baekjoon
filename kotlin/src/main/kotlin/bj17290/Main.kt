package bj17290

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (curY, curX) = br.readLine().split(" ").map { it.toInt() }
    val field = Array(10) { CharArray(10) }
    for (i in 0 until 10) {
        field[i] = br.readLine().toCharArray()
    }
    for (i in 0 until 10) {
        for (j in 0 until 10) {
            if (field[i][j] == 'o') {
                for (k in 0 until 10) {
                    if (field[i][k] == 'x') {
                        field[i][k] = 'b'
                    }
                    if (field[k][j] == 'x') {
                        field[k][j] = 'b'
                    }
                }
            }
        }
    }
    fun bfs(y: Int, x: Int): Int {
        if (field[y][x] == 'x') {
            return 0
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = Array(10) { BooleanArray(10) }
        val dy = intArrayOf(1, -1, 0, 0)
        val dx = intArrayOf(0, 0, 1, -1)
        queue.add(Pair(y, x))
        visited[y][x] = true
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val (cy, cx) = queue.removeFirst()
                if (field[cy][cx] == 'x') {
                    return count
                }
                for (j in 0 until 4) {
                    val ny = cy + dy[j]
                    val nx = cx + dx[j]
                    if (ny in 0 until 10 && nx in 0 until 10 && !visited[ny][nx]) {
                        visited[ny][nx] = true
                        queue.add(Pair(ny, nx))
                    }
                }
            }
            count++
        }
        return -1
    }
    println(bfs(curY - 1, curX - 1))
}
