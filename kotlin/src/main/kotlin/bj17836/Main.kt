package bj17836

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
var xSize = -1
var ySize = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
    ySize = n
    xSize = m
    val towerMap = Array(ySize) { IntArray(xSize) }
    for (i in 0 until n) {
        towerMap[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val result = bfs(towerMap, 0, 0, t)
    println(if (result == -1) "Fail" else result)
    br.close()
}

fun bfs(towerMap: Array<IntArray>, y: Int, x: Int, maxTry: Int): Int {
    val queue = LinkedList<Triple<Int, Int, Boolean>>() // y, x, hasSword
    val isVisited = Array(ySize) { Array(xSize) { BooleanArray(2) } }
    queue.add(Triple(y, x, false))
    isVisited[y][x][0] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current.first == ySize - 1 && current.second == xSize - 1) {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) &&
                    ((!current.third && (towerMap[nextY][nextX] == 0 || towerMap[nextY][nextX] == 2)) || current.third) &&
                    !isVisited[nextY][nextX][if (current.third) 1 else 0]
                ) {
                    isVisited[nextY][nextX][if (current.third) 1 else 0] = true
                    queue.add(Triple(nextY, nextX, current.third || towerMap[nextY][nextX] == 2))
                }
            }
        }
        count++
        if (count > maxTry) {
            return -1
        }
    }
    return -1
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
