package bj17265

import java.io.*
import kotlin.math.max
import kotlin.math.min

val ARROW_X = arrayOf(0, 1)
val ARROW_Y = arrayOf(1, 0)
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val road = Array(n) { CharArray(n) }
    val isVisited = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        road[i] = br.readLine().split(" ").map { it[0] }.toCharArray()
    }
    isVisited[0][0] = true
    dfs(0, '+', 0, 0, road, isVisited, n, true)
    bw.write("$max $min\n")
    br.close()
    bw.close()
}

fun dfs(
    result: Int,
    before: Char,
    y: Int,
    x: Int,
    city: Array<CharArray>,
    isVisited: Array<BooleanArray>,
    n: Int,
    isNum: Boolean
) {
    val nextResult: Int = if (isNum) {
        when (before) {
            '+' -> {
                result + (city[y][x] - '0')
            }

            '-' -> {
                result - (city[y][x] - '0')
            }

            else -> {
                result * (city[y][x] - '0')
            }
        }
    } else {
        result
    }
    if (y == n - 1 && x == n - 1) {
        max = max(max, nextResult)
        min = min(min, nextResult)
    } else {
        for (i in 0 until 2) {
            val nextY = y + ARROW_Y[i]
            val nextX = x + ARROW_X[i]
            if (canMove(nextY, nextX, n, n) && !isVisited[nextY][nextX]) {
                isVisited[nextY][nextX] = true
                dfs(nextResult, city[y][x], nextY, nextX, city, isVisited, n, !isNum)
                isVisited[nextY][nextX] = false
            }
        }
    }
}

fun canMove(nextY: Int, nextX: Int, ySize: Int, xSize: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
