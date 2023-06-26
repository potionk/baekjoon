package bj25416

import java.io.*
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
const val SIZE = 5

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val field = Array(SIZE) { IntArray(SIZE) }
    for (j in 0 until SIZE) {
        field[j] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val (startY, startX) = br.readLine().split(" ").map { it.toInt() }
    val result = bfs(field, startY, startX)
    bw.write("$result\n")
    bw.close()
    br.close()
}

fun bfs(towerMap: Array<IntArray>, y: Int, x: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(SIZE) { BooleanArray(SIZE) }
    queue.add(Pair(y, x))
    isVisited[y][x] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (towerMap[current.first][current.second] == 1) {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && towerMap[nextY][nextX] != -1 && !isVisited[nextY][nextX]) {
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
    return nextY in 0 until SIZE && nextX in 0 until SIZE
}
