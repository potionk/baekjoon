package bj5958

import java.awt.Point
import java.io.*

val ARROW = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
var N = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    N = br.readLine().toInt()
    val universe = Array(N) { CharArray(N) }
    val isVisited = Array(N) { BooleanArray(N) }
    for (i in 0 until N) {
        universe[i] = br.readLine().toCharArray()
    }
    var count = 0
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (universe[i][j] == '*' && !isVisited[i][j]) {
                isVisited[i][j] = true
                dfs(i, j, universe[i][j], universe, isVisited)
                count++
            }
        }
    }
    bw.write("$count")
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, boardType: Char, universe: Array<CharArray>, isVisited: Array<BooleanArray>) {
    ARROW.forEach {
        val nextY = y + it.y
        val nextX = x + it.x
        if (canMove(nextY, nextX) && universe[nextY][nextX] == '*' && !isVisited[nextY][nextX]) {
            isVisited[nextY][nextX] = true
            dfs(nextY, nextX, boardType, universe, isVisited)
        }
    }
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until N && nextX in 0 until N
}
