package bj9790

import java.io.*

val ARROW_X = arrayOf(0, 1, 0, -1)
val ARROW_Y = arrayOf(1, 0, -1, 0)
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val readLine = br.readLine()
        if (readLine == "0 0") {
            break
        }
        val xy = readLine.split(" ").map { it.toInt() }
        val x = xy[0]
        val y = xy[1]
        val city = Array(y) { CharArray(x) }
        val isVisited = Array(y) { BooleanArray(x) }
        var elephantY = -1
        var elephantX = -1
        for (i in 0 until y) {
            city[i] = br.readLine().toCharArray()
            for (j in 0 until x) {
                if (city[i][j] == 'A') {
                    elephantY = i
                    elephantX = j
                }
            }
        }
        count = 0
        dfs(elephantY, elephantX, city, isVisited, y, x)
        bw.write("$count\n")
    }
    br.close()
    bw.close()
}

fun dfs(y: Int, x: Int, city: Array<CharArray>, isVisited: Array<BooleanArray>, ySize: Int, xSize: Int) {
    count++
    isVisited[y][x] = true
    for (i in 0 until 4) {
        val nextY = y + ARROW_Y[i]
        val nextX = x + ARROW_X[i]
        if (canMove(nextY, nextX, ySize, xSize) && city[nextY][nextX] == '.' && !isVisited[nextY][nextX]) {
            dfs(nextY, nextX, city, isVisited, ySize, xSize)
        }
    }
}

fun canMove(nextY: Int, nextX: Int, ySize: Int, xSize: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
