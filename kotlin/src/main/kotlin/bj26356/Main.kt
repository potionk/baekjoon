package bj26356

import java.io.*
import java.util.*

val dy = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)
val dx = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    for (i in 1..tc) {
        val (size, r1, c1, r2, c2) = br.readLine().split(" ").map { it.toInt() }
        val visited = Array(size) { BooleanArray(size) }
        fun bfs(startY: Int, startX: Int, endY: Int, endX: Int): Int {
            val q: Queue<Pair<Int, Int>> = LinkedList()
            q.add(startY to startX)
            visited[startY][startX] = true
            var count = 0
            while (q.isNotEmpty()) {
                repeat(q.size) {
                    val (curY, curX) = q.poll()
                    if (curY == endY && curX == endX) {
                        return count
                    }
                    for (dir in 0 until 8) {
                        val nextY = curY + dy[dir]
                        val nextX = curX + dx[dir]
                        if (nextY in 0 until size && nextX in 0 until size && !visited[nextY][nextX]) {
                            visited[nextY][nextX] = true
                            q.add(nextY to nextX)
                        }
                    }
                }
                count++
            }
            return -1
        }
        println("Case #$i: ${bfs(r1 - 1, c1 - 1, r2 - 1, c2 - 1)}\n")
    }
}
