package bj31946

import java.io.*
import java.util.*

val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ySize = br.readLine().toInt()
    val xSize = br.readLine().toInt()
    val map = Array(ySize) { IntArray(xSize) }
    for (i in 0 until ySize) {
        map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val jump = br.readLine().toInt()
    fun getAvailableNext(): List<Pair<Int, Int>> {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(0 to 0)
        val bfsVisited = mutableSetOf<String>()
        bfsVisited.add("0 0")
        val list = mutableListOf<Pair<Int, Int>>()
        var count = 1
        while (q.isNotEmpty()) {
            if (count > jump) {
                return list
            }
            repeat(q.size) {
                val (curY, curX) = q.poll()
                for (dir in 0 until 4) {
                    val nextY = curY + dy[dir]
                    val nextX = curX + dx[dir]
                    if (!bfsVisited.contains("$nextY $nextX")) {
                        bfsVisited.add("$nextY $nextX")
                        q.add(nextY to nextX)
                        list.add(nextY to nextX)
                    }
                }
            }
            count++
        }
        return list
    }

    val nextList = getAvailableNext()
    fun bfs(): Boolean {
        val queue = LinkedList<Pair<Int, Int>>()
        val visited = Array(ySize) { BooleanArray(xSize) }
        queue.add(0 to 0)
        visited[0][0] = true
        val startColor = map[0][0]
        while (queue.isNotEmpty()) {
            val (curY, curX) = queue.poll()
            if (curY == ySize - 1 && curX == xSize - 1) {
                return true
            }
            for (dir in nextList) {
                val nextY = curY + dir.first
                val nextX = curX + dir.second
                if (nextY in 0 until ySize &&
                    nextX in 0 until xSize &&
                    !visited[nextY][nextX] &&
                    map[nextY][nextX] == startColor
                ) {
                    visited[nextY][nextX] = true
                    queue.add(nextY to nextX)
                }
            }
        }
        return false
    }
    println(if (bfs()) "ALIVE" else "DEAD")
}
