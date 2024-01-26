package bj18404

import java.io.*

val dx = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
val dy = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (knightY, knightX) = br.readLine().split(" ").map { it.toInt() }
    val chessboard = Array(n) { IntArray(n) }
    val targets = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until m) {
        val (y, x) = br.readLine().split(" ").map { it.toInt() }
        chessboard[y - 1][x - 1] = -1
        targets.add(Pair(y - 1, x - 1))
    }
    bfs(Pair(knightY - 1, knightX - 1), chessboard, m, n)
    targets.forEach {
        bw.write("${chessboard[it.first][it.second]} ")
    }
    bw.close()
}

fun bfs(knightPoint: Pair<Int, Int>, chessBoard: Array<IntArray>, m: Int, n: Int) {
    val queue = mutableListOf<Pair<Int, Int>>()
    val isVisited = Array(n) { BooleanArray(n) }
    isVisited[knightPoint.first][knightPoint.second] = true
    queue.add(knightPoint)
    var findCount = 0
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val currentPoint = queue.removeAt(0)
            if (chessBoard[currentPoint.first][currentPoint.second] == -1) {
                findCount++
                chessBoard[currentPoint.first][currentPoint.second] = count
                if (findCount == m) {
                    return
                }
            }
            for (j in 0 until 8) {
                val nextY = currentPoint.first + dy[j]
                val nextX = currentPoint.second + dx[j]
                if (nextY in 0 until n && nextX in 0 until n && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true
                    queue.add(Pair(nextY, nextX))
                }
            }
        }
        count++
    }
}
