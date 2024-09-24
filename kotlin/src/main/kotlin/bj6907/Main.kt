package bj6907

import java.io.BufferedReader
import java.io.InputStreamReader

val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var woodSize = br.readLine().toInt()
    val ySize = br.readLine().toInt()
    val xSize = br.readLine().toInt()
    val wood = Array(ySize) { br.readLine().toCharArray() }
    val visited = Array(ySize) { BooleanArray(xSize) }
    val sizeList = mutableListOf<Int>()
    for (y in 0 until ySize) {
        for (x in 0 until xSize) {
            if (wood[y][x] == '.' && !visited[y][x]) {
                sizeList.add(dfs(wood, visited, y, x))
            }
        }
    }
    sizeList.sortByDescending { it }
    var result = 0
    var finished = false
    sizeList.forEach {
        if (woodSize >= it && !finished) {
            woodSize -= it
            result++
        } else {
            finished = true
        }
    }
    println("$result room${if (result != 1) "s" else ""}, $woodSize square metre(s) left over")
}

fun dfs(wood: Array<CharArray>, visited: Array<BooleanArray>, y: Int, x: Int): Int {
    visited[y][x] = true
    var size = 1
    for (i in 0 until 4) {
        val ny = y + dy[i]
        val nx = x + dx[i]
        if (ny in wood.indices && nx in 0 until wood[0].size && wood[ny][nx] == '.' && !visited[ny][nx]) {
            size += dfs(wood, visited, ny, nx)
        }
    }
    return size
}
