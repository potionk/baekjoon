package bj1388

import java.io.*

val Y_ARROW = listOf(0, 1, 0, -1)
val X_ARROW = listOf(1, 0, -1, 0)
var N = 0
var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nm = br.readLine().split(" ").map { it.toInt() }
    N = nm[0]
    M = nm[1]
    val floor = Array(N) { CharArray(M) }
    val isVisited = Array(N) { BooleanArray(M) }
    for (i in 0 until N) {
        floor[i] = br.readLine().toCharArray()
    }
    var result = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (!isVisited[i][j]) {
                isVisited[i][j] = true
                dfs(i, j, floor[i][j], floor, isVisited)
                result++
            }
        }
    }
    bw.write("$result")
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, boardType: Char, floor: Array<CharArray>, isVisited: Array<BooleanArray>) {
    val startIdx = if (boardType == '-') {
        0
    } else {
        1
    }
    for (i in startIdx until 4 step 2) {
        val nextY = y + Y_ARROW[i]
        val nextX = x + X_ARROW[i]
        if (canMove(nextY, nextX) && floor[nextY][nextX] == boardType && !isVisited[nextY][nextX]) {
            isVisited[nextY][nextX] = true
            dfs(nextY, nextX, boardType, floor, isVisited)
        }
    }
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until N && nextX in 0 until M
}
