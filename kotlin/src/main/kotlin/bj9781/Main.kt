package bj9781

import java.io.*
import java.util.*

val dy = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)
val dx = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ySize, xSize) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(ySize) { CharArray(xSize) }
    for (i in 0 until ySize) {
        board[i] = br.readLine().toCharArray()
    }
    val visited = Array(ySize) { BooleanArray(xSize) }
    fun bfs(y: Int, x: Int): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(y to x)
        visited[y][x] = true
        var count = 0
        while (q.isNotEmpty()) {
            repeat(q.size) {
                val (curY, curX) = q.poll()
                if (board[curY][curX] == 'X') {
                    return count
                }
                for (dir in 0 until 8) {
                    val nextY = curY + dy[dir]
                    val nextX = curX + dx[dir]
                    if (nextY in 0 until ySize && nextX in 0 until xSize && !visited[nextY][nextX] && board[nextY][nextX] != '#') {
                        visited[nextY][nextX] = true
                        q.add(nextY to nextX)
                    }
                }
            }
            count++
        }
        return -1
    }
    for (i in 0 until ySize) {
        for (j in 0 until xSize) {
            if (board[i][j] == 'K') {
                println(bfs(i, j))
                return
            }
        }
    }
}
