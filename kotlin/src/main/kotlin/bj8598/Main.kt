package bj8598

import java.io.*
import java.util.LinkedList

val dx = arrayOf(1, 1, -1, -1, 2, 2, -2, -2)
val dy = arrayOf(2, -2, 2, -2, 1, -1, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { IntArray(m) }
    var start: Pair<Int, Int>? = null
    var end: Pair<Int, Int>? = null
    for (i in 0 until n) {
        val row = br.readLine()
        for (j in row.indices) {
            when (row[j]) {
                'z' -> start = Pair(i, j)
                'x' -> board[i][j] = -1
                'n' -> end = Pair(i, j)
            }
        }
    }
    val result = bfs(board, start!!, end!!)
    println(if (result == 0) "NIE" else result)
}

fun bfs(board: Array<IntArray>, start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(start)
    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()
        for (i in 0 until 8) {
            val ny = y + dx[i]
            val nx = x + dy[i]
            if (ny in board.indices && nx in board[0].indices && board[ny][nx] == 0) {
                board[ny][nx] = board[y][x] + 1
                queue.add(Pair(ny, nx))
            }
        }
    }
    return board[end.first][end.second]
}
