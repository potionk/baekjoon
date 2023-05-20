package bj26999

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
    val (w, h) = br.readLine().split(" ").map { it.toInt() }
    ySize = h
    xSize = w
    val farm = Array(h) { CharArray(w) }
    for (i in 0 until h) {
        farm[i] = br.readLine().toCharArray()
    }
    val isVisited = Array(h) { BooleanArray(w) }
    var max = -1
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (farm[i][j] == '*' && !isVisited[i][j]) {
                dfs(i, j, farm, isVisited)
                max = max(max, count)
                count = 0
            }
        }
    }
    println(max)
    br.close()
}

fun dfs(y: Int, x: Int, farm: Array<CharArray>, isVisited: Array<BooleanArray>) {
    isVisited[y][x] = true
    count++
    for (i in 0 until 4) {
        val nx = x + X_ARROW[i]
        val ny = y + Y_ARROW[i]
        if (nx in 0 until xSize && ny in 0 until ySize && !isVisited[ny][nx] && farm[ny][nx] == '*') {
            dfs(ny, nx, farm, isVisited)
        }
    }
}
