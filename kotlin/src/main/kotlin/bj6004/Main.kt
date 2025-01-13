package bj6004

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (xSize, ySize) = br.readLine().split(" ").map { it.toInt() }
    val farm = Array(ySize) { br.readLine().toCharArray() }
    val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
    val visited = Array(ySize) { BooleanArray(xSize) }
    fun bfs(y: Int, x: Int): Int {
        val queue = mutableListOf(Pair(y, x))
        visited[y][x] = true
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val (curY, curX) = queue.removeAt(0)
                if (farm[curY][curX] == 'H') {
                    return count
                }
                for (j in 0 until 8) {
                    val nextY = curY + dy[j]
                    val nextX = curX + dx[j]
                    if (nextY in 0 until ySize && nextX in 0 until xSize && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true
                        queue.add(Pair(nextY, nextX))
                    }
                }
            }
            count++
        }
        return -1
    }
    for (i in 0 until ySize) {
        for (j in 0 until xSize) {
            if (farm[i][j] == 'K') {
                println(bfs(i, j))
                return
            }
        }
    }
}
