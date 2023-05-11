package bj16390

import java.io.*

val ARROW_X = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
val ARROW_Y = arrayOf(-1, 1, 0, 0, -1, 1, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val yx = br.readLine().split(" ").map { it.toInt() }
    val y = yx[0]
    val x = yx[1]
    val floor = Array(y) { CharArray(x) }
    val isVisited = Array(y) { BooleanArray(x) }
    for (i in 0 until y) {
        floor[i] = br.readLine().toCharArray()
    }
    var count = 0
    for (i in 0 until y) {
        for (j in 0 until x) {
            if (!isVisited[i][j] && floor[i][j] == '#') {
                isVisited[i][j] = true
                dfs(i, j, floor, isVisited, y, x)
                count++
            }
        }
    }
    bw.write("$count")
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, floor: Array<CharArray>, isVisited: Array<BooleanArray>, ySize: Int, xSize: Int) {
    for (i in 0 until 8) {
        val nextY = y + ARROW_Y[i]
        val nextX = x + ARROW_X[i]
        if (canMove(nextY, nextX, ySize, xSize) && floor[nextY][nextX] == '#' && !isVisited[nextY][nextX]) {
            isVisited[nextY][nextX] = true
            dfs(nextY, nextX, floor, isVisited, ySize, xSize)
        }
    }
}

fun canMove(nextY: Int, nextX: Int, ySize: Int, xSize: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
