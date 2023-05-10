package bj9700

import java.io.*

val ARROW_X = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
val ARROW_Y = arrayOf(-1, 1, 0, 0, -1, 1, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var readLine = br.readLine()
    var case = 1
    while (readLine != null) {
        val n = readLine.toInt()
        val floor = Array(n) { IntArray(n) }
        val isVisited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            floor[i] = br.readLine().toCharArray().map { it - '0' }.toIntArray()
        }
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!isVisited[i][j] && floor[i][j] == 1) {
                    isVisited[i][j] = true
                    dfs(i, j, floor, isVisited, n, n)
                    result++
                }
            }
        }
        bw.write("Case #$case: $result\n")
        case++
        readLine = br.readLine()
    }
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, floor: Array<IntArray>, isVisited: Array<BooleanArray>, ySize: Int, xSize: Int) {
    for (i in 0 until 8) {
        val nextY = y + ARROW_Y[i]
        val nextX = x + ARROW_X[i]
        if (canMove(nextY, nextX, ySize, xSize) && floor[nextY][nextX] == 1 && !isVisited[nextY][nextX]) {
            isVisited[nextY][nextX] = true
            dfs(nextY, nextX, floor, isVisited, ySize, xSize)
        }
    }
}

fun canMove(nextY: Int, nextX: Int, ySize: Int, xSize: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
