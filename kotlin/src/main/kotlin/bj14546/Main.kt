package bj14546

import java.io.BufferedReader
import java.io.InputStreamReader

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val info = br.readLine().split(" ").map { it.toInt() }
        val size = info[1] to info[0]
        val start = size.first - info[3] to info[2] - 1
        val end = size.first - info[5] to info[4] - 1
        val map = Array(size.first) { br.readLine().toCharArray() }
        val visited = Array(size.first) { BooleanArray(size.second) }
        if (bfs(start, visited, map, size, map[start.first][start.second], end)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

fun bfs(
    start: Pair<Int, Int>, // y, x
    visited: Array<BooleanArray>,
    map: Array<CharArray>,
    size: Pair<Int, Int>, // ySize, xSize
    before: Char,
    end: Pair<Int, Int> // y, x
): Boolean {
    val queue = mutableListOf<Pair<Int, Int>>()
    queue.add(start)
    visited[start.first][start.second] = true
    while (queue.isNotEmpty()) {
        val (curY, curX) = queue.removeAt(0)
        for (i in 0 until 4) {
            val nextY = curY + dy[i]
            val nextX = curX + dx[i]
            if (nextY !in 0 until size.first || nextX !in 0 until size.second) continue
            if (visited[nextY][nextX]) continue
            if (map[nextY][nextX] != before) continue
            if (nextY == end.first && nextX == end.second) return true
            visited[nextY][nextX] = true
            queue.add(nextY to nextX)
        }
    }
    return false
}
