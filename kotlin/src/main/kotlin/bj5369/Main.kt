package bj5369

import java.io.*
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val fieldSize = br.readLine().toInt()
        var start = Pair(-1, -1)
        val field = Array(fieldSize) { CharArray(fieldSize) }
        for (j in 0 until fieldSize) {
            field[j] = br.readLine().toCharArray()
            for (k in 0 until fieldSize) {
                if (field[j][k] == 's') {
                    start = Pair(j, k)
                }
            }
        }
        val result = bfs(field, start.first, start.second, fieldSize)
        bw.write("$result\n")
    }
    bw.close()
    br.close()
}

fun bfs(towerMap: Array<CharArray>, y: Int, x: Int, fieldSize: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(fieldSize) { BooleanArray(fieldSize) }
    queue.add(Pair(y, x))
    isVisited[y][x] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (towerMap[current.first][current.second] == 'd') {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX, fieldSize) && towerMap[nextY][nextX] != '*' && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true
                    queue.add(Pair(nextY, nextX))
                }
            }
        }
        count++
    }
    return -1
}

fun canMove(nextY: Int, nextX: Int, size: Int): Boolean {
    return nextY in 0 until size && nextX in 0 until size
}
