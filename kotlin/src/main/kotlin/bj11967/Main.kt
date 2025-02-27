package bj11967

import java.io.*

val dy = intArrayOf(1, -1, 0, 0)
val dx = intArrayOf(0, 0, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val lights = Array(n) { Array(n) { false } }
    val switches = Array(n) { Array(n) { mutableListOf<Pair<Int, Int>>() } }
    lights[0][0] = true
    for (i in 0 until m) {
        val (x, y, a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
        switches[y][x].add(Pair(b, a))
    }
    fun bfs() {
        val q = mutableListOf(Pair(0, 0))
        val visited = Array(n) { Array(n) { false } }
        visited[0][0] = true
        while (q.isNotEmpty()) {
            val (y, x) = q.removeAt(0)
            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (ny in 0 until n && nx in 0 until n && !visited[ny][nx] && lights[ny][nx]) {
                    visited[ny][nx] = true
                    if (lights[ny][nx]) {
                        q.add(Pair(ny, nx))
                    }
                }
            }
            for ((ny, nx) in switches[y][x]) {
                if (!lights[ny][nx]) {
                    lights[ny][nx] = true
                    for (i in 0 until 4) {
                        val nny = ny + dy[i]
                        val nnx = nx + dx[i]
                        if (nny in 0 until n && nnx in 0 until n && visited[nny][nnx]) {
                            q.add(Pair(ny, nx))
                            break
                        }
                    }
                }
            }
        }
    }

    var count = 0
    while (true) {
        bfs()
        var lightCount = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (lights[i][j]) {
                    lightCount++
                }
            }
        }
        if (lightCount == count) break
        count = lightCount
    }
    println(count)
}
