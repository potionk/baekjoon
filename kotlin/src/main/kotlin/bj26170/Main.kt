package bj26170

import java.io.*

val Y_ARROW = listOf(0, 1, 0, -1)
val X_ARROW = listOf(1, 0, -1, 0)
const val SIZE = 5
var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val board = Array(SIZE) { IntArray(SIZE) }
    val isVisited = Array(SIZE) { BooleanArray(SIZE) }
    for (i in 0 until SIZE) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toTypedArray().toIntArray()
    }
    val (y, x) = br.readLine().split(" ").map { it.toInt() }
    isVisited[y][x] = true
    dfs(y, x, board, isVisited, 0, 0)
    bw.write(
        if (min != Int.MAX_VALUE) {
            "$min"
        } else {
            "-1"
        }
    )
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, board: Array<IntArray>, isVisited: Array<BooleanArray>, eatAppleCount: Int, moveCount: Int) {
    val nextEatAppleCount = if (board[y][x] == 1) {
        eatAppleCount + 1
    } else {
        eatAppleCount
    }
    if (nextEatAppleCount < 3) {
        for (i in 0 until 4) {
            val nextY = y + Y_ARROW[i]
            val nextX = x + X_ARROW[i]
            if (canMove(nextY, nextX) && board[nextY][nextX] != -1 && !isVisited[nextY][nextX]) {
                isVisited[nextY][nextX] = true
                dfs(nextY, nextX, board, isVisited, nextEatAppleCount, moveCount + 1)
                isVisited[nextY][nextX] = false
            }
        }
    } else {
        min = minOf(min, moveCount)
    }
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until SIZE && nextX in 0 until SIZE
}
