package bj17129

import java.io.*
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)

var xSize: Int = -1
var ySize: Int = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ySize = n
    xSize = m
    val field = Array(ySize) { IntArray(xSize) }
    var start = Pair(-1, -1)
    for (j in 0 until ySize) {
        field[j] = br.readLine().toCharArray().map { it - '0' }.toIntArray()
        for (i in 0 until xSize) {
            if (field[j][i] == 2) {
                start = Pair(j, i)
            }
        }
    }
    val result = bfs(field, start)
    println(if (result == -1) "NIE" else "TAK\n$result")
}

fun bfs(field: Array<IntArray>, start: Pair<Int, Int>): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    queue.add(Pair(start.first, start.second))
    isVisited[start.first][start.second] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (field[current.first][current.second] != 0 && field[current.first][current.second] != 2) {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && field[nextY][nextX] != 1 && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true
                    queue.add(Pair(nextY, nextX))
                }
            }
        }
        count++
    }
    return -1
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
