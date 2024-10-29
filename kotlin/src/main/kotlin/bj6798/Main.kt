package bj6798

import java.io.*
import java.util.LinkedList

val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
val dx = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (startY, startX) = br.readLine().split(" ").map { it.toInt() -1 }
    val (endY, endX) = br.readLine().split(" ").map { it.toInt() -1 }
    val countMap = Array(8) { IntArray(8) { -1 } }
    countMap[startY][startX] = 0
    fun bfs() {
        if (startY == endY && startX == endX) {
            println("0")
            return
        }
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(startY to startX)
        while (queue.isNotEmpty()) {
            val (y, x) = queue.removeFirst()
            for (i in 0 until 8) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (ny in 0 until 8 && nx in 0 until 8 && countMap[ny][nx] == -1) {
                    countMap[ny][nx] = countMap[y][x] + 1
                    if (ny == endY && nx == endX) {
                        println(countMap[ny][nx])
                        return
                    }
                    queue.add(ny to nx)
                }
            }
        }
    }
    bfs()
}
