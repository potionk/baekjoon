package bj29634

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var count = 0
val X_ARROW = arrayOf(0, 1, 0, -1)
val Y_ARROW = arrayOf(-1, 0, 1, 0)
var xSize = -1
var ySize = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    ySize = n
    xSize = m
    val hotel = Array(ySize) { CharArray(xSize) }
    for (i in 0 until ySize) {
        hotel[i] = br.readLine().toCharArray()
    }
    val isVisited = Array(ySize) { BooleanArray(xSize) }
    var max = -1
    for (i in 0 until ySize) {
        for (j in 0 until xSize) {
            if (hotel[i][j] == '.' && !isVisited[i][j]) {
                dfs(i, j, hotel, isVisited)
                max = max(max, count)
                count = 0
            }
        }
    }
    println(max)
    br.close()
}

fun dfs(y: Int, x: Int, hotel: Array<CharArray>, isVisited: Array<BooleanArray>) {
    isVisited[y][x] = true
    count++
    for (i in 0 until 4) {
        val nx = x + X_ARROW[i]
        val ny = y + Y_ARROW[i]
        if (nx in 0 until xSize && ny in 0 until ySize && !isVisited[ny][nx] && hotel[ny][nx] == '.') {
            dfs(ny, nx, hotel, isVisited)
        }
    }
}
