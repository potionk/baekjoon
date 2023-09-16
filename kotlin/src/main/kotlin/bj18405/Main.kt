package bj18405

import java.io.BufferedReader
import java.io.InputStreamReader

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val (s, y, x) = br.readLine().split(" ").map { it.toInt() }
    val virus = mutableListOf<Pair<Int, Pair<Int, Int>>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] != 0) {
                virus.add(Pair(map[i][j], Pair(i, j)))
            }
        }
    }
    virus.sortBy { it.first }
    println(bfs(virus, map, s, y, x, n))
    br.close()
}

fun bfs(virus: MutableList<Pair<Int, Pair<Int, Int>>>, map: Array<IntArray>, s: Int, y: Int, x: Int, testCubeSize: Int): Int {
    val queue = mutableListOf<Pair<Int, Pair<Int, Int>>>()
    queue.addAll(virus)
    var time = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        if (time == s) {
            break
        }
        for (i in 0 until size) {
            val current = queue.removeAt(0)
            for (j in 0 until 4) {
                val nx = current.second.second + dx[j]
                val ny = current.second.first + dy[j]
                if (nx in 0 until testCubeSize && ny in 0 until testCubeSize && map[ny][nx] == 0) {
                    map[ny][nx] = current.first
                    queue.add(Pair(current.first, Pair(ny, nx)))
                }
            }
        }
        time++
    }
    return map[y - 1][x - 1]
}
