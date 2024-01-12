package bj6189

import java.io.*
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)

var xSize: Int = -1
var ySize: Int = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    ySize = r
    xSize = c
    val field = Array(ySize) { CharArray(xSize) }
    var start = Pair(-1, -1)
    for (j in 0 until ySize) {
        field[j] = br.readLine().toCharArray()
        for (i in 0 until xSize) {
            if (field[j][i] == 'B') {
                start = Pair(j, i)
            }
        }
    }
    val result = bfs(field, start)
    bw.write("$result\n")
    bw.close()
    br.close()
}

fun bfs(field: Array<CharArray>, start: Pair<Int, Int>): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    queue.add(Pair(start.first, start.second))
    isVisited[start.first][start.second] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (field[current.first][current.second] == 'C') {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && field[nextY][nextX] != '*' && !isVisited[nextY][nextX]) {
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
