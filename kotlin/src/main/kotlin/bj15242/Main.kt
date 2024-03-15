package bj15242

import java.io.*

val dx = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
val dy = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val startStr = br.readLine()
    val start = Pair(startStr[0].code - 'a'.code, startStr[1].toString().toInt() - 1)
    val endStr = br.readLine()
    val end = Pair(endStr[0].code - 'a'.code, endStr[1].toString().toInt() - 1)
    println(bfs(start, end))
}

fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    val queue = mutableListOf(start)
    val visited = Array(8) { BooleanArray(8) }
    visited[start.first][start.second] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val (x, y) = queue.removeAt(0)
            if (x == end.first && y == end.second) {
                return count
            }
            for (i in 0 until 8) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0 until 8 && ny in 0 until 8 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.add(Pair(nx, ny))
                }
            }
        }
        count++
    }
    return -1
}
