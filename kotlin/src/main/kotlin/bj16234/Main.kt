package bj16234

import java.io.*
import java.util.LinkedList
import kotlin.math.abs

val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l, r) = br.readLine().trim().split(" ").map { it.toInt() }

    val a = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val parts = br.readLine().trim().split(" ")
        for (j in 0 until n) {
            a[i][j] = parts[j].toInt()
        }
    }

    var count = 0
    while (true) {
        val visited = Array(n) { BooleanArray(n) }
        var moved = false
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (visited[i][j]) continue
                val q = LinkedList<Pair<Int, Int>>()
                val unionCells = ArrayList<Pair<Int, Int>>()
                q.add(Pair(i, j))
                visited[i][j] = true
                var sum = a[i][j]
                while (q.isNotEmpty()) {
                    val cur = q.removeFirst()
                    val y = cur.first
                    val x = cur.second
                    unionCells.add(cur)
                    for (dir in 0 until 4) {
                        val ny = y + dy[dir]
                        val nx = x + dx[dir]
                        if (ny !in 0 until n || nx !in 0 until n || visited[ny][nx]) continue
                        val diff = abs(a[y][x] - a[ny][nx])
                        if (diff in l..r) {
                            visited[ny][nx] = true
                            q.add(Pair(ny, nx))
                            sum += a[ny][nx]
                        }
                    }
                }
                if (unionCells.size > 1) {
                    moved = true
                    val average = sum / unionCells.size
                    for (cell in unionCells) {
                        a[cell.first][cell.second] = average
                    }
                }
            }
        }
        if (!moved) break
        count++
    }

    println(count)
}
