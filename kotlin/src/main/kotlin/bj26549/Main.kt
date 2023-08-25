package bj26549

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)
var spaceCount = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (ySize, xSize) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(ySize) { CharArray(xSize) }
        val visited = Array(ySize) { BooleanArray(xSize) }
        for (j in 0 until ySize) {
            val input = br.readLine()
            for (k in 0 until xSize) {
                map[j][k] = input[k]
            }
        }
        var count = 0
        spaceCount = 0
        for (j in 0 until ySize) {
            for (k in 0 until xSize) {
                if (visited[j][k]) {
                    continue
                }
                if (map[j][k] == '#') {
                    continue
                }
                dfs(map, j, k, visited)
                count++
            }
        }
        bw.write("$count ${if (count == 1) "section" else "sections"}, $spaceCount ${if (spaceCount == 1) "space" else "spaces"}\n")
    }
    bw.close()
}

fun dfs(map: Array<CharArray>, y: Int, x: Int, visited: Array<BooleanArray>) {
    visited[y][x] = true
    spaceCount++
    for (i in 0 until 4) {
        val ny = y + dy[i]
        val nx = x + dx[i]
        if (ny < 0 || nx < 0 || ny >= map.size || nx >= map[0].size) {
            continue
        }
        if (visited[ny][nx]) {
            continue
        }
        if (map[ny][nx] == '#') {
            continue
        }
        dfs(map, ny, nx, visited)
    }
}
