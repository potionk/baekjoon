package bj9311

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
var xSize = -1
var ySize = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (y, x) = br.readLine().split(" ").map { it.toInt() }
        ySize = y
        xSize = x
        val maze = Array(ySize) { CharArray(xSize) }
        var start: Pair<Int, Int>? = null
        for (j in 0 until ySize) {
            val input = br.readLine().toCharArray()
            maze[j] = input
            for (k in 0 until xSize) {
                if (input[k] == 'S') {
                    start = Pair(j, k)
                }
            }
        }
        val result = bfs(maze, start!!)
        if (result == -1) {
            println("No Exit")
        } else {
            println("Shortest Path: $result")
        }
    }
    br.close()
}

fun bfs(maze: Array<CharArray>, start: Pair<Int, Int>): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    queue.add(Pair(start.first, start.second))
    isVisited[start.first][start.second] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (maze[current.first][current.second] == 'G') {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && maze[nextY][nextX] != 'X' && !isVisited[nextY][nextX]) {
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
