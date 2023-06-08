package bj5931

import java.io.*
import java.util.*
import kotlin.math.min

val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
var xSize = -1
var ySize = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ySize = n
    xSize = m
    val cowMap = Array(ySize) { CharArray(xSize) }
    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            cowMap[i][j] = line[j]
        }
    }
    var section = '1'
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (cowMap[i][j] == 'X') {
                separateCows(cowMap, i, j, section, Array(ySize) { BooleanArray(xSize) })
                section++
                if (section == '3') {
                    break
                }
            }
        }
        if (section == '3') {
            break
        }
    }
    var result = Int.MAX_VALUE
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (cowMap[i][j] == '1') {
                val count = findTwoSection(cowMap, i, j)
                if (count != -1) {
                    result = min(result, count)
                }
            }
        }
    }
    println(result - 1)
    br.close()
}

fun separateCows(cowMap: Array<CharArray>, y: Int, x: Int, section: Char, visited: Array<BooleanArray>) {
    cowMap[y][x] = section
    visited[y][x] = true
    for (i in 0 until 4) {
        val nextY = y + Y_ARROW[i]
        val nextX = x + X_ARROW[i]
        if (canMove(nextY, nextX) && cowMap[nextY][nextX] == 'X' && !visited[nextY][nextX]) {
            separateCows(cowMap, nextY, nextX, section, visited)
        }
    }
}

fun findTwoSection(cowMap: Array<CharArray>, y: Int, x: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    queue.add(Pair(y, x))
    isVisited[y][x] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (cowMap[current.first][current.second] == '2') {
                return count
            }
            for (j in 0 until 4) {
                val nextY = current.first + Y_ARROW[j]
                val nextX = current.second + X_ARROW[j]
                if (canMove(nextY, nextX) && !isVisited[nextY][nextX]) {
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
