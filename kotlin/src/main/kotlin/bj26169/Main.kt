package bj26169

import java.io.*

val Y_ARROW = listOf(0, 1, 0, -1)
val X_ARROW = listOf(1, 0, -1, 0)
const val BOARD_SIZE = 5
var isFind = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val board = Array(BOARD_SIZE) { IntArray(BOARD_SIZE) }
    val isVisited = Array(BOARD_SIZE) { BooleanArray(BOARD_SIZE) }
    for (i in 0 until BOARD_SIZE) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val rc = br.readLine().split(" ").map { it.toInt() }
    isVisited[rc[0]][rc[1]] = true
    dfs(rc[0], rc[1], board, isVisited, 1, 0)
    if (isFind) {
        println(1)
    } else {
        println(0)
    }
    br.close()
}

fun dfs(y: Int, x: Int, board: Array<IntArray>, isVisited: Array<BooleanArray>, visitCount: Int, eatAppleCount: Int) {
    if (visitCount <= 3 && !isFind) {
        for (i in 0 until 4) {
            val nextY = y + Y_ARROW[i]
            val nextX = x + X_ARROW[i]
            if (canMove(nextY, nextX) && board[nextY][nextX] != -1 && !isVisited[nextY][nextX]) {
                var nextEatAppleCount = eatAppleCount
                if (board[nextY][nextX] == 1) {
                    nextEatAppleCount++
                    if (nextEatAppleCount == 2) {
                        isFind = true
                    }
                }
                isVisited[nextY][nextX] = true
                dfs(nextY, nextX, board, isVisited, visitCount + 1, nextEatAppleCount)
                isVisited[nextY][nextX] = false
            }
        }
    }
}

fun canMove(nextY: Int, nextX: Int): Boolean {
    return nextY in 0 until BOARD_SIZE && nextX in 0 until BOARD_SIZE
}
