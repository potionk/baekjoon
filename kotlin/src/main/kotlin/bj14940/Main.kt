package bj14940

import java.io.*
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
var xSize = -1
var ySize = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (y, x) = br.readLine().split(" ").map { it.toInt() }
    ySize = y
    xSize = x
    val world = Array(ySize) { IntArray(xSize) }
    var start: Pair<Int, Int>? = null
    for (j in 0 until ySize) {
        val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        world[j] = input
        for (k in 0 until xSize) {
            if (input[k] == 2) {
                start = Pair(j, k)
            }
        }
    }
    val shortestPath = bfs(world, start!!)
    for (j in 0 until ySize) {
        for (k in 0 until xSize) {
            if (shortestPath[j][k] == 0 && world[j][k] == 1) {
                bw.write("-1 ")
            } else {
                bw.write("${shortestPath[j][k]} ")
            }
        }
        bw.write("\n")
    }
    bw.close()
    br.close()
}

fun bfs(maze: Array<IntArray>, start: Pair<Int, Int>): Array<IntArray> {
    val queue = LinkedList<Pair<Int, Int>>()
    val shortestPath = Array(ySize) { IntArray(xSize) }
    queue.add(Pair(start.first, start.second))
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && maze[nextY][nextX] == 1 && shortestPath[nextY][nextX] == 0) {
                    shortestPath[nextY][nextX] = count + 1
                    queue.add(Pair(nextY, nextX))
                }
            }
        }
        count++
    }
    return shortestPath
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
